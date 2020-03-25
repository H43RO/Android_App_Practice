package com.haerokim.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_fragment.*

class FragmentActivity : AppCompatActivity(), FragmentOne.OnDataPassListener {

    override fun onDataPass(data: String?) { //직접 만든 리스너 (Fragment -> Activity 데이터 전달
        Log.d("pass", ""+data)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        Log.d("life_cycle","onCreate")
        val fragmentOne : FragmentOne = FragmentOne() //공통 지역변수로 선언해줘야 띄우고 내리고를 동작시킬 수 있음
        
        //Fragment에 data를 넣어주는 방법
        val bundle:Bundle = Bundle()
        bundle.putString("hello", "hello")
        fragmentOne.arguments = bundle

        button.setOnClickListener{

            //Fragment를 동적으로 작동하는 방법
            val fragmentManager : FragmentManager = supportFragmentManager //매니저를 갖고와서 매니저 변수에 넣어줌  (필수)

            //Transaction
            //작업의 단위 -> 시작과 끝이 있다
            val fragmentTransaction = fragmentManager.beginTransaction() //트랜잭션의 시작을 알림
            fragmentTransaction.replace(R.id.container, fragmentOne) //할 일 replace, add 등


            //트랜잭션을 끝내는 방법 commit(), commitNow()
            fragmentTransaction.commit() //시간 될 때 해 -> 안정적
            //fragmentTransaction.commitNow() //지금 당장 실행
        }

        button2.setOnClickListener{
            val fragmentManager  = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.detach(fragmentOne) //detach() -> 다시 못 붙인다, remove() -> 다시 붙이려면 붙는다
            fragmentTransaction.commit()
        }
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
