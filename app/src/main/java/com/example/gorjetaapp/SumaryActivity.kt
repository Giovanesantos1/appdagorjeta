package com.example.gorjetaapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SumaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sumary)

        val totalTable = intent.getFloatExtra("totalTable", 0.0f)
        val numPeople = intent.getIntExtra("numpeople", 0)
        val percentage = intent.getIntExtra("percentage", 0)
        val totalAmount = intent.getFloatExtra("totalAmount", 0.0f)




    }
}