package com.haerokim.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)

//            http://mellowcode.org/json/students/
//            http://mellowcode.org/test/code/

        val retrofit = Retrofit.Builder()
            .baseUrl("http://mellowcode.org/") //URL중 변하지 않는 부분
            .addConverterFactory(GsonConverterFactory.create()) //.create()해야 만들어짐
            .build()

        //BaseURL 제외 나머지 말단 (json/students 등) 을 관리할 수 있는 RetrofitService를 만듦
        val service = retrofit.create(RetrofitService::class.java) //service를 통해 데이터 통신이 가능해짐


        //GET 요청
        service.getStudentsList().enqueue(object : Callback<ArrayList<PersonFromServer>> {

            //통신 실패 시
            override fun onFailure(call: Call<ArrayList<PersonFromServer>>, t: Throwable) {
                Log.d("retrofitt", "ERROR")

            }

            //통신 성공 시
            override fun onResponse(
                call: Call<ArrayList<PersonFromServer>>,
                response: Response<ArrayList<PersonFromServer>>
            ) {
                if (response.isSuccessful) { //200번대 코드가 응답되었을 때 (정상 통신이 됐을 때)
                    val personList = response.body() //자동 converting
                    Log.d("retrofitt", "RES : " + personList?.get(0)?.age)

                    val code = response.code()
                    Log.d("retrofitt", "CODE : " + code)

                    val error = response.errorBody()
                    val header = response.headers()
                    Log.d("retrofitt", "HEADER :" + header)

                }
            }
        })

//        //POST 요청 - Hash Map 사용
//        val params = HashMap<String,Any>()
//        params.put("name","문재인")
//        params.put("age",20)
//        params.put("intro","문재앙")
//        service.createStudent(params).enqueue(object:Callback<PersonFromServer>{
//            override fun onFailure(call: Call<PersonFromServer>, t: Throwable) {
//
//            }
//
//            override fun onResponse(
//                call: Call<PersonFromServer>,
//                response: Response<PersonFromServer>
//            ) {
//                if(response.isSuccessful){
//                    val person = response.body()
//                    Log.d("retrofitt","name : "+person?.name)
//                }
//            }
//        })

        //POST 요청 (2) - 객체를 직접 넣는 방법
        val person = PersonFromServer(name = "박근혜", age = 12, intro = "503")
        service.createStudent(person).enqueue(object:Callback<PersonFromServer>{
            override fun onFailure(call: Call<PersonFromServer>, t: Throwable) {
            }
            override fun onResponse(
                call: Call<PersonFromServer>,
                response: Response<PersonFromServer>
            ) {
                if(response.isSuccessful){
                    val person = response.body()
                    Log.d("retrofitt","name : "+person?.name)
                }
            }
        })

    }
}