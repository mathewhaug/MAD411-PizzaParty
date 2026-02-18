package com.zybooks.pizzaparty

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.ceil

private const val SLICES_PER_PIZZA = 8

class MainActivity : AppCompatActivity() {

    private lateinit var numAttendEditText: EditText
    private lateinit var hungryRadioGroup: RadioGroup
    private lateinit var numPizzasTextView: TextView
    private lateinit var calcButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Set the XML file we want to use
        setContentView(R.layout.activity_main)
        //Connect XML Views to Kotlin
        numAttendEditText = findViewById(R.id.num_attend_edit_text)
        hungryRadioGroup = findViewById(R.id.hungry_radio_group)
        numPizzasTextView = findViewById(R.id.num_pizzas_text_view)
        calcButton = findViewById(R.id.calc_button)

        calcButton.setOnClickListener {
            calculatePizzas()
        }
    }
    private fun calculatePizzas() {
        val numPeople = numAttendEditText.text.toString().toIntOrNull() ?: 0
        //Determine slices per person based on selected radio button
        val slicesPerPerson = when (hungryRadioGroup.checkedRadioButtonId) {
            R.id.light_radio_button -> 2
            R.id.medium_radio_button -> 3
            R.id.ravenous_radio_button -> 4
            else -> 3
        }

        val totalPizzas = ceil(
            numPeople * slicesPerPerson / SLICES_PER_PIZZA.toDouble()
        ).toInt()

        numPizzasTextView.text = "Total pizzas: $totalPizzas"
    }
}
