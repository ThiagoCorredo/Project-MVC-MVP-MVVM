package com.tcorredo.projectmvc_mvp_mvvm.view.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tcorredo.projectmvc_mvp_mvvm.databinding.ActivityLoginBinding
import com.tcorredo.projectmvc_mvp_mvvm.view.repository.RepositoryActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btLogin.setOnClickListener {
            makeLogin()
        }
    }

    private fun makeLogin() {
        startActivity(Intent(this, RepositoryActivity::class.java))
        finish()
    }
}