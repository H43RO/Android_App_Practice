//package com.haerokim.myapplication
//
//import android.os.Bundle
//import android.util.Log
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.appcompat.app.AppCompatActivity
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import kotlinx.android.synthetic.main.activity_recycler_view.*
//
//class RecyclerViewActivity : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_recycler_view)
//
//
//        val carList = ArrayList<CarForList>()
//        for (i in 0 until 10) {
//            carList.add(CarForList("" + i + "번째 자동차", "" + i + "순위 엔진"))
//        }
//
//        val adapter = RecyclerViewAdapter(carList, LayoutInflater.from(this))
//        recyclerView.adapter = adapter
//        recyclerView.layoutManager = LinearLayoutManager(this)
////        recyclerView.layoutManager = GridLayoutManager(this,2)
//
//    }
//}
//
//
////RecyclerView의 어댑터는 이렇게 동작한다
//
////onCreateViewHolder()가 먼저 호출되어, 아이템 하나가 들어갈 뷰를 만들어 ViewHolder에 넣는다
////ViewHolder에 들어간 아이템 뷰의 init 블럭이 돌아 이름과 엔진이 세팅이 된다
////그리고 세팅이 된 아이템들을 불러다가 onBindViewHolder()가 호출되어 setText가 이루어진다
//
//
//class RecyclerViewAdapter(
//     val itemList:ArrayList<CarForList>,
//    val inflater: LayoutInflater)
//    :RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){
//
//    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
//        val carName :TextView
//        val carEngine: TextView
//
//        init{
//            carName = itemView.findViewById(R.id.car_name)
//            carEngine = itemView.findViewById(R.id.car_engine)
//            itemView.setOnClickListener{
//                val position:Int  = adapterPosition //해당 itemView의 포지션을 갖고오는 변수 (기본 제공)
//                val engineName = itemList.get(position).engine //outer class의 itemList를 접근하기 위해 inner class 선언
//                Log.d("engine",engineName+"")
//            }
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = inflater.inflate(R.layout.item_view, parent, false)
//        return ViewHolder(view)
//
//    }
//
//    override fun getItemCount(): Int {
//        return itemList.size
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.carName.setText(itemList.get(position).name)
//        holder.carEngine.setText(itemList.get(position).engine)
//
//    }
//}