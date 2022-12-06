package com.example.applearnmvp

class MyPresenter(private val view: MyView) {

    private val model = MyModel()

    fun onBtnClick(id: Int) {
        when (id) {
            R.id.btn_one -> {
                val nextValue = model.next(0)
                view.setText(nextValue.toString())
            }
            R.id.btn_two -> {
                val nextValue = model.next(1)
                view.setText(nextValue.toString())
            }
            R.id.btn_three -> {
                val nextValue = model.next(2)
                view.setText(nextValue.toString())
            }
        }
    }
}