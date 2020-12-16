package com.fireland.foodapp.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object EndpointFactory {
    private const val BASE_FINAL_URL = "https://api.spoonacular.com"

    fun makeHttpService(): EndpointService {
        return Retrofit.Builder()
            .baseUrl(BASE_FINAL_URL)
            .client(getNoAuthHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(EndpointService::class.java)
    }

    private fun getNoAuthHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(getLoggingInterceptor())
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
    }


    private fun getLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }
}