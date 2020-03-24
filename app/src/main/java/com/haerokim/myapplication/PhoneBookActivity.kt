package com.haerokim.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PhoneBookActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book)

        val phoneBook = createFakePhoneBook(30)
        createPhoneBookList(phoneBook)
    }

    fun createFakePhoneBook(fakeNumber:Int = 10, phoneBook: PhoneBook = PhoneBook()) : PhoneBook{
        for(i in 0 until fakeNumber){
            phoneBook.addPerson(Person(""+i+"번째 사람",""+i+"번째 사람의 전화번호"))
        }
        return phoneBook
    }

    fun createPhoneBookList(phoneBook: PhoneBook){
        val layoutInflater = LayoutInflater.from(this) //레이아웃 인플레이터 인스턴스화
        val container = findViewById<LinearLayout>(R.id.phonebook_list_container) //add_view를 담을 컨테이너
        for (i in 0 until phoneBook.personList.size){ //전화번호 개수 끝까지 반복
            val view = layoutInflater.inflate(R.layout.phonebook_item,null) //전화번호 itemView 를 인스턴스화
            val personNameView = view.findViewById<TextView>(R.id.person_name) //나타낼 전화번호 이름을 인스턴스화
            personNameView.setText(phoneBook.personList.get(i).name) //리스트 추가할때마다 이름을 설정해줌
            addSetOnClickListener(phoneBook.personList.get(i), view) //리스트 추가할때마다 리스너를 설정해줌 (intent)
            container.addView(view) //컨테이너에 뷰를 추가함
        }
    }

    fun addSetOnClickListener(person:Person, view: View){ //임의로 추가한 리스너 함수
        view.setOnClickListener{ //view를 누를 시에 이름, 폰번호를 넘기고 액티비티 이동
            val intent = Intent(this, PhoneBookDetailActivity::class.java)
            intent.putExtra("name", person.name)
            intent.putExtra("number", person.number)
            startActivity(intent)
        }
    }
}

class PhoneBook(){
    //전화번호 부
    val personList = ArrayList<Person>()

    fun addPerson(person:Person){
        personList.add(person)
    }
}

class Person(var name:String, var number: String){

}