package com.haerokim.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_thread.*

class ThreadActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)


        val runnable: Runnable = object : Runnable { //Thread에서 할 일을 만들고 Thread에 넣을 것
            override fun run() {
                Log.d("thread-1", "Thread1 is made")
            }
        }

        val thread: Thread = Thread(runnable) //runnable을 넣어줘야함임

        button.setOnClickListener {
            thread.start() // 버튼 클릭하면Thread를 실행시킴
        }


        //람다 방식
        Thread(object : Runnable {
            override fun run() {
                Log.d("thread-1", "Thread2 is made")
            }
        }).start()
        Thread(Runnable {
            Log.d("thread-1", "Thread3 is made")
            Thread.sleep(2000)//잠시 쓰레드를 쉬는 것 (2초동안)

            runOnUiThread {
                button.setBackgroundColor(getColor(R.color.colorPrimary))
            }
            // -> runOnUiThread 없이 하면 오류 발생 (Original Thread만 이 View를 변경가능)
        }).start()
    }
}
