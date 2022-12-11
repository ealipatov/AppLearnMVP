package com.example.applearnmvp.repository.impl

import com.example.applearnmvp.model.GithubUser

class GithubRepositoryImpl: GithubInterface {

    private val repositories = listOf(
        GithubUser("MrFox"),
        GithubUser("MrBear"),
        GithubUser("MrWolf"),
        GithubUser("MrPig"),
        GithubUser("MrElephant")
    )

    override fun getUsers(): List<GithubUser>{
        return repositories
    }
}