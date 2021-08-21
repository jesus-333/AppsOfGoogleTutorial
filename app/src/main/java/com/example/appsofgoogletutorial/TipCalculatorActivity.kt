package com.example.appsofgoogletutorial

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appsofgoogletutorial.databinding.ActivityTipCalculatorBinding
import java.text.NumberFormat
import kotlin.math.ceil

class TipCalculatorActivity : AppCompatActivity() {
    // Declare View Binding
    private lateinit var binding: ActivityTipCalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTipCalculatorBinding.inflate(layoutInflater)

        // Load the root of layout inside the binding variable (i.e. load the layout)
        setContentView(binding.root)

        // Add the calculateTip() function to the button
        binding.calculateTipButton.setOnClickListener { calculateTip() }
    }

    private fun calculateTip() {
        // Retrieve the cost of the service
        val costOfService: Double? = binding.costOfService.text.toString().toDoubleOrNull()

        // block the scrip if the field is empty or a non valid string is typed
        if(costOfService == null){
            Toast.makeText(this, R.string.error_message_tip_app, Toast.LENGTH_SHORT).show()
            binding.tipResult.text = ""
            return
        }

        // Select the percentage of the tip
        val tipPercentage = when (binding.tipOptions.checkedRadioButtonId) {
            R.id.option_eighteen_percent -> 0.18
            R.id.option_fifteen_percent -> 0.15
            else -> 0.20
        }

        // Evaluate tip
        val tip = if (binding.roundUpSwitch.isChecked) {
            ceil(costOfService * tipPercentage)
        } else {
            costOfService * tipPercentage
        }

        // Format to currency value
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)

        // Display the tip
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
    }
}