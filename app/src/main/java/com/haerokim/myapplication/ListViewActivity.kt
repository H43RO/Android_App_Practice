//package com.haerokim.myapplication
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.BaseAdapter
//import android.widget.TextView
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//import kotlinx.android.synthetic.main.activity_list_view.*
//
//class ListViewActivity : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_list_view)
//
//        val carList = ArrayList<CarForList>()
//        for (i in 0 until 10) {
//            carList.add(CarForList("" + i + "번째 자동차", "" + i + "순위 엔진"))
//        }
//
//        val adapter = ListViewAdapter(carList,layoutInflater)
//        listView.adapter = adapter
//
//        listView.setOnItemClickListener { adapterView, view, i, l ->
//            val carName = (adapter.getItem(i) as CarForList).name
//            val carEngine = (adapter.getItem(i) as CarForList).engine
//
//            Toast.makeText(this,carName+" "+carEngine,Toast.LENGTH_SHORT).show()
//        }
//
//    }
//}
//
//class ListViewAdapter(
//    val carForList: ArrayList<CarForList>,
//    val layoutInflater: LayoutInflater
//) : BaseAdapter() {
//
//
//    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
//
//        val view:View
//        val holder: ViewHolder
//
//        if(p1 == null){ //findViewById는 리소스 용량이 크기 때문에 효율이 떨어질 수 도 있어서 처음에 보이는 뷰만 나타냄
//            view = layoutInflater.inflate(R.layout.item_view, null)
//            holder = ViewHolder()
//
//            holder.carName = view.findViewById(R.id.car_name)
//            holder.carEngine = view.findViewById(R.id.car_engine)
//
//            view.tag = holder
//        }else{ //이후에는 뷰홀더만 갖고와서 뷰를 재생하면서, 리소스 효율을 높일 수 있음 (눈에 보이지 않는 뷰에 대하여)
//            holder = p1.tag as ViewHolder
//            view = p1
//        }
//
//        holder.carName?.setText(carForList.get(p0).name)
//        holder.carEngine?.setText(carForList.get(p0).engine)
//
//        return view
//
////        val layoutInflater = LayoutInflater.from(context)
////        val view = layoutInflater.inflate(R.layout.item_view, null)
////
////        var carNameTextView = view.findViewById<TextView>(R.id.car_name)
////        var carEngineTextView = view.findViewById<TextView>(R.id.car_engine)
////
////        carNameTextView.setText(carForList.get(p0).name)
////        carEngineTextView.setText(carForList.get(p0).engine)
////
////        return view //AddView는 container.add(view)를 함
//    }
//
//
//    //그리고자 하는 아이템 리스트이 '하나' (p0에 해당하는)
//    override fun getItem(p0: Int): Any {
//        return carForList.get(p0)
//    }
//
//
//    //p0에 위치해있는 아이템 뷰의 아이디 설정
//    override fun getItemId(p0: Int): Long {
//        return p0.toLong()
//    }
//
//    //해당 리스트뷰의 전채 개수
//    override fun getCount(): Int {
//        return carForList.size
//    }
//}
//
//class ViewHolder{
//    var carName: TextView? = null
//    var carEngine: TextView? = null
//}