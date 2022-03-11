package com.tcorredo.projectmvc_mvp_mvvm.controller

import com.tcorredo.projectmvc_mvp_mvvm.model.ItemsResponse
import com.tcorredo.projectmvc_mvp_mvvm.model.Repository
import retrofit2.Call
import retrofit2.http.GET

interface GitHubService {

    @GET("search/repositories?q=language:Kotlin&sort=stars")
    fun getRepositories(): Call<ItemsResponse<Repository>>
}