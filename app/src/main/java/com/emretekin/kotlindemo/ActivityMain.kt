package com.emretekin.kotlindemo

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.*

class ActivityMain : AppCompatActivity() {

    private lateinit var tvToolbar: TextView
    private lateinit var btSimple: Button
    private lateinit var btRecursive: Button
    private lateinit var btExtansion: Button
    private lateinit var btOperatorOverloading: Button
    private lateinit var btInterface: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createViews()
        createToolbar()
        setListeners()
    }

    fun createToolbar() {
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        tvToolbar.setText("Kotlin 101")
    }

    fun createViews() {
        tvToolbar = findViewById(R.id.tvToolbar) as TextView
        btSimple = findViewById(R.id.btSimple) as Button
        btRecursive = findViewById(R.id.btRecursive) as Button
        btExtansion = findViewById(R.id.btExtansion) as Button
        btOperatorOverloading = findViewById(R.id.btOperatorOverloading) as Button
        btInterface = findViewById(R.id.btInterface) as Button

    }

    fun setListeners() {
        btSimple.setOnClickListener { startActivity(Intent(this, ActivitySimple::class.java)) }
        btRecursive.setOnClickListener { startActivity(Intent(this, ActivityRecursive::class.java)) }
        btExtansion.setOnClickListener { startActivity(Intent(this, ActivityExtension::class.java)) }
        btOperatorOverloading.setOnClickListener { startActivity(Intent(this, ActivityOperatorOverloading::class.java)) }
        btInterface.setOnClickListener { startActivity(Intent(this, ActivityInterface::class.java)) }
    }

}


