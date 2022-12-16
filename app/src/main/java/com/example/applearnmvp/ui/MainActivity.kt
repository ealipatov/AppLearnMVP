package com.example.applearnmvp.ui

import android.os.Bundle
import com.example.applearnmvp.MyApp
import com.example.applearnmvp.R
import com.example.applearnmvp.core.OnBackPressedListener
import com.example.applearnmvp.databinding.ActivityMainBinding
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), MyView {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val navigator = AppNavigator(this, R.id.container)
    private val presenter by moxyPresenter { MyPresenter(MyApp.instance.router) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        MyApp.instance.navigationHolder.setNavigator(navigator)
    }

    override fun onPause() {
        MyApp.instance.navigationHolder.removeNavigator()
        super.onPause()
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach { currentFragment ->
            if (currentFragment is OnBackPressedListener && currentFragment.onBackPressed()){
                return
            }
        }
        presenter.onBackPressed()
    }

    /***
     * Для устранения учетки памяти зануляем binding
     */
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}