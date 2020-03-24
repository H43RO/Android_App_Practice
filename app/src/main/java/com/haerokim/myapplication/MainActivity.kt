package com.haerokim.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.practice_youtube)

        Log.d("life_cycle","onCraete")
    }

    override fun onStart(){
        super.onStart()
        Log.d("life_cycle","onStart")

    }

    override fun onResume(){
        super.onResume()
        Log.d("life_cycle","onResume")

    }

    override fun onPause() {
        super.onPause()
        Log.d("life_cycle","onPause")

    }

    override fun onStop() {
        super.onStop()
        Log.d("life_cycle","onStop")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("life_cycle","onDestroy")

    }
}
