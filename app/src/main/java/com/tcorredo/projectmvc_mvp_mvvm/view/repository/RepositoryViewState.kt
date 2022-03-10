package com.tcorredo.projectmvc_mvp_mvvm.view.repository

import com.tcorredo.projectmvc_mvp_mvvm.data.model.ItemsResponse
import com.tcorredo.projectmvc_mvp_mvvm.data.model.Repository

sealed class RepositoryViewState {

    data class Success(val repositoryResponse: ItemsResponse<Repository>) : RepositoryViewState()

    data class Error(val message: String?) : RepositoryViewState()
}