package com.emretekin.kotlindemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.emretekin.kotlindemo.Utils.OperationInterface

class ActivityInterface : AppCompatActivity() {

    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interface)

        tvResult = findViewById(R.id.tvResult) as TextView

        var user: OperationInterface = OperationInterface()


        var s: String
        s = user.plus(5, 2).toString()
        tvResult.setText(s)

    }
}
