package com.tcorredo.projectmvc_mvp_mvvm.view.repository

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.tcorredo.projectmvc_mvp_mvvm.databinding.ActivityRepositoryBinding
import com.tcorredo.projectmvc_mvp_mvvm.view.repository.adapter.RepositoryAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class RepositoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRepositoryBinding

    private val adapter = RepositoryAdapter()

    private val repositoryViewModel: RepositoryViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initObserver()

        binding = ActivityRepositoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val linearLayoutManager = LinearLayoutManager(this)
        binding.repositoryRecyclerView.adapter = adapter
        binding.repositoryRecyclerView.layoutManager = linearLayoutManager

        repositoryViewModel.getRepositories()
    }

    private fun initObserver() {
        repositoryViewModel.viewState.observe(this) {
            when (it) {
                is RepositoryViewState.Success -> adapter.submitList(it.repositoryResponse.items)
                is RepositoryViewState.Error -> showError(it.message)
            }
        }
    }

    private fun showError(message: String?) {
        Toast.makeText(
            this,
            "Error network operation failed with $message",
            Toast.LENGTH_SHORT
        ).show()
    }
}