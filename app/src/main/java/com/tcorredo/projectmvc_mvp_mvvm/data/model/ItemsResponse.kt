package com.tcorredo.projectmvc_mvp_mvvm.data.model

import com.squareup.moshi.Json

data class ItemsResponse<T>(@Json(name = "items") val items: List<T>)