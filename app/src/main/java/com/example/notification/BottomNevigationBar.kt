package com.example.notification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.notification.databinding.ActivityBottomNevigationBarBinding

class BottomNevigationBar : AppCompatActivity() {
    private lateinit var binding: ActivityBottomNevigationBarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomNevigationBarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        loadFragment(HomeFragment())
        binding.bottomNav.setOnItemSelectedListener() {
            when (it.itemId) {
                R.id.home ->
                    loadFragment(HomeFragment())

                R.id.message ->
                    loadFragment(MessageFragment())

                R.id.settings ->
                    loadFragment(SettingFragment())

                else -> {

                }
            }
            true

        }
    }

    private fun loadFragment(fragment: Fragment) {

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }
}