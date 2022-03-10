package com.tcorredo.projectmvc_mvp_mvvm.di

import com.tcorredo.projectmvc_mvp_mvvm.view.repository.RepositoryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { RepositoryViewModel(get()) }
}