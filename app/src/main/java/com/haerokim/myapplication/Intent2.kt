package com.haerokim.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_intent2.*

class Intent2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent2)

        result2.setOnClickListener{

            val number1 = intent.getIntExtra("number1",1) //수신된 값 : 1
            val number2 = intent.getIntExtra("number2",1) //수신된 값 : 2

            Log.d("data",number1.toString()) //1
            Log.d("data",number2.toString()) //2

            val result = number1 + number2 //3


            val resultIntent = Intent(this@Intent2,Intent1::class.java)
            resultIntent.putExtra("result",result)
            setResult(Activity.RESULT_OK,resultIntent) //결과를 잘 받았음을 보내주는 코드 '-1' 를 첨부하는 함수 setResult()
            finish() //Activity 종료

        }
    }
}
