package com.example.word_remember_app2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //val realm: Realm = Realm.getDefaultInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        val remember: Remember? = read()


        addedButton.setOnClickListener{
            val toAddedwordActivityIntent = Intent(this, AddedwordActivity::class.java)
                startActivity(toAddedwordActivityIntent)}

        addButton.setOnClickListener{
            val toAddwordActivityIntent = Intent(this, AddwordActivity::class.java)
                startActivity(toAddwordActivityIntent)}
    }

//    override fun onDestroy() {
//        super.onDestroy()
//        realm.close()
//    }
//
//    fun read():Remember?{
//        return realm.where(Remember::class.java).findFirst()
//    }
}