package com.example.applearnmvp.repository.impl

import com.example.applearnmvp.model.GithubUser

interface GithubRepository {
    fun getUsers(): List<GithubUser>
}