package com.tcorredo.projectmvc_mvp_mvvm.view.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tcorredo.projectmvc_mvp_mvvm.data.repository.GitHubRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException

class RepositoryViewModel(private val githubRepository: GitHubRepository) : ViewModel() {

    private val _viewState = MutableLiveData<RepositoryViewState>()
    val viewState: LiveData<RepositoryViewState> = _viewState

    fun getRepositories() {
        viewModelScope.launch {
            try {
                val response = githubRepository.execute()

                _viewState.value = RepositoryViewState.Success(response)
            } catch (exception: HttpException) {
                _viewState.value = RepositoryViewState.Error(exception.code().toString())
            } catch (exception: Throwable) {
                _viewState.value = RepositoryViewState.Error("Erro desconhecido")
            }
        }
    }
}