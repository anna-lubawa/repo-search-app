package com.annalubawa.reposearchapp.data

import com.annalubawa.reposearchapp.data.network.client.GithubRepoApiHelper
import javax.inject.Inject

class GithubRepoRepository @Inject constructor(private val apiHelper: GithubRepoApiHelper) {

    suspend fun getRepositories(query: String) { }

}