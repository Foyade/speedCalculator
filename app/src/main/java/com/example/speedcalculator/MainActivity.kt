package com.example.speedcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView




class MainActivity : AppCompatActivity() {

    private lateinit var dist: EditText
    private lateinit var time: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dist = findViewById<View>(R.id.distanceInput) as EditText
        time = findViewById<View>(R.id.timeInput) as EditText
        val output: TextView = findViewById<View>(R.id.outputText) as TextView

        fun calcTime(dist: EditText, time: EditText ): Double {
            if (dist.text.toString().isEmpty() || time.text.toString().isEmpty()) {
                throw IllegalArgumentException("Point can't be null")
            }

            val distValue = dist.text.toString().toDouble()
            val timeValue = time.text.toString().toDouble()
            return distValue / timeValue
        }

        findViewById<Button>(R.id.supabutton)
            .setOnClickListener {
                Log.d("BUTTONS",
                    "User tapped the Supabutton")
                output.text = calcTime(dist,time).toString()
            }

    }
}