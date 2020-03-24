package com.haerokim.myapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_one.*

class FragmentOne : Fragment() {

    interface OnDataPassListener{
        fun onDataPass(data:String?)
    }

    //리스너 타입의 변수를 하나 만듦
    lateinit var dataPassListener : OnDataPassListener

//
//    override fun onAttach(context: Context?) {
//
//        Log.d("life_cycle", "F onAttach")
//        super.onAttach(context)
//        dataPassListener = context as OnDataPassListener
//
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("life_cycle", "F onCreate")
        super.onCreate(savedInstanceState)
    }



    override fun onCreateView(
        inflater: LayoutInflater, //뷰를 그려주는 Inflater
        container: ViewGroup?, //Fragment가 들어갈 부모 뷰
        savedInstanceState: Bundle?
    ): View? { //Fragment가 인터페이스를 처음으로 그릴 때 호출됨
        Log.d("life_cycle", "F onCreateView")

        val data = arguments?.getString("hello") //hello에 해당되는 데이터 받음
        Log.d("data", "hello")

        return inflater.inflate(R.layout.fragment_one, container, false)
    }


    //자체구현 리스너 (데이터 전달)를 부르는 곳 - 보통 여기서 주요 백그라운드 작업들을 함 ( = 액티비티의 onCreate() 와 같은 역할 )
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("life_cycle", "F onViewCreated")
        super.onViewCreated(view, savedInstanceState)

        pass.setOnClickListener{
            dataPassListener.onDataPass("GoodBye")
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d("life_cycle", "F onActivityCreated")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Log.d("life_cycle", "F onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d("life_cycle", "F onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d("life_cycle", "F onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d("life_cycle", "F onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.d("life_cycle", "F onDestroyView")
        super.onDestroyView()
    }

    override fun onDetach() {
        Log.d("life_cycle", "F onDetach")
        super.onDetach()
    }
}