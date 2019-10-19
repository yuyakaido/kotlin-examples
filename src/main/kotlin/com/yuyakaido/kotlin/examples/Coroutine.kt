package com.yuyakaido.kotlin.examples

import kotlinx.coroutines.*

fun main() {
    runSuspendFunctionExample()
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

private fun runSuspendFunctionExample() {
    val initialization = suspend { println("Initialization on ${Thread.currentThread().name}") }
    val something = suspend {
        withContext(Dispatchers.IO) {
            println("Something on ${Thread.currentThread().name}")
        }
    }
    val completion = suspend { println("Completion on ${Thread.currentThread().name}") }
    runBlocking {
        initialization.invoke()
        something.invoke()
        completion.invoke()
    }
}
