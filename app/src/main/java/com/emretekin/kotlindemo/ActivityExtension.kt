package com.emretekin.kotlindemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import com.emretekin.kotlindemo.Utils.OgrenciKotlin

class ActivityExtension : AppCompatActivity() {

    private lateinit var tvToolbar: TextView
    private lateinit var tvResult: TextView
    private lateinit var tvResult2: TextView
    private lateinit var tvResult3: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extension)

        createToolbar()

        // createviews
        tvToolbar = findViewById(R.id.tvToolbar) as TextView
        tvResult = findViewById(R.id.tvResult) as TextView
        tvResult2 = findViewById(R.id.tvResult2) as TextView
        tvResult3 = findViewById(R.id.tvResult3) as TextView


        //setData
        var firstNumber = 5
        tvResult.setText(firstNumber.factorialCalculateExt().toString())

        var text = "Emre     Tekin \t Kotlin Example"
        tvResult2.setText(text.editSpace())


        var emre = OgrenciKotlin()
        emre.ability = "Android & Kotlin"
        tvResult3.setText(emre.ability.toString())

    }

    fun factorialCalculate(number: Int): Int{

        var result = 1
        for (i in 1..number)
            result = result * i

        return result
    }

    // Extension to Integer class
    fun Int.factorialCalculateExt(): Int{

        var result = 1
        for (i in 1..this)
            result = result * i

        return result
    }

    fun String.editSpace(): String{

        var regex = Regex("\\s+")
        return regex.replace(this, " ")
    }

    private fun createToolbar() {
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        tvToolbar = findViewById(R.id.tvToolbar) as TextView
        tvToolbar.setText("Extension Example")
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
