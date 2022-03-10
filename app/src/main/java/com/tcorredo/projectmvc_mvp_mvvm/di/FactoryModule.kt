package com.tcorredo.projectmvc_mvp_mvvm.di

import com.tcorredo.projectmvc_mvp_mvvm.view.repository.RepositoryPresenter
import com.tcorredo.projectmvc_mvp_mvvm.view.repository.RepositoryView
import org.koin.dsl.module

val factoryModule = module {
    factory { (view: RepositoryView.View) ->
        RepositoryPresenter(
            view
        )
    }
}