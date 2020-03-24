package com.haerokim.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_phone_book_with_recycler_view.*

class PhoneBookWithRecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_book_with_recycler_view)

        val phoneBook = createFakePhoneBook(30)
        val phoneBookRecyclerAdapter = PhoneBookRecyclerAdapter(phoneBook, LayoutInflater.from(this),this)
        phonebook_recycler_view.adapter = phoneBookRecyclerAdapter
        phonebook_recycler_view.layoutManager = LinearLayoutManager(this)

    }

    fun createFakePhoneBook(fakeNumber:Int = 10, phoneBook: PhoneBook = PhoneBook()) : PhoneBook{
        for(i in 0 until fakeNumber){
            phoneBook.addPerson(Person(""+i+"번째 사람",""+i+"번째 사람의 전화번호"))
        }
        return phoneBook
    }


}


class PhoneBookRecyclerAdapter(
    val phonebookList: PhoneBook,
    val inflater: LayoutInflater,
    val activity: Activity
) : RecyclerView.Adapter<PhoneBookRecyclerAdapter.ViewHolder>(){

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val personName :TextView
        init{
            personName = itemView.findViewById(R.id.person_name)
            itemView.setOnClickListener{
                val intent = Intent(activity,PhoneBookDetailActivity::class.java)

                intent.putExtra("name", phonebookList.personList.get(adapterPosition).name)
                intent.putExtra("number", phonebookList.personList.get(adapterPosition).number)

                //Appcompat Acitivity 상속이 안됐으므로, 전달받은 Acitivity를 이용해서 startActivity를 이용한다
                activity.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.phonebook_item,parent,false)
        return ViewHolder(view) //뷰홀더에 넣어서 리턴해야 재활용이 됨
    }

    override fun getItemCount(): Int { //phonebookList의 객체인 personList의 사이즈를 리턴
        return phonebookList.personList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.personName.setText(phonebookList.personList.get(position).name)
    }
}