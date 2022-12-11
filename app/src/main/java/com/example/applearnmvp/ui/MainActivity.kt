package com.example.applearnmvp.ui

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.applearnmvp.MyPresenter
import com.example.applearnmvp.databinding.ActivityMainBinding
import com.example.applearnmvp.model.GithubUser
import com.example.applearnmvp.repository.impl.GithubRepositoryImpl
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), MyView {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!


    private val presenter by moxyPresenter { MyPresenter(GithubRepositoryImpl()) }
    private val adapter = MyUserAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            githubUserList.layoutManager = LinearLayoutManager(this@MainActivity)
           // githubUserList.setItemViewCacheSize(1) //Количество закешированый итемов "за экраном"
            githubUserList.adapter = adapter
        }

    }

    override fun initList(list: List<GithubUser>) {
        adapter.users = list
    }

    /***
     * Для устранения учетки памяти зануляем binding
     */
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}