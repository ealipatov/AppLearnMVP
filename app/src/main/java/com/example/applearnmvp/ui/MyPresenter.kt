package com.example.applearnmvp.ui

import com.example.applearnmvp.core.navigation.UsersScreens
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class MyPresenter(
    private val router: Router
    ): MvpPresenter<MyView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
   //     router.navigateTo(UsersScreens)
        router.replaceScreen(UsersScreens)
    }

    fun onBackPressed() {
       router.exit()
    }

}