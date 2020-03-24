package com.haerokim.myapplication

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ContextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_context)

        val context: Context = this //this (ContextActivity)라는 것은 Context의 자식이기 때문에 넣을 수 있음
        val applicationContext = getApplicationContext()
    }
}
