package com.tcorredo.projectmvc_mvp_mvvm.view.repository

import com.tcorredo.projectmvc_mvp_mvvm.data.model.Repository

interface RepositoryView {

    interface View {
        fun showRepositories(repositories: List<Repository>)

        fun showError(message: String)
    }

    interface Presenter {
        fun getRepositories()
    }
}