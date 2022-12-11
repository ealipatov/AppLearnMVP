package com.example.applearnmvp

import com.example.applearnmvp.repository.impl.GithubRepository
import com.example.applearnmvp.ui.MyView
import moxy.MvpPresenter

class MyPresenter(
    private val repository: GithubRepository
    ): MvpPresenter<MyView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.initList(repository.getUsers())
    }

}