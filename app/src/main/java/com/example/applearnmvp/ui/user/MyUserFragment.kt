package com.example.applearnmvp.ui.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.applearnmvp.MyApp
import com.example.applearnmvp.core.OnBackPressedListener
import com.example.applearnmvp.databinding.FragmentUserListBinding
import com.example.applearnmvp.model.GithubUser
import com.example.applearnmvp.repository.impl.GithubRepositoryImpl
import com.example.applearnmvp.ui.MyUserAdapter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class MyUserFragment: MvpAppCompatFragment(), MyUserView, OnBackPressedListener {

    private var _binding: FragmentUserListBinding? = null
    private val binding get() = _binding!!

    companion object{
        fun getInstance(): MyUserFragment {
            return  MyUserFragment()
//                .apply {
//                    arguments = Bundle(
//                        "login" to login
//                    )
//                }
        }
    }

    private val presenter: MyUserPresenter by moxyPresenter {
        MyUserPresenter(GithubRepositoryImpl(), MyApp.instance.router)
    }

    private val adapter = MyUserAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentUserListBinding.inflate(inflater, container, false).also{
            _binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){
            githubUserList.layoutManager = LinearLayoutManager(requireContext())
            githubUserList.adapter = adapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun initList(list: List<GithubUser>) {
        adapter.users = list
    }

    override fun onBackPressed() = presenter.onBackPressed()
}