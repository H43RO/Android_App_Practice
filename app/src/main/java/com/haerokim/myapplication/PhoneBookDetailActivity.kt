package com.haerokim.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_phone_book_detail.*

class PhoneBookDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book_detail)
        getPersonInfoAndDraw()

        back.setOnClickListener{
            onBackPressed() // 뒤로가기 버튼과 같은 동작
        }
    }

    fun getPersonInfoAndDraw(){ //전달받은 정보로 View Component를 채워넣음
        val name = intent.getStringExtra("name")
        val number = intent.getStringExtra("number")

        person_detail_name.setText(name)
        person_detail_number.setText(number)
    }
}
