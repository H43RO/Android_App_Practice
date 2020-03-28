package com.haerokim.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlinx.android.synthetic.main.activity_realm.*

class RealmActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realm)

        Realm.init(this@RealmActivity)

        //Method Chaning Pattern (보통 Builder메소드에 많이 사용됨)

        //Realm Configuration을 만듦
        val config : RealmConfiguration = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded() //데이터베이스 동기화(Migration)가 필요하다면 Realm을 초기화한다
            .build()

        //만든 Configuration을 통해 Realm을 초기화함
        Realm.setDefaultConfiguration(config)

        val realm = Realm.getDefaultInstance() //realm 객체를 얻음

        button_save.setOnClickListener {
            realm.executeTransaction{
                //A Table에서 데이터를 가져온다 ->10 (내가 가져올때 10이었는데 작업 끝날때 9로 바뀌면 문제가 됨)
                //B Table에서 데이터를 가져온다 -> 따라서 이 작업을 한 작업단위로 처리하여 값이 변경안되게 함 (executeTransaction)
                //C Table에서 데이터를 가져온다
                //조합을 한다
                //D Table에 저장을 한다

                with(it.createObject(School::class.java)){
                    this.name = "순천향대학교"
                    this.location = "충남"
                }
            }
        }

        button_load.setOnClickListener {
            realm.executeTransaction{
                //Realm의 Table위치를 접근 (Realm.where(School::class.java)
                val data = it.where(School::class.java).findFirst()
                Log.d("dataa","data = "+data)
            }
        }
        button_delete.setOnClickListener {
            realm.executeTransaction{
                it.where(School::class.java).findAll().deleteAllFromRealm() //전원 삭제
            }
        }
    }
}
