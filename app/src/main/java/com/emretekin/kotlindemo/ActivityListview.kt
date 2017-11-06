package com.emretekin.kotlindemo

import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView

class ActivityListview : AppCompatActivity() {

    lateinit var mListview: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listview)

        mListview = findViewById(R.id.listView) as ListView
        mListview.adapter = ActivityListview.MyAdapter(this)
    }

    private class MyAdapter(context: Context) : BaseAdapter() {

        private val mContext: Context

        init {
            mContext = context;
        }

        override fun getCount(): Int {
            return 15
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getItem(position: Int): Any {
            return "TEST STRING"
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val textView = TextView(mContext)
            textView.text = "My Row"
            return textView
        }
    }
}
