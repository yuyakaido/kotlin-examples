package com.yuyakaido.kotlin.examples

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    println("Start")

    GlobalScope.launch {
        delay(1000)
        println("Hello")
    }

    Thread.sleep(2000)
    println("Stop")
}