package com.tcorredo.projectmvc_mvp_mvvm.di

import com.tcorredo.projectmvc_mvp_mvvm.data.repository.GitHubRepository
import org.koin.dsl.module

val domainModule = module {
    factory { GitHubRepository(get()) }
}