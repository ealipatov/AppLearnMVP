package com.example.applearnmvp.ui.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.applearnmvp.databinding.FragmentUserDetailBinding

class MyUserDetailFragment: Fragment() {

    private var _binding: FragmentUserDetailBinding? = null
    private val binding get() = _binding!!

    companion object{
        fun getInstance(): MyUserDetailFragment {
            return  MyUserDetailFragment()
        }
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
            userDetail.text = "item.login"
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}