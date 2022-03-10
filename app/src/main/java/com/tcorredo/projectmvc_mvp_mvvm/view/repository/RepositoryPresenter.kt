package com.tcorredo.projectmvc_mvp_mvvm.view.repository

import com.tcorredo.projectmvc_mvp_mvvm.data.remote.GitHubService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.KoinComponent
import org.koin.core.inject
import retrofit2.HttpException

class RepositoryPresenter(private val view: RepositoryView.View) : RepositoryView.Presenter, KoinComponent {

    private val gitHubService: GitHubService by inject()

    override fun getRepositories() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = gitHubService.getRepositories()
            withContext(Dispatchers.Main) {
                try {
                    view.showRepositories(response.items)
                } catch (exception: HttpException) {
                    view.showError(exception.response()?.code().toString())
                } catch (exception: Throwable) {
                    view.showError("Erro desconhecido")
                }
            }
        }
    }
}