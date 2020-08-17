package com.harshal.bindingdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.harshal.bindingdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.controlButton.setOnClickListener {
            startOrStopProgressBar()
            binding.student = getStudent()

        }

    }

    private fun startOrStopProgressBar() {
        if (binding.progressBar.visibility == View.GONE) {
            binding.progressBar.visibility = View.VISIBLE
            binding.controlButton.text = "Stop"
        } else {
            binding.progressBar.visibility = View.GONE
            binding.controlButton.text = "Start"
        }
    }

    private fun getStudent(): Student {
        return Student(1, "Harshal", "Harshal@gmail.com")
    }
}

