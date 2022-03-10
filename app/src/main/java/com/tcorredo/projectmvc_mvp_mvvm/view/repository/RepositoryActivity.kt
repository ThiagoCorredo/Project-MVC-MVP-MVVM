package com.tcorredo.projectmvc_mvp_mvvm.view.repository

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.tcorredo.projectmvc_mvp_mvvm.data.model.Repository
import com.tcorredo.projectmvc_mvp_mvvm.databinding.ActivityRepositoryBinding
import com.tcorredo.projectmvc_mvp_mvvm.view.repository.adapter.RepositoryAdapter
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class RepositoryActivity : AppCompatActivity(), RepositoryView.View {

    private lateinit var binding: ActivityRepositoryBinding

    private val adapter = RepositoryAdapter()

    private val presenter: RepositoryPresenter by inject { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRepositoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val linearLayoutManager = LinearLayoutManager(this)
        binding.repositoryRecyclerView.adapter = adapter
        binding.repositoryRecyclerView.layoutManager = linearLayoutManager

        presenter.getRepositories()
    }

    override fun showRepositories(repositories: List<Repository>) {
        adapter.submitList(repositories)
    }

    override fun showError(message: String) {
        Toast.makeText(
            this,
            "Error network operation failed with $message",
            Toast.LENGTH_SHORT
        ).show()
    }
}