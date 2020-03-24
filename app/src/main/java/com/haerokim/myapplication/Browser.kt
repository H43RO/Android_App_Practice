package com.haerokim.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_browser.*

class Browser : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_browser)


        enterButton.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(insert.text.toString()))
            startActivity(intent)
        }

        //익명 함수
        insert.addTextChangedListener(object:TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
                Log.d("edit", "afterTextChanged : " + p0)
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.d("edit", "beforeTextChanged : " + p0)

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.d("edit", "onTextChanged : " + p0)

            }
        })
    }
}
