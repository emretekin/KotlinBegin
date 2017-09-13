package com.emretekin.kotlindemo.Utils

/**
 * Created by emretekin on 11/09/17.
 */
class OperationInterface : SampleInterface{

    override fun minus(n1: Int, n2: Int) {
        println(n1 + n2)
    }

    override fun plus(n1: Int, n2: Int) {
        println(n1 - n2)    }
}