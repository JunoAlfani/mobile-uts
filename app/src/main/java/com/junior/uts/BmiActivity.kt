package com.junior.uts

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BmiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)

        val weightInput: EditText = findViewById(R.id.weightInput)
        val heightInput: EditText = findViewById(R.id.heightInput)
        val calculateBmiButton: Button = findViewById(R.id.calculateBmiButton)
        val bmiResult: TextView = findViewById(R.id.bmiResult)

        calculateBmiButton.setOnClickListener {
            val weightStr = weightInput.text.toString()
            val heightStr = heightInput.text.toString()

            if (weightStr.isNotEmpty() && heightStr.isNotEmpty()) {
                val weight = weightStr.toDoubleOrNull()
                val height = heightStr.toDoubleOrNull()

                if (weight != null && height != null && height > 0) {
                    // Konversi tinggi dari cm ke meter
                    val heightInMeters = height / 100.0
                    // Hitung BMI
                    val bmi = weight / (heightInMeters * heightInMeters)
                    bmiResult.text = String.format("Your BMI is: %.2f", bmi)
                } else {
                    bmiResult.text = "Please enter valid weight and height."
                }
            } else {
                bmiResult.text = "Please enter both weight and height."
            }
        }
    }
}
