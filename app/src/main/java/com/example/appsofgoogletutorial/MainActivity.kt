package com.example.appsofgoogletutorial

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonDiceApp: Button = findViewById(R.id.buttonDiceApp)
        buttonDiceApp.setOnClickListener { changeScene(1) }

        val buttonTipCalculatorApp: Button = findViewById(R.id.buttonTipCalculatorApp)
        buttonTipCalculatorApp.setOnClickListener { changeScene(2) }

        val buttonStyleAndThemeApp: Button = findViewById(R.id.buttonStyleAndThemeApp)
        buttonStyleAndThemeApp.setOnClickListener { changeScene(3) }
    }

    private fun changeScene(select_app: Int) {
        //Toast.makeText(this, "${select_app}", Toast.LENGTH_SHORT).show()
        when (select_app) {
            1 -> startActivity(Intent(this, DiceAppActivity::class.java))
            2 -> startActivity(Intent(this, TipCalculatorActivity::class.java))
            3 -> startActivity(Intent(this, StyleAndThemeActivity::class.java))
        }

    }
}