package com.example.gorjetaapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gorjetaapp.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

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
            val totalTableTemp = binding.numberOfPeople.text
            val nPeopleTemp = binding.numberOfPeople.text

            if (totalTableTemp?.isEmpty() == true ||
                nPeopleTemp?. isEmpty() == true)
                {
                Snackbar
                    .make(binding.tilTotal, "Preencha todos os campos", Snackbar.LENGTH_LONG)
                    .show()
            } else {
                val totalTable: Float = binding.tilTotal.text.toString().toFloat()
                val nPeople: Int = binding.numberOfPeople.text.toString().toInt()
                val totalTemp = totalTable / nPeople
                val tips = totalTemp * percentage / 100
                val totalWithTips = totalTemp + tips
                binding.tvResult.text = "Total width tips: $totalWithTips"
            }

            binding.btnClean.setOnClickListener {
                binding.tvResult.text = ""
                binding.tilTotal.setText("")
                binding.numberOfPeople.setText("")
                binding.rbOptionOne.isChecked = false
                binding.rbOptionTwo.isChecked = false
                binding.rbOptionThree.isChecked = false
            }

        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}