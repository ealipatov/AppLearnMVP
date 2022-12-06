package com.example.applearnmvp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.applearnmvp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val counters = mutableListOf(0, 0, 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()

        with(binding){
            btnOne.setOnClickListener {
                textViewOne.text = (++counters[0]).toString()
            }
            btnTwo.setOnClickListener {
                textViewTwo.text = (++counters[1]).toString()
            }
            btnThree.setOnClickListener {
                textViewThree.text = (++counters[2]).toString()
            }
        }
    }

    private fun initViews() {
        with(binding){
            textViewOne.text = counters[0].toString()
            textViewTwo.text = counters[1].toString()
            textViewThree.text = counters[2].toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putIntArray("count", counters.toIntArray())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val array = savedInstanceState.getIntArray("count")
        counters.let{list ->
            list.clear()
            array?.toList()?.let{
                list.addAll(it)
            }
        }
        initViews()
    }

}