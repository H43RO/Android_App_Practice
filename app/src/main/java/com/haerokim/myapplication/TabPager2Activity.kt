package com.haerokim.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_tab_pager.*

class TabPager2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_pager)

        tab_layout.addTab(tab_layout.newTab().setText("ONE"))
        tab_layout.addTab(tab_layout.newTab().setText("TWO"))
        tab_layout.addTab(tab_layout.newTab().setText("THREEE"))

        val adapter = ThreePageAdapter(LayoutInflater.from(this))
        view_pager.adapter = adapter
        view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))


        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }


            //탭이 선택됐을 때 탭을 이동시키는 코드
            override fun onTabSelected(tab: TabLayout.Tab?) {
                view_pager.currentItem = tab!!.position

            }
        })
    }
}

class ThreePageAdapter(
    val layoutInflater: LayoutInflater
) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        when (position) {
            0 -> {
                val view = layoutInflater.inflate(R.layout.fragment_one, container, false)
                container.addView(view)
                return view
            }

            1 -> {
                val view = layoutInflater.inflate(R.layout.fragment_two, container, false)
                container.addView(view)
                return view
            }

            2 -> {
                val view = layoutInflater.inflate(R.layout.fragment_three, container, false)
                container.addView(view)
                return view
            }

            else -> {
                val view = layoutInflater.inflate(R.layout.fragment_one, container, false)
                container.addView(view)
                return view
            }
        }
    }


    //내가 작성한 뷰가 맞냐 (Boolean)                //자바에 object는 별 의미가 없으나 코틀린에서는 키워드이기때문이다
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as View // ' === ' 는 주소값까지 비교하여 완전히 같은 뷰인지 확인할 수 있음
    }

    override fun getCount(): Int {
        return 3
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

}