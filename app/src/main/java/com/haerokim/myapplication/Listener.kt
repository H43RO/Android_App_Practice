package com.haerokim.myapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_listener.*

class Listener : AppCompatActivity() {


    var number = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listener)

        // 뷰를 Acitivity로 가져오는 방법
        // 1) 직접 찾아서 가져온다
        //  -> val textView : TextView = findViewById(R.id.hello)
        // 2) xml을 import해서 가져온다
        //  -> hello 자동완성 이용


        // 익명함수

        // 1. 람다 방식
        hello.setOnClickListener {
            Log.d("click", "Click!")
        }


        // 2. 익명함수 방식
        hello.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v:View?){
                Log.d("click","Click!")
            }
        })

        // 3. 이름이 필요한 경우 (click)
        val click = object : View.OnClickListener{
            override fun onClick(v: View?) {
                hello.setText("안녕하세용")
                image.setImageResource(R.drawable.image)
                number+=10
                Log.d("number", number.toString())
            }
        }
        hello.setOnClickListener(click)


        //3 -> 2-> 1 순으로 진화하는 익명함수

        //뷰를 조작하는 함수들
        // 1>SetText
        // 2>setImageResource


    }
}
