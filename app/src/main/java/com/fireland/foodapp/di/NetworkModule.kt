package com.fireland.foodapp.di

import com.fireland.foodapp.network.HttpProvider
import com.fireland.foodapp.network.HttpProviderImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class NetworkModule {

    @Binds
    abstract fun bindHttpProvider(httpProviderImpl: HttpProviderImpl): HttpProvider
}