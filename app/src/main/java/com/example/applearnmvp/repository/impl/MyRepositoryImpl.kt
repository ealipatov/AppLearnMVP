package com.example.applearnmvp.repository.impl

class MyRepositoryImpl {

    private val counters = mutableListOf(0, 0, 0)

    private fun getCurrent(position: Int): Int {
        return counters[position]
    }

    fun next(position: Int): Int {
        counters[position]++
        return getCurrent(position)
    }

    fun set(position: Int, value: Int) {
        counters[position] = value
    }
}