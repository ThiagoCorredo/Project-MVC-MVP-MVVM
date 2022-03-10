package com.tcorredo.projectmvc_mvp_mvvm.data.repository

import com.tcorredo.projectmvc_mvp_mvvm.data.model.ItemsResponse
import com.tcorredo.projectmvc_mvp_mvvm.data.model.Repository
import com.tcorredo.projectmvc_mvp_mvvm.data.remote.GitHubService

class GitHubRepository(private val gitHubService: GitHubService) {
    suspend fun execute(): ItemsResponse<Repository> =
        gitHubService.getRepositories()
}