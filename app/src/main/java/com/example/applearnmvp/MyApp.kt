package com.example.applearnmvp

import android.app.Application
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router

class MyApp: Application() {

    companion object{
        lateinit var instance: MyApp
    }

    private val cicerone: Cicerone<Router> by lazy {Cicerone.create()}
    val navigationHolder = cicerone.getNavigatorHolder()
    val router = cicerone.router

    override fun onCreate() {
        super.onCreate()

        instance = this
    }
}