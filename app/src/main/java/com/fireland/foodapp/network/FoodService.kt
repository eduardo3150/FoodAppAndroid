package com.fireland.foodapp.network

import com.fireland.foodapp.model.RecipesMain
import javax.inject.Inject

interface FoodService {
    suspend fun getRecipes(): RecipesMain
}

class FoodServiceImpl @Inject constructor() : FoodService {
    private val endpointService = EndpointFactory.makeHttpService()

    override suspend fun getRecipes() = endpointService.getRecipes("b1ebb44a352442728ec8ca17a2fb8ab9", "10")
}