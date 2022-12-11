package com.example.applearnmvp.ui

import android.os.Bundle
import com.example.applearnmvp.MyPresenter
import com.example.applearnmvp.databinding.ActivityMainBinding
import com.example.applearnmvp.model.MyModel
import com.example.applearnmvp.utils.POSITION_ONE
import com.example.applearnmvp.utils.POSITION_THREE
import com.example.applearnmvp.utils.POSITION_TWO
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), MyView {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!


    private val presenter by moxyPresenter { MyPresenter(MyModel()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        with(binding) {
//            btnOne.setOnClickListener {
//                presenter.onBtnClick(R.id.btn_one)
//            }
//            btnTwo.setOnClickListener {
//                presenter.onBtnClick(R.id.btn_two)
//            }
//            btnThree.setOnClickListener {
//                presenter.onBtnClick(R.id.btn_three)
//            }
//        }

        with(binding) {
            btnOne.setOnClickListener {
                presenter.onBtnOneClick()
            }
            btnTwo.setOnClickListener {
                presenter.onBtnTwoClick()
            }
            btnThree.setOnClickListener {
                presenter.onBtnThreeClick()
            }
        }
    }

    /***
     * В соответствии в выбраной позицией (нажатой кнопкой),
     * меняем значение соответствующего "счетчика" (текстового поля)
     */
    override fun setText(count: String, position: Int) {
        with(binding) {
            when (position) {
                POSITION_ONE -> textViewOne.text = count
                POSITION_TWO -> textViewTwo.text = count
                POSITION_THREE -> textViewThree.text = count
            }
        }
    }

//    /***
//     * Взвращаем позицию в зависимости от id
//     */
//    override fun getPositionById(id: Int): Int {
//        return when (id) {
//            R.id.btn_one -> POSITION_ONE
//            R.id.btn_two -> POSITION_TWO
//            R.id.btn_three -> POSITION_THREE
//            else -> 0
//        }
//    }

    override fun setCountOneText(counter: String) {
        binding.textViewOne.text = counter
    }

    override fun setCountTwoText(counter: String) {
        binding.textViewTwo.text = counter
    }

    override fun setCountThreeText(counter: String) {
        binding.textViewThree.text = counter
    }

    /***
     * Для устранения учетки памяти зануляем binding
     */
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}