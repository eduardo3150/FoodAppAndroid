package com.fireland.foodapp.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.fireland.foodapp.R
import com.fireland.foodapp.databinding.ActivityMainBinding
import com.fireland.foodapp.helper.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = mainViewModel
        binding.lifecycleOwner = this

        mainViewModel.getRecipesList().observe(this, {
            when (it.status) {
                Status.LOADING -> Unit // TODO show loading
                Status.SUCCESS -> mainViewModel.recipeData.title = it.data?.recipes?.get(0)?.title!! // TODO show success state
                Status.ERROR -> Unit  // TODO show error state
            }
        })
    }
}