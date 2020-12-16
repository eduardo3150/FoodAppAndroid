package com.fireland.foodapp.network

import javax.inject.Inject

interface HttpProvider {
    fun getRecipes(): String
}

class HttpProviderImpl @Inject constructor() : HttpProvider {
    override fun getRecipes(): String {
        return "Here you go fam!"
    }
}