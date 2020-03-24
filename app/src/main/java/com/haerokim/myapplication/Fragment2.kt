package com.haerokim.myapplication


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class Fragment2(): Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater, //뷰를 그려주는 Inflater
        container: ViewGroup?, //Fragment가 들어갈 부모 뷰
        savedInstanceState: Bundle?
    ): View? { //Fragment가 인터페이스를 처음으로 그릴 때 호출됨
        Log.d("life_cycle", "F onCreateView")


        return inflater.inflate(R.layout.fragment_two, container, false)
    }

}