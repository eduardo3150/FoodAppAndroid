package com.fireland.foodapp.main

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.fireland.foodapp.BR
import com.fireland.foodapp.network.HttpProvider

class MainViewModel @ViewModelInject constructor(private val httpProvider: HttpProvider) :
    ViewModel() {
    var recipeData = RecipeData()

    fun getRecipesList() {
        recipeData.title = httpProvider.getRecipes()
    }
}

class RecipeData : BaseObservable() {
    @get:Bindable
    var title = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.title)
        }
}

