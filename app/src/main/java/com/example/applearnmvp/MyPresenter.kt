package com.example.applearnmvp

class MyPresenter(private val view: MyView) {

    private val model = MyModel()

    fun onBtnClick(id: Int) {
        val position = view.getPositionById(id)
        view.setText(nextValue(position).toString(), position)
    }

    private fun nextValue(position: Int):Int{
        return model.next(position)
    }
}