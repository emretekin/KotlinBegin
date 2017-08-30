package com.emretekin.kotlindemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import java.math.BigInteger

class ActivityRecursive : AppCompatActivity() {

    private lateinit var tvToolbar: TextView
    private lateinit var tvResult: TextView
    private lateinit var tvFibonacciResult: TextView
    private lateinit var tvFibonacciTailResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recursive)

        createToolbar()
        tvResult = findViewById(R.id.tvResult) as TextView
        tvFibonacciResult = findViewById(R.id.tvFibonacciResult) as TextView
        tvFibonacciTailResult = findViewById(R.id.tvFibonacciTailResult) as TextView


        val result = factorialCalculate(5)
        fibonacciTailRecursive(50, BigInteger.ONE, BigInteger.ZERO)

        tvResult.setText(result.toString())
        tvFibonacciResult.setText(fibonacciNormal(10).toString())
        tvFibonacciTailResult.setText(fibonacciRecursive(6).toString())
    }

    fun fibonacciNormal(number: Int): Int {
        var firstNumber = 0
        var secondNumber = 1
        var result = 0

        for (i in 2..number) {
            result = firstNumber + secondNumber
            firstNumber = secondNumber
            secondNumber = result
        }

        return result
    }

    fun fibonacciRecursive(number: Int): Int {
        if (number <= 1) return 1
        else return fibonacciRecursive(number - 1) + fibonacciRecursive(number - 2)
    }

    tailrec fun fibonacciTailRecursive(number: Int, a: BigInteger, b: BigInteger): BigInteger {

        return if (number == 0) b else fibonacciTailRecursive(number - 1, a + b, a)
    }

    fun factorialCalculate(targetNumber: Int): Int {
        if (targetNumber == 0) {
            return 1
        } else return targetNumber * factorialCalculate(targetNumber - 1)
    }

    private fun createToolbar() {
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        tvToolbar = findViewById(R.id.tvToolbar) as TextView
        tvToolbar.setText("Recursive Example")
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
