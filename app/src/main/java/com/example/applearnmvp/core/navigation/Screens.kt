package com.example.applearnmvp.core.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.applearnmvp.ui.user.MyUserDetailFragment
import com.example.applearnmvp.ui.user.MyUserFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object UsersScreens: FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return MyUserFragment.getInstance()
    }

}

object UsersDetailScreens: FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment {
        return MyUserDetailFragment.getInstance()
    }

}