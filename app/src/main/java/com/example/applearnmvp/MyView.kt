package com.example.applearnmvp

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface MyView: MvpView {
    fun setText(count: String, position: Int)
    fun getPositionById(id: Int): Int

    fun setCountOneText(counter: String)
    fun setCountTwoText(counter: String)
    fun setCountThreeText(counter: String)
}