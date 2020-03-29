package com.haerokim.myapplication

import android.content.Context
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_network.*
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class NetworkActivity : AppCompatActivity() {

    var personList = ArrayList<PersonFromServer>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network)

        NetworkTask(
            PersonListView,
            LayoutInflater.from(this@NetworkActivity)
        ).execute() //Async Task 실행

    }

    inner class NetworkTask(
        val recyclerView: RecyclerView,
        val inflater: LayoutInflater
    ) : AsyncTask<Any?, Any?, Array<PersonFromServer>>() {
        override fun onPostExecute(result: Array<PersonFromServer>?) {
            val adapter = PersonListAdapter(result!!, inflater)
            recyclerView.adapter = adapter
            super.onPostExecute(result)
        }

        override fun doInBackground(vararg p0: Any?): Array<PersonFromServer> {


            val urlString: String = "http://mellowcode.org/json/students/"
            val url: URL = URL(urlString) //URL로 만들어주는 작업
            val connection: HttpURLConnection = url.openConnection() as HttpURLConnection

            connection.requestMethod = "GET"
            connection.setRequestProperty("Content-Type", "application/json") //Json 통신 요청

            var buffer = ""
            if (connection.responseCode == HttpURLConnection.HTTP_OK) { //요청의 Status Code가 200인 경우에
                Log.d("conn", "inputstream : " + connection.inputStream)
                val reader = BufferedReader( //한글자씩 읽는게 아니라 뭉태기로 읽겠다 BufferedReader
                    InputStreamReader(
                        connection.inputStream,
                        "UTF-8"
                    )
                )
                buffer = reader.readLine() //UTF-8 로 사람이 알아볼 수 있는 형식으로 JSON 데이터를 불러옴
                Log.d("buffer", "buffer : " + buffer)

            }

            val data = Gson().fromJson(
                buffer,
                Array<PersonFromServer>::class.java
            ) //data 읽을 틀(PersonFromServer)을 넣어줌
            //여러 데이터가 들어오기 때문에 배열로 넣어줌
            Log.d("conn", "data : " + data)

            val age = data[0].age
            Log.d("conn", "age : " + age)

            return data
        }
    }

}

class PersonListAdapter(
    val itemList: Array<PersonFromServer>,
    val inflater: LayoutInflater
) : RecyclerView.Adapter<PersonListAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView
        val age: TextView
        val intro: TextView

        init {
            name = itemView.findViewById(R.id.name)
            age = itemView.findViewById(R.id.age)
            intro = itemView.findViewById(R.id.intro)

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PersonListAdapter.ViewHolder {
        val view = inflater.inflate(R.layout.item_view, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.setText(itemList.get(position).name.toString())
        holder.age.setText(itemList.get(position).age.toString())
        holder.intro.setText(itemList.get(position).intro.toString())

    }

    override fun getItemCount(): Int {
        return itemList.size
    }


}
