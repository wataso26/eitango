package com.example.word_remember_app2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_addedword.*

class AddedwordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addedword)

        var lyric = "verb"

        verbButton.setOnClickListener{
            lyric = "verb"
            Intent(lyric)
        }

        nounButton.setOnClickListener{
            lyric = "noun"
            Intent(lyric)
        }

        adjectiveButton.setOnClickListener{
            lyric = "adjective"
            Intent(lyric)
        }

    }

    private fun Intent(lyric: String) {
        val intent = Intent(this, QuestionActivity::class.java).apply {
            putExtra("LYRIC", lyric)
        }
        startActivity(intent)
    }

}
