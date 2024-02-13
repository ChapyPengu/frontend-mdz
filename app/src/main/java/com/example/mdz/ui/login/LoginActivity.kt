package com.example.mdz.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate
import com.example.mdz.MainActivity
import com.example.mdz.R
import com.example.mdz.data.ApiClient
import com.example.mdz.data.request.AuthRequest
import com.example.mdz.databinding.ActivityLoginBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        disableDarkMode()
        initUI()
    }

    private fun disableDarkMode() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

    private fun initUI() {
        initListeners()
    }

    private fun initListeners() {
        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            if (validateUser(email, password)) {
                CoroutineScope(Dispatchers.IO).launch {
                    val authRequest = AuthRequest(email, password)
                    val response = ApiClient.apiService.postAuth(authRequest)
                    if (userFound(response.message)) {
                        withContext(Dispatchers.IO) {
                            val intent = Intent(this@LoginActivity, MainActivity::class.java)
                            startActivity(intent)
                        }
                    }
                }
            } else {
                Log.i("response", "Enter a email and password")
            }
        }
    }

    private fun validateUser(email: String, password: String): Boolean {
        return email.isNotEmpty() && password.isNotEmpty()
    }

    private fun userFound(message: String): Boolean {
        return message == "User found"
    }
}