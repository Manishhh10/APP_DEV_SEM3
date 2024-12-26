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
import com.example.myapplication_app.databinding.ActivityNotificationBinding
import com.example.myapplication_app.ui.fragment.FirstFragment
import com.example.myapplication_app.ui.fragment.HomeFragment
import com.example.myapplication_app.ui.fragment.NotificationFragment
import com.example.myapplication_app.ui.fragment.PersonFragment
import com.example.myapplication_app.ui.fragment.SearchFragment

class NotificationActivity : AppCompatActivity() {
    lateinit var binding: ActivityNotificationBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottom.setOnItemSelectedListener{
            when(it.itemId){
                R.id.navHome -> replaceFragment(HomeFragment())
                    R.id.navSearch -> replaceFragment(SearchFragment())
                        R.id.navNotification -> replaceFragment(NotificationFragment())
                            R.id.navPerson -> replaceFragment(PersonFragment())
                                else -> {}
            }
            true
        }

        binding.navHome.setOnClickListener {
            replaceFragment(FirstFragment())
        }

        binding.navSearch.setOnClickListener {
            replaceFragment(FirstFragment())
        }

        binding.navPerson.setOnClickListener {
            replaceFragment(FirstFragment())
        }

        binding.navNotification.setOnClickListener {
            replaceFragment(FirstFragment())
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager : FragmentManager = supportFragmentManager
        val fragmentTransaction : FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame, fragment)
        fragmentTransaction.commit()
    }


}