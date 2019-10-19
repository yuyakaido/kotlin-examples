package com.yuyakaido.kotlin.examples

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runCancellationExample()
}

private fun runGlobalScopeExample() {
    GlobalScope.launch {
        delay(1000)
        println("World")
    }
    println("Hello")
    Thread.sleep(2000)
}

private fun runRunBlockingExample() {
    runBlocking {
        GlobalScope.launch {
            delay(1000)
            println("World")
        }
        println("Hello")
        delay(2000)
    }
}

private fun runCoroutineScopeExample() {
    runBlocking {
        launch {
            delay(1000)
            println("World")
        }
        println("Hello")
        delay(2000)
    }
}

private fun runCancellationExample() {
    runBlocking {
        val job = launch {
            while (true) {
                delay(1000)
                println("World")
            }
        }
        println("Hello")
        delay(3000)
        job.cancel()
    }
}
