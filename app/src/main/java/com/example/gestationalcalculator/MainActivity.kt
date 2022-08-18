package com.example.gestationalcalculator

import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btn_calc)
        btn.setOnClickListener {
            calcBirthDate()
        }
    }

    private fun calcBirthDate() {
        val _menstruationDate = findViewById<DatePicker>(R.id.menstruationDate)
        val result = findViewById<TextView>(R.id.result)


        var sdf = SimpleDateFormat("yyyy-MM-dd")
        val c = Calendar.getInstance()
        c.setTime(sdf.parse("${_menstruationDate.year.toString()}-${(_menstruationDate.month + 1).toString()}-${_menstruationDate.dayOfMonth.toString()}"))

        c.add(Calendar.DATE, 269);

        sdf = SimpleDateFormat("dd/MM/yyyy")
        var dataPrevista = Date(c.timeInMillis)
        val startDate = sdf.format(dataPrevista)

        c.add(Calendar.DATE, 11);
        sdf = SimpleDateFormat("dd/MM/yyyy")
        dataPrevista = Date(c.timeInMillis)
        val endDate = sdf.format(dataPrevista)

        result.text = "Seu bebê vai nascer entre \n${startDate} e ${endDate}"

    }
}