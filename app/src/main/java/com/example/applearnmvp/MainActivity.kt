package com.example.applearnmvp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.applearnmvp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MyView {

    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: MyPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initPresenter()

        with(binding){
            btnOne.setOnClickListener{
                presenter.onBtnClick(R.id.btn_one)
            }
            btnOne.setOnClickListener{
                presenter.onBtnClick(R.id.btn_two)
            }
            btnOne.setOnClickListener{
                presenter.onBtnClick(R.id.btn_three)
            }
        }
    }

    private fun initPresenter(){
        presenter = MyPresenter(this)
    }

    override fun setText(count: String, position: Int) {
        with(binding){
            when (position){
                0-> textViewOne.text = count
                1-> textViewTwo.text = count
                2-> textViewThree.text = count
            }
        }
    }
}