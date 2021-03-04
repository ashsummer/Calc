package com.suwon.calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.NumberPicker
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        player1_name.text = intent.getStringExtra("player1")
        player2_name.text = intent.getStringExtra("player2")
        player1_winner.text = intent.getStringExtra("player1")
        player2_winner.text = intent.getStringExtra("player2")

        //변수 셋팅
        var p1score = 0
        var p2score = 0
        var isgobak = false
        var ispibak = false
        var isshake = false
        var isgwangbak = false
        var winner = 0
        var go = 0
        var winnerscore = 0
        val zero = "0"

        player1_score.text = p1score.toString()
        player2_score.text = p2score.toString()


        //go 점수 셋팅
        gonumberpicker.wrapSelectorWheel = false
        gonumberpicker.descendantFocusability = NumberPicker.FOCUS_BLOCK_DESCENDANTS
        gonumberpicker.minValue = 0
        gonumberpicker.maxValue = 5

        calculatorButton.setOnClickListener{
            //값 셋팅
            isgobak = gobak_check.isChecked
            ispibak = pibak_check.isChecked
            isshake = shake_check.isChecked
            isgwangbak = gwang_check.isChecked

            //winner 셋팅
            winner = if(player1_winner.isChecked){
                1
            }else 2

            //몇고인지 셋팅
            go = gonumberpicker.value

            winnerscore = score.text.toString().toInt()

            when(go){
                1 -> winnerscore += 1
                2 -> winnerscore += 2
                3 -> winnerscore *= 2
                4 -> winnerscore *= 3
                5 -> winnerscore *= 5
            }

            if(isgobak){
                winnerscore *= 2
            }

            if(isgwangbak){
                winnerscore *= 2
            }

            if(ispibak){
                winnerscore *= 2
            }

            if(isshake){
                winnerscore *= 2
            }

            Toast.makeText(this@GameActivity,"당신의 점수는 {}점 입니다".format(winnerscore),Toast.LENGTH_SHORT).show()

            winnerscore *= money.text.toString().toInt()

            if(winner == 1){
                p1score += winnerscore
                p2score -= winnerscore
            }else{
                p1score -= winnerscore
                p2score += winnerscore
            }

            //점수 셋팅
            player1_score.text = p1score.toString()
            player2_score.text = p2score.toString()

            //다 리셋
            score.setText(null)
            pibak_check.setChecked(false)
            gobak_check.setChecked(false)
            gwang_check.setChecked(false)
            shake_check.setChecked(false)
            player1_winner.setChecked(false)
            player2_winner.setChecked(false)
            gonumberpicker.value = 0
        }

    }
}