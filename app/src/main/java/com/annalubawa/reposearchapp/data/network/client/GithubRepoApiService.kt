package com.annalubawa.reposearchapp.data.network.client

import com.annalubawa.reposearchapp.data.network.model.ApiSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubRepoApiService {

    @GET("search/repositories")
    suspend fun getRepositories(@Query("q") query: String) : ApiSearchResponse

}