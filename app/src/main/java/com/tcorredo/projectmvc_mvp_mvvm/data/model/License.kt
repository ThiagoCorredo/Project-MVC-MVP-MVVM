package com.tcorredo.projectmvc_mvp_mvvm.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class License(
    @Json(name = "name") val name: String
) : Parcelable