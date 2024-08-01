package com.junior.uts

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CurrencyConversionActivity : AppCompatActivity() {

    private lateinit var amountEditText: EditText
    private lateinit var conversionRadioGroup: RadioGroup
    private lateinit var convertButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currency)

        // Initialize views
        amountEditText = findViewById(R.id.amountEditText)
        conversionRadioGroup = findViewById(R.id.conversionRadioGroup)
        convertButton = findViewById(R.id.convertButton)
        resultTextView = findViewById(R.id.resultTextView)

        // Set up click listener for the convert button
        convertButton.setOnClickListener {
            convertCurrency()
        }
    }

    private fun convertCurrency() {
        val amountText = amountEditText.text.toString()
        if (amountText.isNotEmpty()) {
            val amount = amountText.toDouble()
            val selectedRadioButtonId = conversionRadioGroup.checkedRadioButtonId
            val conversionRate = 15000.0 // Example conversion rate: 1 USD = 15,000 IDR

            val result = when (selectedRadioButtonId) {
                R.id.usdToIdrRadioButton -> amount * conversionRate
                R.id.idrToUsdRadioButton -> amount / conversionRate
                else -> 0.0
            }

            resultTextView.text = "Result: %.2f".format(result)
        } else {
            resultTextView.text = "Please enter an amount"
        }
    }
}
