package com.tcorredo.projectmvc_mvp_mvvm.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.tcorredo.projectmvc_mvp_mvvm.BuildConfig
import com.tcorredo.projectmvc_mvp_mvvm.data.remote.GitHubService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit

private const val BASE_URL = "BASE_URL"

val apiModule = module {
    single { provideRetrofit(get(named(BASE_URL)), get(), get()) }

    single { provideMoshi() }

    single { provideOkHttpClient() }

    single(named(BASE_URL)) { "https://api.github.com/" }
}

private fun provideRetrofit(baseUrl: String, moshi: Moshi, client: OkHttpClient): GitHubService {
    return Retrofit.Builder()
        .client(client)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(baseUrl)
        .build()
        .create(GitHubService::class.java)
}

private fun provideMoshi(): Moshi {
    return Moshi
        .Builder()
        .add(Date::class.java, Rfc3339DateJsonAdapter().nullSafe())
        .addLast(KotlinJsonAdapterFactory())
        .build()
}

private fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .writeTimeout(10, TimeUnit.SECONDS)
        .addInterceptor(
            HttpLoggingInterceptor()
                .apply {
                    level =
                        if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
                }
        )
        .build()
}