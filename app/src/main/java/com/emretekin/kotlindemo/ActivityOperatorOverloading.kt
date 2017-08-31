package com.emretekin.kotlindemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import com.emretekin.kotlindemo.Utils.Title

class ActivityOperatorOverloading : AppCompatActivity() {

    private lateinit var tvToolbar: TextView
    private lateinit var tvTitle: TextView
    private lateinit var tvTitle2: TextView
    private lateinit var tvTitle3: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_operator_overloading)
        createToolbar()

        tvTitle = findViewById(R.id.tvTitle) as TextView
        tvTitle2 = findViewById(R.id.tvTitle2) as TextView
        tvTitle3 = findViewById(R.id.tvTitle3) as TextView

        val t1 = Title("Title 1")
        val t2 = Title("Title 2")
        val titleCombine = t1.plusBasic(t2)
        val titleCombine2 = t1 plus t2
        val titleCombine3 = t1 + t2

        tvTitle.setText(titleCombine.value)
        tvTitle2.setText(titleCombine2.value)
        tvTitle3.setText(titleCombine3.value)
    }

    // Basic Extension
    fun Title.plusBasic(title: Title): Title {
        return Title(this.value + " " + title.value)
    }

    // Operator Overloading
    operator infix fun Title.plus(b2: Title): Title {

        return Title(this.value + " " + b2.value)
    }

    private fun createToolbar() {
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        tvToolbar = findViewById(R.id.tvToolbar) as TextView
        tvToolbar.setText("Operator Overloading Example")
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)
    }

    override fun onOptionsMenuClosed(menu: Menu?) {
        super.onOptionsMenuClosed(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            android.R.id.home -> {
                onBackPressed()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}


