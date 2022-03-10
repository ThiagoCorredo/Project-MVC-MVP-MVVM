package com.tcorredo.projectmvc_mvp_mvvm.view.repository

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.tcorredo.projectmvc_mvp_mvvm.controller.BaseApi
import com.tcorredo.projectmvc_mvp_mvvm.databinding.ActivityRepositoryBinding
import com.tcorredo.projectmvc_mvp_mvvm.view.repository.adapter.RepositoryAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException

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

    fun getRepositories() {
        val service = BaseApi.createEndpoint()
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.getRepositories()
            withContext(Dispatchers.Main) {
                try {
                    adapter.submitList(response.items)
                } catch (exception: HttpException) {
                    showMessage(exception.response()?.code().toString())
                } catch (exception: Throwable) {
                    showMessage("Erro desconhecido")
                }
            }
        }
    }

    private fun showMessage(message: String) {
        Toast.makeText(
            this,
            "Error network operation failed with $message",
            Toast.LENGTH_SHORT
        ).show()
    }
}