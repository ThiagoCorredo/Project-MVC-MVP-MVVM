package com.tcorredo.projectmvc_mvp_mvvm.view.repository

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.tcorredo.projectmvc_mvp_mvvm.controller.BaseApi
import com.tcorredo.projectmvc_mvp_mvvm.databinding.ActivityRepositoryBinding
import com.tcorredo.projectmvc_mvp_mvvm.model.ItemsResponse
import com.tcorredo.projectmvc_mvp_mvvm.model.Repository
import com.tcorredo.projectmvc_mvp_mvvm.view.repository.adapter.RepositoryAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRepositoryBinding

    private val adapter = RepositoryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRepositoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val linearLayoutManager = LinearLayoutManager(this)
        binding.repositoryRecyclerView.adapter = adapter
        binding.repositoryRecyclerView.layoutManager = linearLayoutManager

        getRepositories()
    }

    private fun getRepositories() {
        val service = BaseApi.createEndpoint()

        val callback = service.getRepositories()

        callback.enqueue(object : Callback<ItemsResponse<Repository>> {
            override fun onFailure(call: Call<ItemsResponse<Repository>>, throwable: Throwable) {
                showMessage(throwable.message)
            }

            override fun onResponse(
                call: Call<ItemsResponse<Repository>>,
                response: Response<ItemsResponse<Repository>>
            ) {
                adapter.submitList(response.body()?.items)
            }
        })
    }

    private fun showMessage(message: String?) {
        Toast.makeText(
            this,
            "Error network operation failed with $message",
            Toast.LENGTH_SHORT
        ).show()
    }
}