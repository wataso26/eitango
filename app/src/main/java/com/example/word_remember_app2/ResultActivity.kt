package com.example.word_remember_app2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val correct = intent.getIntExtra("Q_SCORE",0)


        val all = intent.getIntExtra("A_SCORE",0)

        val score = correct*all

        scoreVIew.setText(score)
    }
}