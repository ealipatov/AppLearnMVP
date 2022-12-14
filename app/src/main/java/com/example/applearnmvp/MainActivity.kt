package com.example.applearnmvp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.applearnmvp.databinding.ActivityMainBinding
import com.example.applearnmvp.utils.POSITION_ONE
import com.example.applearnmvp.utils.POSITION_THREE
import com.example.applearnmvp.utils.POSITION_TWO

class MainActivity : AppCompatActivity(), MyView {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!


    private lateinit var presenter: MyPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initPresenter()

        with(binding) {
            btnOne.setOnClickListener {
                presenter.onBtnClick(R.id.btn_one)
            }
            btnTwo.setOnClickListener {
                presenter.onBtnClick(R.id.btn_two)
            }
            btnThree.setOnClickListener {
                presenter.onBtnClick(R.id.btn_three)
            }
        }
    }

    /***
     * Инициализируем Презентер
     */
    private fun initPresenter() {
        presenter = MyPresenter(this)
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

    /***
     * Взвращаем позицию в зависимости от id
     */
    override fun getPositionById(id: Int): Int {
        return when (id) {
            R.id.btn_one -> POSITION_ONE
            R.id.btn_two -> POSITION_TWO
            R.id.btn_three -> POSITION_THREE
            else -> 0
        }
    }

    /***
     * Для устранения учетки памяти зануляем binding
     */
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}