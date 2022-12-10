package com.example.tictactoegame

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.continueBtn)
        val player1name : EditText = findViewById(R.id.inputPlayer1)
        val player2name : EditText = findViewById(R.id.inputPlayer2)

        button.setOnClickListener {

            if(player1name.text.isEmpty())
            {
                Toast.makeText(this,"Enter the player name",Toast.LENGTH_SHORT).show()
            }
            if(player2name.text.isEmpty())
            {
                Toast.makeText(this,"Enter the player name",Toast.LENGTH_SHORT).show()
            }
            if(player1name.text.isNotEmpty() && player2name.text.isNotEmpty())
            {
            val intent = Intent(this, MainActivity2::class.java)
            val message1 =player1name.text.toString()
            val message2 = player2name.text.toString()
            val extras = Bundle()
            extras.putString("EXTRA_USERNAME1", message1)
            extras.putString("EXTRA_USERNAME2", message2)
            intent.putExtras(extras)
            startActivity(intent)
            }
        }

    }
}