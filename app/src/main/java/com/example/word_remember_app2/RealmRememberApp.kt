package com.example.word_remember_app2

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class RealmRememberApp : Application() {
    override fun onCreate() {
        super.onCreate()

        Realm.init(this)

        val realmConfig = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(realmConfig)
    }
}