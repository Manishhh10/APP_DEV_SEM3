package com.example.myapplication_app
import android.os.Bundle
import android.widget.ImageView
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.myapplication_app.databinding.ActivityRadio2Binding

class RadioActivity2 : AppCompatActivity() {

    lateinit var mango: RadioButton
    lateinit var apple: RadioButton
    lateinit var grapes: RadioButton
    lateinit var image: ImageView

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityRadio2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_radio2)
        mango = findViewById(R.id.radioBtnMangoes)
        apple = findViewById(R.id.radioBtnApple)
        grapes = findViewById(R.id.radioBtnGrapes)
        image = findViewById(R.id.imageViewRadio)

        mango.setOnClickListener {
            image.setImageResource(R.drawable.mango)
        }
        apple.setOnClickListener {
            image.setImageResource(R.drawable.apple)
        }
        grapes.setOnClickListener {
            image.setImageResource(R.drawable.grapes)
        }
    }
}