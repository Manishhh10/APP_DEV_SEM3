package com.example.myapplication_app

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text


class SpinnerActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener {
    lateinit var spinner: Spinner
    lateinit var autoCompleteTextView: AutoCompleteTextView
    lateinit var display: TextView
    lateinit var datePicker: EditText
    val countries = arrayOf("Nepal", "China", "India", "US", "Canada", "Australia")

    val cities = arrayOf("Kathmandu", "Lalitpur", "Bhaktapur", "Kanchanpur", "Chitwan")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_spinner)
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView)
        spinner = findViewById(R.id.spinner)
        display = findViewById(R.id.displaySpinner)
        datePicker = findViewById(R.id.editTextDate)

        datePicker.isFocusable = false
        datePicker.isClickable = true

        datePicker.setOnClickListener {
            loadCalendar()
        }

        var autoCompleteAdapter = ArrayAdapter(
            this@SpinnerActivity,
            android.R.layout.simple_dropdown_item_1line,
            cities
        )
        autoCompleteTextView.setAdapter(autoCompleteAdapter)
        autoCompleteTextView.threshold = 1

        var adapter = ArrayAdapter(
            this@SpinnerActivity,
            android.R.layout.simple_spinner_item,
            countries
        )

        spinner.onItemSelectedListener = this
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun loadCalendar(){
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val dialog = DatePickerDialog(
            this@SpinnerActivity,
            DatePickerDialog.OnDateSetListener
            { d, year, month, day ->
                          //2024  05   01
                datePicker.setText("$day/${month+1}/$day")
            },year,month,day
        )
        dialog.show()
    }

    override fun onItemSelected(p0: AdapterView<*>?, view: View?, p2: Int, p3: Long) {
        display.text =p0?.getItemAtPosition(p2).toString()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}