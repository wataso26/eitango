package com.example.word_remember_app2

import io.realm.RealmObject

open class Remember (
    open var japanese: String = "",
    open var english: String = "",
    open var example: String = "",
    open var group: String = ""
) : RealmObject()