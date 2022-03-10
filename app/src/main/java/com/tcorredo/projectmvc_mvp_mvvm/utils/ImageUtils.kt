package com.tcorredo.projectmvc_mvp_mvvm.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

object ImageUtils {
    fun createRoundImage(imageView: ImageView, imageUrl: String) {
        Glide.with(imageView.context)
            .load(imageUrl)
            .apply(RequestOptions.circleCropTransform())
            .into(imageView)
    }
}