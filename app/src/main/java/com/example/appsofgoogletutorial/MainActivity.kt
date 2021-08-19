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
        buttonDiceApp.setOnClickListener{changeScene(1)}
    }

    private fun changeScene(select_app: Int){
        when(select_app){
            1 -> startActivity(Intent(this, DiceAppActivity::class.java))
        }

    }
}