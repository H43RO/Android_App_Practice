package com.haerokim.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_intent.*

class Intent1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        change_activity.setOnClickListener{


            //명시적 인텐트

//            val intent = Intent(this@Intent1, Intent2::class.java)
//
//            //Key, Value 방식으로 정보를 전달할 수 있음 (Dictionary 방식)
//            intent.putExtra("number1",1)
//            intent.putExtra("number2",2)
//
//            //val intent = Intent(this, Intent2::class.java) 와 동일함
//
//            startActivity(intent)

             //startActivity(Intent(this,Intent2::class.java))

            val intent2 = Intent(this@Intent1, Intent2::class.java) //원하는 Intent 동작 클래스 생성
            intent2.apply{ //Intent2에 무슨 작업을 했는지 한번에 다 보여줌 (가독성 증가)
                this.putExtra("number1",1) //1이라는 값을 intent2 activity에 보낼 것
                this.putExtra("number2",2) //2이라는 값을 intent2 activity에 보낼 것
            }

            //보통 startActivity(intent)와 같은 형식이지만, 데이터를 주고받을 때는 startActivityForResult(intent, requestCode) 사용
            startActivityForResult(intent2,200) //여러 액티비티에서 intent2로 이동할 수 있으니 구분하기 위한 requestCode


            //암시적 인텐트
//            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"))
//            startActivity(intent)
        }
    }

    //수신받은 RequestCode로 구분가능
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) { //intent2에서 넘긴 결과 처리
        Log.d("number",requestCode.toString()) //우리는 200으로 지정했었음
        Log.d("number", resultCode.toString()) //문제없이 송수신이 됐으므로 -1 이 수신됐을 것
        val result = data?.getIntExtra("result", 0) //그쪽에서 result라는 이름으로 1+2를 한 값인 3을 보냄
        Log.d("number", result.toString()) //3이 출력될 것

        super.onActivityResult(requestCode, resultCode, data)
    }
}
