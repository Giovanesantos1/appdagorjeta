package com.example.gorjetaapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gorjetaapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        var percentage: Int = 0
        binding.rbOptionOne.setOnCheckedChangeListener { _, isCheked ->
            if (isCheked)
                percentage = 10
        }

        binding.rbOptionTwo.setOnCheckedChangeListener { _, isCheked ->
            if (isCheked)
                percentage = 15
        }

        binding.rbOptionThree.setOnCheckedChangeListener { _, ischeked ->
            if (ischeked)
                percentage = 20
        }

        binding.btnClean.setOnClickListener {
            println(binding.tilTotal.text)
            println(binding.numberOfPeople.text)
        }

        binding.btnDone.setOnClickListener {
            val totalTable: Float = binding.tilTotal.text.toString().toFloat()
            val nPeople: Float = binding.numberOfPeople.text.toString().toFloat()

            val totalTemp = totalTable / nPeople
            val tips = totalTemp * percentage / 100
            val totalWithTips = totalTemp + tips
            binding.tvResult.text = "Total width tips: $totalWithTips"
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}