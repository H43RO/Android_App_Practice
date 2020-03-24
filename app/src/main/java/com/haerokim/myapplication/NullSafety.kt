package com.haerokim.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class NullSafety : AppCompatActivity() {


    lateinit var lateCar: Car //나중에 초기화해도됨 (그치만 사용하기 전까지 초기화 안하면 에러남)

    class Car(var number:Int){

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_null_safety)

        val number : Int = 10
        val number1 : Int? = null

        val number3 = number1?.plus(number)
        Log.d("number3", "number3 : "+number3)

        //삼항 연산자 -> 엘비스 연산자 (Null Safety를 위한 문법)
        val number4 = number1 ?: 10 //number1이 null이면 10, 아니면 그냥 number1 값이 들어갈 것
        Log.d("number4", "number4 : "+number4)

        lateCar = Car(10)
        Log.d("number", "late number : "+ lateCar.number)

    }

    fun plus(a:Int, b:Int?):Int{
        if(b!=null) return a + b
        else return a
    }

    fun plus2(a:Int, b:Int?):Int?{ //return이 null이 될 수 있으므로 null safety처리 해야함
        return b?.plus(a)
    }
}
