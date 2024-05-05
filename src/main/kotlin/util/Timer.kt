package org.example.util

object Timer {
    private var startTime: Long = 0

    fun start() {
        startTime = System.currentTimeMillis()
    }

    fun stopAndPrint(operation: String) {
        val endTime = System.currentTimeMillis()
        val duration = endTime - startTime
        println("\n$operation executed in ${duration}ms")
    }
}