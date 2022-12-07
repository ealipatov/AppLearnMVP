package com.example.applearnmvp

import moxy.MvpPresenter

class MyPresenter(private val model: MyModel): MvpPresenter<MyView>() {



    fun onBtnOneClick(){
        val newValue = model.next(0)
        viewState.setCountOneText(newValue.toString())
    }
    fun onBtnTwoClick(){
        val newValue = model.next(1)
        viewState.setCountTwoText(newValue.toString())
    }
    fun onBtnThreeClick(){
        val newValue = model.next(2)
        viewState.setCountThreeText(newValue.toString())
    }

//    fun onBtnClick(id: Int) {
//        val position = viewState.getPositionById(id)
//        viewState.setText(nextValue(position).toString(), position)
//    }

//    private fun nextValue(position: Int): Int {
//        return model.next(position)
//    }
}