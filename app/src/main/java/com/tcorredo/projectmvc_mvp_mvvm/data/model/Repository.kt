package com.tcorredo.projectmvc_mvp_mvvm.data.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Repository(
    @Json(name = "id") val id: Long,
    @Json(name = "full_name") val fullName: String,
    @Json(name = "owner") val owner: Owner,
    @Json(name = "name") val name: String,
    @Json(name = "description") val description: String,
    @Json(name = "forks") val forks: Int,
    @Json(name = "stargazers_count") val starCount: Int,
    @Json(name = "license") val license: License?
) : Parcelable {
    companion object {
        val DIFF_UTIL_CALLBACK = object : DiffUtil.ItemCallback<Repository>() {
            override fun areItemsTheSame(oldItem: Repository, newItem: Repository): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Repository, newItem: Repository): Boolean {
                return oldItem == newItem
            }
        }
    }
}