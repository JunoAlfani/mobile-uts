package com.junior.uts

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.ExpressionBuilder

class CalculatorActivity : AppCompatActivity() {

    private lateinit var inputField: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        inputField = findViewById(R.id.inputField)

        val buttonIds = listOf(
            R.id.button0, R.id.button1, R.id.button2, R.id.button3,
            R.id.button4, R.id.button5, R.id.button6, R.id.button7,
            R.id.button8, R.id.button9, R.id.buttonAdd, R.id.buttonSubtract,
            R.id.buttonMultiply, R.id.buttonDivide, R.id.buttonClear, R.id.buttonEquals
        )

        buttonIds.forEach { id ->
            findViewById<Button>(id).setOnClickListener { onButtonClick(it) }
        }
    }

    private fun onButtonClick(view: View) {
        val button = view as Button
        when (button.id) {
            R.id.buttonClear -> inputField.text.clear()
            R.id.buttonEquals -> calculateResult()
            else -> inputField.append(button.text)
        }
    }

    private fun calculateResult() {
        try {
            val expression = inputField.text.toString()
            val result = evaluateExpression(expression)
            inputField.setText(result.toString())
        } catch (e: Exception) {
            inputField.setText("Error")
        }
    }

    private fun evaluateExpression(expression: String): Double {
        return try {
            val expression = ExpressionBuilder(expression).build()
            expression.evaluate()
        } catch (e: Exception) {
            Double.NaN
        }
    }
}
