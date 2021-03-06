package com.emretekin.kotlindemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import com.emretekin.kotlindemo.Utils.OgrenciJava
import com.emretekin.kotlindemo.Utils.OgrenciKotlin
import java.util.*

class ActivitySimple : AppCompatActivity() {

    private lateinit var tvToolbar: TextView
    var number = 10
    var mNumber: Int = 10  //variable
    val numberFinal = 3  // final variable

    var maxInteger = Int.MAX_VALUE
    var minInteger = Int.MIN_VALUE

    var firstLetter = "A"

    var number1: Int = 5
    var number2: Int = 10
    var myResult: Int = 0

    var str1: String = "Emre"
    var str2: String = "emre"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple)

        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        tvToolbar = findViewById(R.id.tvToolbar) as TextView
        tvToolbar.setText("Simple Example")

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)

        baseSamples()
        nullSamples()
        whenSamples()
        rangeSamples()
        breakContineSamples()
        listAndMapSamples()
        trycatchSamples()
        initFunc();
        afterValues(17)

        plusNumbers(10, 15)
        plusNumbersSingleLine(10, 15)
        getMaxValue(5, 9)

        var total = getTotalPrice(100, 18.0);
        println(total)

        Toast.makeText(applicationContext, "Init", Toast.LENGTH_SHORT).show()
    }

    fun baseSamples() {
        mNumber = 12
        println("Number 1: $number" + "Number 2: $mNumber" + "Number 3:" + numberFinal)

        println("Max Integer $maxInteger")
        println("Min Integer" + minInteger)

        println("Is A variable char?: ${firstLetter is String}")

        if (number1 > number2) {
            println("true")
        }

        if (str1.equals(str2)) {
            println("True")
        } else {
            println("False")
        }

        if (str1.equals(str2, true)) {
            println("True")
        } else {
            println("False")
        }

        if (str1 == str2) {
            println("True")
        }
    }

    fun nullSamples() {
        val emre = OgrenciJava();
        val tekin = OgrenciKotlin();

        //println(emre.name.length) // null exception because of java
        println(tekin.name?.length) // output null
    }

    fun whenSamples() {
        // This is like Java Switch/Case

        var x: Int = 5
        var y: Int = 15
        var sonuc: String

        when (x) {
            5 -> println("Number x is $x")
            10 -> println("Number x is $x")
            else -> println("Default")
        }

        sonuc = when (y) {
            in 11..20 -> "Number is between 11 and 20"  // 11 ile 20 arasinda mi ?
            !in 21..30 -> "Number is not between 21 and 30" // 21 ile 30 arasinda degilse
            else -> ""
        }
        print(sonuc)
    }

    fun rangeSamples() {
        var numbers = 1..5 // 1 ile 5 arasindaki tum sayilari iceriyor
        var numbersReverse = 5..1
        var letters = 'a'..'z'

        var isHave = 'c' in letters
        when (isHave) {
            true -> println("Yes")
            false -> print("No")
        }

        var numbers2 = 1..100 step 2 // ikeser ikiser artarak tum sayilari iceriyor
        var countDown = 100.downTo(1) // 100'den 1'e dogru geri sayim yapar
        var countForward = 100.downTo(1).step(5)
        var countForward2 = 1.rangeTo(100)

        for (i in 1..10) {
            println(i)      //birden 10'a kadar sayilari yazdiran for dongusu
        }
        for (i in letters) {
            println(i)      //harfleri yazdiran for dongusu
        }

        var i: Int = 0
        while (i < 10) {
            println(i)
            i++
        }

        var x: Int = 0
        do {
            println(x)
            x++
        } while (x < 10)
    }

    fun breakContineSamples() {
        var numbers = 1..10
        for (i in numbers.reversed()) {
            println(i)
            if (i == 7) {
                break
            }
        }

        for (i in numbers.reversed()) {
            println(i)
            if (i == 3) {
                continue
            }
        }

        OutsideFor@ for (i in 1..3) {
            for (j in 1..3) {
                println("$i $j")
                if (i == 2 && j == 1) {
                    break@OutsideFor   // Disaridaki for'a cikmasini saglariz
                }
            }
        }
    }

    fun listAndMapSamples() {

        var personIDList = listOf<Int>(1, 2, 3) // Add, Remove or Update yapilamaz !
        for (i in personIDList) {
            println(i)
        }

        var personNewIDList: MutableList<Int> = mutableListOf<Int>(1, 2, 3, 4, 5)
        personNewIDList.add(6)
        personNewIDList.remove(3)
        personIDList.withIndex() // index bilgilerini getirir


        var people = TreeMap<Int, String>()
        people[1] = "Emre"
        people[2] = "Tekin"
        people[3] = "Hello"
        people[4] = "World"
        for ((id, name) in people) {
            println("$id --- $name")
        }


    }


    fun plusNumbers(n1: Int, n2: Int): Int {
        return n1 + n2
    }

    fun plusNumbersSingleLine(n1: Int, n2: Int): Int = n1 + n2  // single line method

    fun getMaxValue(n1: Int, n2: Int): Int = if (n1 > n2) n1 else n2  // n1 buyukse n1'i return eder else n2'yi return eder

    fun getTotalPrice(total: Int, ratio: Double): Int {
        return (total + total * ratio / 100).toInt()
    }

    fun trycatchSamples() {
        var text: String = "4a"
        var num: Int = 0
        // println(num) // NumberFormatException return eder

        try {
            num = text.toInt()
            println(num)
        } catch (e: Exception) {
            e.message
        }

    }

    fun plus(num1: Int, num2: Int): Int {
        return num1 + num2
    }

    fun minus(num1: Int, num2: Int): Int = num1 - num2

    fun times(num1: Int, num2: Int): Int = num1 * num2

    fun divide(num1: Int, num2: Int): Int = num1 / num2

    fun afterValues(num: Int): Pair<Int, Int> { // Pair tipinde eleman dondurecek
        return Pair(num + 1, num + 2)
    }

    fun factorialCalculate(num: Int) {
        var factorial = 1
        for (i in 1..num) {
            factorial = factorial * i
        }
    }

    fun initFunc() {
        var totalP = plus(2, 9);
        var totalM = minus(15, 5);
        var totalT = times(4, 4);
        var totalD = divide(10, 2);


        println(totalP)
        println(totalM)
        println(totalT)
        println(totalD)

        var (numberOne, numberTwo) = afterValues(17) // Output - numberOne = 18  numberTwo = 19
        factorialCalculate(4)
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
