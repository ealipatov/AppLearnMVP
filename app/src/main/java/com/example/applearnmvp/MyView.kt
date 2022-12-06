package com.example.applearnmvp

interface MyView {
    fun setText(count: String, position: Int)
    fun getPositionById(id: Int):Int
}