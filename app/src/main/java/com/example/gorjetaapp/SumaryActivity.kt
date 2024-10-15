package com.example.gorjetaapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gorjetaapp.databinding.ActivitySumaryBinding

class SumaryActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySumaryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySumaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val totalTable = intent.getFloatExtra("totalTable", 0.0f)
        val numPeople = intent.getIntExtra("numpeople", 0)
        val percentage = intent.getIntExtra("percentage", 0)
        val totalAmount = intent.getFloatExtra("totalAmount", 0.0f)

        binding.tvTotalTable.text = totalTable.toString()
        binding.tvNumPeople.text = numPeople.toString()
        binding.tvPercentage.text = percentage.toString()
        binding.tvTotalAmount.text = totalAmount.toString()

        binding.btnRefresh.setOnClickListener {
            finish()
        }




    }
}