package com.tcorredo.projectmvc_mvp_mvvm.view.repository.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tcorredo.projectmvc_mvp_mvvm.R
import com.tcorredo.projectmvc_mvp_mvvm.databinding.ItemListRepositoryBinding
import com.tcorredo.projectmvc_mvp_mvvm.model.Repository
import com.tcorredo.projectmvc_mvp_mvvm.utils.ImageUtils

class RepositoryAdapter :
    ListAdapter<Repository, RepositoryAdapter.ViewHolder>(Repository.DIFF_UTIL_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListRepositoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(getItem(position))
    }

    class ViewHolder(private val binding: ItemListRepositoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindView(repository: Repository) {
            binding.run {
                repositoryTitle.text = repository.name
                repositoryForkNumber.text = repository.forks.toString()
                repositoryStarNumber.text = repository.starCount.toString()
                repositoryDescription.text = repository.description
                ImageUtils.createRoundImage(userProfileImage, repository.owner.avatarUrl)
                repositoryUserName.text = repository.owner.login
                if (repository.license == null) {
                    repositoryLicense.setText(R.string.repository_without_license)
                } else {
                    repositoryLicense.text = repository.license.name
                }
            }
        }
    }
}