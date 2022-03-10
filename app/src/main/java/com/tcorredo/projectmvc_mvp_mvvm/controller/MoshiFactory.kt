package com.tcorredo.projectmvc_mvp_mvvm.controller

import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.util.*

class MoshiFactory {

    init {
        throw RuntimeException("No instances!")
    }

    companion object {

        private val MOSHI =
            Moshi.Builder().add(Date::class.java, Rfc3339DateJsonAdapter().nullSafe())
                .addLast(KotlinJsonAdapterFactory())
                .build()

        fun get(): Moshi {
            return MOSHI
        }
    }
}