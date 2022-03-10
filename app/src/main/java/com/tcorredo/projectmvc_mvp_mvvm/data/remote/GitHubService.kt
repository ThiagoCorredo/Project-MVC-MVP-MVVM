package com.tcorredo.projectmvc_mvp_mvvm.data.remote

import com.tcorredo.projectmvc_mvp_mvvm.data.model.ItemsResponse
import com.tcorredo.projectmvc_mvp_mvvm.data.model.Repository
import retrofit2.http.GET

interface GitHubService {

    @GET("search/repositories?q=language:Kotlin&sort=stars")
    suspend fun getRepositories(): ItemsResponse<Repository>
}