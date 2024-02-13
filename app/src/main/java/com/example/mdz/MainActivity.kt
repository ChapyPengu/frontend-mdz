package com.example.mdz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.mdz.data.ApiClient
import com.example.mdz.data.ApiService
import com.example.mdz.data.responses.ServiceResponse
import com.example.mdz.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

    private fun initUI() {
        initListeners()
        initNavigation()
    }

    private fun initListeners() {

    }

    private fun initNavigation() {
        val navHost = supportFragmentManager.findFragmentById(R.id.fcv) as NavHostFragment
        navController = navHost.navController
        binding.bnv.setupWithNavController(navController)
    }
}