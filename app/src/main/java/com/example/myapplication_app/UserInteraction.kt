package com.example.myapplication_app

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class UserInteraction : AppCompatActivity() {

    lateinit var  toastBtn: Button
    lateinit var  snackBtn: Button
    lateinit var  alertBtn: Button
    lateinit var main: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_interaction)

        toastBtn = findViewById(R.id.btnToast)
        snackBtn = findViewById(R.id.btnSnack)
        alertBtn = findViewById(R.id.btnAlert)
        main = findViewById(R.id.main)

        toastBtn.setOnClickListener {
            Toast.makeText(this@UserInteraction,
            "Invalid Login",
            Toast.LENGTH_LONG
            ).show()
        }

        snackBtn.setOnClickListener {
            Snackbar.make(main,
                "No Internet Connection",
                Snackbar.LENGTH_LONG
            ).setAction("Retry", {
                //logic - what happens when user click on retry
            }).show()
        }

        alertBtn.setOnClickListener {
            val alert = AlertDialog.Builder(this@UserInteraction)

            alert.setTitle("Confirm")
                .setMessage("Are you sure?")
                .setIcon(R.drawable.apple)
                .setPositiveButton("Yes",DialogInterface.OnClickListener
                { dialogInterface, i ->
                    // when user click on yes - logic
                })
                .setNegativeButton("No",DialogInterface.OnClickListener
                { dialogInterface, i ->
                    dialogInterface.dismiss()
                })
            alert.create().show()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}