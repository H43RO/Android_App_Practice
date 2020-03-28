package com.haerokim.myapplication

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_async.*
import java.lang.Exception

class AsyncActivity : AppCompatActivity() {
    var task: BackgroundAsyncTask? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async)

        start.setOnClickListener {
            task = BackgroundAsyncTask(progressbar, ment)
            task?.execute() //출발
        }

        stop.setOnClickListener {
            task?.cancel(true)
        }
    }

    override fun onPause() { //액티비티가 멈췄을 때 Async가 멈출 수 있게 함
        task?.cancel(true)
        super.onPause()
    }
}


class BackgroundAsyncTask(
    val progressbar: ProgressBar,
    val progressText: TextView
) : AsyncTask<Int, Int, Int>() {
    // params -> doInBackground 에서 사용할 타입
    // progress -> onProgressUpdate 에서 사용할 타입
    // result -> onPostExecute 에서 사용할 타입

    var percent: Int = 0

    override fun onPreExecute() {
        percent = 0
        progressbar.setProgress(percent)
    }

    override fun doInBackground(vararg p0: Int?): Int { //params에서 Int라고 명시하였기 때문)
        while (isCancelled() == false) {
            percent++
            Log.d("async", "percent = " + percent)
            if (percent > 100) {
                break
            } else {
                publishProgress(percent) //MainThread로 percent 라는 결과값을 전송함
            }

            try {
                Thread.sleep(50)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return percent
    }


    override fun onProgressUpdate(vararg values: Int?) { //progress에서 Int라고 명시하였기 때문)
        progressbar.setProgress(values[0] ?: 0) //elvis 연산자
        progressText.setText("Percent : " + values[0])
        super.onProgressUpdate(*values)
    }

    override fun onPostExecute(result: Int?) { //result에서 Int라고 명시하였기 때문)
        progressText.setText("작업이 완료되었습니다.")

    }

    override fun onCancelled() {
        progressbar.setProgress(0)
        progressText.setText("작업이 취소되었습니다.")
    }
}