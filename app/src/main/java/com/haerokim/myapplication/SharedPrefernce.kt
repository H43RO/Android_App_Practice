package com.haerokim.myapplication

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_shared_prefernce.*

class SharedPrefernce : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_prefernce)

        //값을 저장하는 방법

        //Shared Preference
        //SharedPreference Mode Argument
        //  -MODE_PRIVATE : 생성한 application에서만 사용 가능
        //  -MODE_WORLD_REDABLE : 다른 application에서 사용가능 -> 읽기 전용
        //  -MODE_WORLD_WRITEABLE : 다른 application에서 사용가능 -> 쓰기 전용
        //  -MODE_MULTI_PROCESS : 이미 호출되어 사용중인지 체크
        //  -MODE_APPEND : 기존 Preference에 신규로 추가


        //sp1 -> SharedPreference
        //      (Key, Value -> "Hello", "안녕하세요")

        //sp2 -> SharedPreference
        //      (Key, Value -> "Hello", "안녕하세요")

        //내용이 같아도 아이디가 다르면 다른 Preference

        save_button.setOnClickListener {
            val sharedPrefernce = getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedPrefernce.edit()
            editor.putString("hello", "안녕하세요")
            editor.putString("goodbye", "안녕히가세요")

            editor.commit() //저장 마무리 단계
        }

        //값을 불러오는 방법
        load_button.setOnClickListener {
            val sharedPreference = getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val value1 = sharedPreference.getString("hello", "데이터 없음")
            val value2 = sharedPreference.getString("goodbye", "데이터 없음")

            Log.d("key-value", "Value : " + value1)
            Log.d("key-value", "Value : " + value2)
        }

        delete_button.setOnClickListener {
            val sharedPrefernce = getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val editor = sharedPrefernce.edit()
            editor.remove("hello")
            editor.commit()
        }

        delete_all_button.setOnClickListener {
            val sharedPrefernce = getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val editor = sharedPrefernce.edit()
            editor.clear()
            editor.commit()
        }
    }
}
