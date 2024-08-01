package com.junior.uts

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class CheckBoxActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var termsCheckBox: CheckBox
    private lateinit var genderRadioGroup: RadioGroup
    private lateinit var submitButton: Button
    private lateinit var rootLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkbox)

        nameEditText = findViewById(R.id.nameEditText)
        emailEditText = findViewById(R.id.emailEditText)
        termsCheckBox = findViewById(R.id.termsCheckBox)
        genderRadioGroup = findViewById(R.id.genderRadioGroup)
        submitButton = findViewById(R.id.submitButton)
        rootLayout = findViewById(R.id.rootLayout)

        submitButton.setOnClickListener {
            submitForm()
        }
    }

    private fun submitForm() {
        val name = nameEditText.text.toString()
        val email = emailEditText.text.toString()
        val isTermsChecked = termsCheckBox.isChecked
        val selectedGenderId = genderRadioGroup.checkedRadioButtonId

        if (name.isNotEmpty() && email.isNotEmpty() && isTermsChecked) {
            val gender = when (selectedGenderId) {
                R.id.maleRadioButton -> "Male"
                R.id.femaleRadioButton -> "Female"
                else -> "Not Specified"
            }

            // Show Snackbar with form details
            Snackbar.make(rootLayout, "Name: $name, Email: $email, Gender: $gender", Snackbar.LENGTH_LONG).show()
        } else {
            // Show error Snackbar
            Snackbar.make(rootLayout, "Please fill in all fields and accept the terms", Snackbar.LENGTH_LONG).show()
        }
    }
}
