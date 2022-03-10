package com.tcorredo.projectmvc_mvp_mvvm.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Owner(
    @Json(name = "login") val login: String,
    @Json(name = "avatar_url") val avatarUrl: String
) : Parcelable