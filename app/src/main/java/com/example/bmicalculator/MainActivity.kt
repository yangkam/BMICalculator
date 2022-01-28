package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Refer to view
        //Input
        val editTextWeight = findViewById<EditText>(R.id.editTextWeight)
        val editTextHeight: EditText = findViewById(R.id.editTextHeight)

        //Output
        val textViewBMI: TextView = findViewById(R.id.textViewBMI)
        val textViewStatus: TextView = findViewById(R.id.textViewStatus)
        val imageViewBMI: ImageView = findViewById(R.id.imageViewBMI)

        //Interaction
        val buttonReset: Button = findViewById(R.id.buttonReset)
        val buttonCalculate: Button = findViewById(R.id.buttonCalculate)

        buttonCalculate.setOnClickListener {
            //Convert text to number
            val weight = editTextWeight.text.toString().toDouble()
            val height = editTextHeight.text.toString().toDouble()
            val bmi = weight/(height/100).pow(2)

            //<18.5 = underweight, 18.5 - 24.9 = normal, 24.9> = overweight

            if(bmi<18.5){
                textViewBMI.text = String.format("%.2f",bmi)
                textViewStatus.text = getString(R.string.under)
                imageViewBMI.setImageResource(R.drawable.under)
            }
            if(bmi>18.5 && bmi<24.9){
                textViewBMI.text = String.format("%.2f",bmi)
                textViewStatus.text = getString(R.string.normal)
                imageViewBMI.setImageResource(R.drawable.normal)
            }

            if(bmi>=24.9){
                textViewBMI.text = String.format("%.2f",bmi)
                textViewStatus.text = getString(R.string.over)
                imageViewBMI.setImageResource(R.drawable.over)
            }

        }

    }
}