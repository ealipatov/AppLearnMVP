package com.example.applearnmvp.ui.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.applearnmvp.MyApp
import com.example.applearnmvp.core.OnBackPressedListener
import com.example.applearnmvp.databinding.FragmentUserDetailBinding
import com.example.applearnmvp.model.GithubUser
import com.example.applearnmvp.repository.impl.GithubRepositoryImpl
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class MyUserDetailFragment(private val item: GithubUser): MvpAppCompatFragment(),
    OnBackPressedListener {

    private var _binding: FragmentUserDetailBinding? = null
    private val binding get() = _binding!!

    companion object{
        fun getInstance(item: GithubUser): MyUserDetailFragment {
            return  MyUserDetailFragment(item)
        }
    }

    private val presenter: MyUserPresenter by moxyPresenter {
        MyUserPresenter(GithubRepositoryImpl(), MyApp.instance.router)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentUserDetailBinding.inflate(inflater, container, false).also{
            _binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){
            userDetail.text = item.login
        }
    }

    override fun onBackPressed() = presenter.onBackPressed()

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}