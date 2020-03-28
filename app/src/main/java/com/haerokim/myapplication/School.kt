package com.haerokim.myapplication

import io.realm.RealmObject

open class School:RealmObject(){

    //School이라는 Table의 Field
    var name : String?=null
    var location: String? = null
}