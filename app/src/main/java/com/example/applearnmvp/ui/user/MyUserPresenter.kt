package com.example.applearnmvp.ui.user

import com.example.applearnmvp.repository.impl.GithubRepository
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class MyUserPresenter(
    private val repository: GithubRepository,
    private val router: Router
): MvpPresenter<MyUserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.initList(repository.getUsers())
    }

    fun onBackPressed(): Boolean{
        router.exit()
        return true
    }
}