package com.fireland.foodapp.di

import com.fireland.foodapp.network.FoodService
import com.fireland.foodapp.network.FoodServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class NetworkModule {

    @Binds
    abstract fun bindFoodService(foodServiceImpl: FoodServiceImpl): FoodService
}