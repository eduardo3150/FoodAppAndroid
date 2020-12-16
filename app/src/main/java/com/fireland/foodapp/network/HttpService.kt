package com.fireland.foodapp.network

import com.fireland.foodapp.model.RecipesMain
import retrofit2.http.GET
import retrofit2.http.Query

interface EndpointService {
    @GET("/recipes/random")
    suspend fun getRecipes(
        @Query("apiKey") apiKey: String,
        @Query("number") number: String
    ): RecipesMain
}