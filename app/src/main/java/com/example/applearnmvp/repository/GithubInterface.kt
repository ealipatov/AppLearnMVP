package com.example.applearnmvp.repository.impl

import com.example.applearnmvp.model.GithubUser

interface GithubInterface {
    fun getUsers(): List<GithubUser>
}