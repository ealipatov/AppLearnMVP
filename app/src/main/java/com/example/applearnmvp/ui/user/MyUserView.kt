package com.example.applearnmvp.ui.user

import com.example.applearnmvp.model.GithubUser
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface MyUserView: MvpView {
    fun initList(list: List<GithubUser>)
}