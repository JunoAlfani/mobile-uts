package com.junior.uts

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import java.util.Calendar

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Set up click listeners for the cards
        view.findViewById<View>(R.id.kalkulatorCard).setOnClickListener {
            activity?.let {
                val intent = Intent(it, CalculatorActivity::class.java)
                it.startActivity(intent)
            }
        }

        view.findViewById<View>(R.id.bmiCard).setOnClickListener {
            activity?.let {
                val intent = Intent(it, BmiActivity::class.java)
                it.startActivity(intent)
            }
        }

        view.findViewById<View>(R.id.checkboxCard).setOnClickListener {
            activity?.let {
                val intent = Intent(it, CheckBoxActivity::class.java)
                it.startActivity(intent)
            }
        }

        view.findViewById<View>(R.id.currencyCard).setOnClickListener {
            activity?.let {
                val intent = Intent(it, CurrencyConversionActivity::class.java)
                it.startActivity(intent)
            }
        }

        view.findViewById<View>(R.id.datePickerCard).setOnClickListener {
            showDatePickerDialog()
        }

        view.findViewById<View>(R.id.timePickerCard).setOnClickListener {
            showTimePickerDialog()
        }

        return view
    }

    private fun showDatePickerDialog() {
        // Mendapatkan tanggal saat ini
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        // Membuat DatePickerDialog
        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { _, selectedYear, selectedMonth, selectedDay ->
                // Tanggal yang dipilih
                val date = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                Toast.makeText(requireContext(), "Selected Date: $date", Toast.LENGTH_SHORT).show()
            },
            year, month, day
        )

        // Menampilkan DatePickerDialog
        datePickerDialog.show()
    }

    private fun showTimePickerDialog() {
        // Mendapatkan waktu saat ini
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        // Membuat TimePickerDialog
        val timePickerDialog = TimePickerDialog(
            requireContext(),
            { _, selectedHour, selectedMinute ->
                // Waktu yang dipilih
                val time = String.format("%02d:%02d", selectedHour, selectedMinute)
                Toast.makeText(requireContext(), "Selected Time: $time", Toast.LENGTH_SHORT).show()
            },
            hour, minute, true
        )

        // Menampilkan TimePickerDialog
        timePickerDialog.show()
    }
}
