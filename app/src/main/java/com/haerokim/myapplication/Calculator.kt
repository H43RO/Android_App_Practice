package com.haerokim.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_calculator.*

class Calculator : AppCompatActivity() {

    var sum: String = "0"
    var num1: String = ""
    var num2: String = ""
    var mode : Boolean = false //true일시 + false일시 = 듕작


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        clearButton.setOnClickListener{
            sum="0"
            num1="0"
            num2="0"
            result.setText(sum)
        }

        plusButton.setOnClickListener{
           mode = !mode
            if(mode == true){
                num1 = sum
                sum = "0"
                result.setText(sum)
            }else{
                num2 = sum
                sum = (num1.toInt() + num2.toInt()).toString()
                result.setText(sum)
            }
        }

        one.setOnClickListener {
            if (sum == "0") sum = "1"
            else sum += "1"
            result.setText(sum)
        }

        two.setOnClickListener {
            if (sum == "0") sum = "2"
            else sum += "2"
            result.setText(sum)
        }
        three.setOnClickListener {
            if (sum == "0") sum = "3"
            else sum += "3"
            result.setText(sum)
        }
        four.setOnClickListener {
            if (sum == "0") sum = "4"
            else sum += "4"
            result.setText(sum)
        }
        five.setOnClickListener {
            if (sum == "0") sum = "5"
            else sum += "5"
            result.setText(sum)
        }
        six.setOnClickListener {
            if (sum == "0") sum = "6"
            else sum += "6"
            result.setText(sum)
        }
        seven.setOnClickListener {
            if (sum == "0") sum = "7"
            else sum += "7"
            result.setText(sum)
        }
        eight.setOnClickListener {
            if (sum == "0") sum = "8"
            else sum += "8"
            result.setText(sum)
        }
        nine.setOnClickListener {
            if (sum == "0") sum = "9"
            else sum += "9"
            result.setText(sum)
        }
        zero.setOnClickListener {
            if (sum == "0") sum = "0"
            else sum += "0"
            result.setText(sum)
        }
    }


}
