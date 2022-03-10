package com.tcorredo.projectmvc_mvp_mvvm.controller

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object BaseApi {
    private const val BASE_URL = "https://api.github.com/"

    fun createEndpoint(): GitHubService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(MoshiFactory.get()))
            .build()
            .create(GitHubService::class.java)
    }
}