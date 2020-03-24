package com.haerokim.myapplication

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_resource.*

class ResourceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resource)

        //String resource 가져오기 1
        val ment = resources.getString(R.string.hello)
        Log.d("ment","ment : "+ ment)

        //String resource 가져오기 2
        val ment2 = getString(R.string.hello)
        Log.d("ment2","ment2 : "+ ment)


        //버전 호환 관리
        val color = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            button.setBackgroundColor(getColor(R.color.textColor))
        }else{
            button.setBackgroundColor(resources.getColor(R.color.textColor))

        }

        Log.d("color", "color : " + color)



    }

}
