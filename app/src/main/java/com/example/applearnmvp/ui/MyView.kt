package com.example.applearnmvp.ui

import com.example.applearnmvp.model.GithubUser
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface MyView: MvpView {

    fun initList(list: List<GithubUser>)
}