package com.example.myapplication_app.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.myapplication_app.R
import com.example.myapplication_app.databinding.ActivityHomeBinding
import com.example.myapplication_app.ui.fragment.FirstFragment
import com.example.myapplication_app.ui.fragment.SecondFragment

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding // Correctly declare binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root) // Use binding.root to initialize the layout

        replaceFragment(FirstFragment())

        // Set up button listeners for fragment transactions
        binding.btnFirst.setOnClickListener {
//            supportFragmentManager.beginTransaction().apply {
//                replace(R.id.frame, FirstFragment())
//                addToBackStack(null) // Optional: Add to back stack for navigation
//                commit()
//            }
            replaceFragment(FirstFragment())
        }

        binding.btnSecond.setOnClickListener {
//            supportFragmentManager.beginTransaction().apply {
//                replace(R.id.frame, SecondFragment())
//                addToBackStack(null) // Optional: Add to back stack for navigation
//                commit()
//            }
            replaceFragment(SecondFragment())
        }

        // Handle edge-to-edge insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun replaceFragment(fragment : Fragment) {
        val fragmentManager : FragmentManager = supportFragmentManager
        val fragmentTransaction : FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame, fragment)
        fragmentTransaction.commit()
    }
}
