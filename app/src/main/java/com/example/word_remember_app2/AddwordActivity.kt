package com.example.word_remember_app2

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_addword.*

class AddwordActivity : AppCompatActivity() {

    val realm: Realm = Realm.getDefaultInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addword)


        val spinner: Spinner = findViewById(R.id.groupSpinner)

        ArrayAdapter.createFromResource(
            this,
            R.array.planets_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        //　変数:○○　は変数の中に○○しか入れられない
        //rememberに入力した単語のデータが入っている
        val remember: Remember? = read()

        var groupAlf: String = "None"

        // リスナーを登録
        groupSpinner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            //　アイテムが選択された時
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val spinner = parent
                groupAlf = spinner?.selectedItem.toString()
            }

            //　アイテムが選択されなかった
            override fun onNothingSelected(parent: AdapterView<*>?) {
                //
            }
        })

        saveButton.setOnClickListener {
            val japanese: String = japaneseEditText.text.toString()
            val english: String = englishEditText.text.toString()
            val example: String = exampleEditText.text.toString()


            save(japanese, english, example, groupAlf)
        }

    }

    fun save(japanese: String, english: String, example: String, groupAlf: String) {
        val remember: Remember? = read()

        realm.executeTransaction {
            if (remember != null) {
                remember.japanese = japanese
                remember.english = english
                remember.example = example
                remember.group = groupAlf
            } else {
                val newRemember: Remember = it.createObject(Remember::class.java)
                newRemember.japanese = japanese
                newRemember.english = english
                newRemember.example = example
                newRemember.group = groupAlf
            }

            Snackbar.make(container, "保存しました", Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }

    //Remember.ktに保存した１番目のグループをread()に入れた
    fun read(): Remember? {
        return realm.where(Remember::class.java).findFirst()
    }
}