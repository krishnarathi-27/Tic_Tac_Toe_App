package com.example.tictactoegame

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.winnerdialog.*

class MainActivity2 : AppCompatActivity() {

    var gameIsActive = true
    var username1_string = ""
    var username2_string = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val intent = intent
        val extras = intent.extras
        username1_string = extras!!.getString("EXTRA_USERNAME1").toString()
        username2_string = extras!!.getString("EXTRA_USERNAME2").toString()

        player1x.text = "$username1_string" + " :- X"
        player2O.text = "$username2_string" + " :- O"
        playerTurn.text = "$username1_string" + "'s Turn"
    }

    fun decide(view: View)
    {
        //cellid is used here to identify which button is selected
        var cellId = 0

        val buSelected = view as Button

        //switch case statement to get the id of the button selected in cellid

        when(buSelected.id)
        {
            R.id.b1 ->
                cellId =1       //we are storing button number in cell id so that the button clicked once is not clicked again
            R.id.b2 ->
                cellId = 2
            R.id.b3 ->
                cellId = 3
            R.id.b4 ->
                cellId = 4
            R.id.b5 ->
                cellId = 5
            R.id.b6 ->
                cellId = 6
            R.id.b7 ->
                cellId = 7
            R.id.b8 ->
                cellId = 8
            R.id.b9 ->
                cellId = 9

        }

        playGame(cellId, buSelected)
    }

    var activePlayer = 1
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    fun playGame(cellId: Int, buSelected : Button)
    {
            if(activePlayer == 1)
            {
                buSelected.text = "X"
                buSelected.setBackgroundResource(R.drawable.playbutton1)
                player1.add(cellId)
                activePlayer = 2
                playerTurn.text = "$username1_string" + "'s Turn"
            }else{
                buSelected.text = "O"
                buSelected.setBackgroundResource(R.drawable.playbutton2)
                player2.add(cellId)
                activePlayer = 1
                playerTurn.text = "$username2_string" + "'s Turn"
            }

        buSelected.isEnabled = false

        check()
    }

    fun check()
    {
        var winner = -1
        //row1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3))
        {
            winner = 1
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3))
        {
            winner = 2
        }

        //row2
        if(player1.contains(4) && player1.contains(5) && player1.contains(6))
        {
            winner = 1
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6))
        {
            winner = 2
        }

        //row3
        if(player1.contains(7) && player1.contains(8) && player1.contains(9))
        {
            winner = 1
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9))
        {
            winner = 2
        }

        //col1
        if(player1.contains(1) && player1.contains(4) && player1.contains(7))
        {
            winner = 1
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7))
        {
            winner = 2
        }

        //col2
        if(player1.contains(2) && player1.contains(5) && player1.contains(8))
        {
            winner = 1
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8))
        {
            winner = 2
        }

        //col3
        if(player1.contains(3) && player1.contains(6) && player1.contains(9))
        {
            winner = 1
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9))
        {
            winner = 2
        }

        //diag1
        if(player1.contains(1) && player1.contains(5) && player1.contains(9))
        {
            winner = 1
        }
        if(player2.contains(1) && player2.contains(5) && player2.contains(9))
        {
            winner = 2
        }

        //diag2
        if(player1.contains(3) && player1.contains(5) && player1.contains(7))
        {
            winner = 1
        }
        if(player2.contains(3) && player2.contains(5) && player2.contains(7))
        {
            winner = 2
        }

        if(winner == 1)
        {
            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.winnerdialog)
            dialog.result.text = "$username1_string wins the game"

            dialog.exitBtn.setOnClickListener {
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }

            dialog.plyBtn.setOnClickListener {
                val intent = Intent(this,MainActivity2::class.java)
                finish()
                startActivity(intent)
            }

            gameIsActive = false
            dialog.show()
        }
        else if(winner == 2)
        {
            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.winnerdialog)
            dialog.result.text = "$username2_string wins the game"

            dialog.exitBtn.setOnClickListener {
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }

            dialog.plyBtn.setOnClickListener {
                val intent = Intent(this,MainActivity2::class.java)
                finish()
                startActivity(intent)
            }
            gameIsActive = false
            dialog.show()
        }

        if(player1.size + player2.size == 9 && gameIsActive)
        {
            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.winnerdialog)
            dialog.result.text = "Draw"

            dialog.exitBtn.setOnClickListener {
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }

            dialog.plyBtn.setOnClickListener {
                val intent = Intent(this,MainActivity2::class.java)
                finish()
                startActivity(intent)
            }
            gameIsActive = false
            dialog.show()
        }

    }


}