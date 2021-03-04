package com.suwon.calc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_start.*
import android.widget.Button
import android.widget.EditText

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        goButton.setOnClickListener{
            var player1 : String = "Player1"
            if( Player1.text.toString() != null ){
                player1 = Player1.text.toString()
            }

            var player2 : String = "Player2"
            if(Player2.text.toString() != null){
                player2 = Player2.text.toString()
            }

            val nextIntent = Intent(this,GameActivity::class.java)
            nextIntent.putExtra("player1",player1)
            nextIntent.putExtra("player2",player2)
            startActivity(nextIntent)
        }
    }
}
