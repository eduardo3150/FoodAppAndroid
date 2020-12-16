package com.fireland.foodapp.main

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.fireland.foodapp.BR
import com.fireland.foodapp.helper.Resource
import com.fireland.foodapp.network.FoodService
import kotlinx.coroutines.Dispatchers

class MainViewModel @ViewModelInject constructor(private val foodService: FoodService) :
    ViewModel() {
    var recipeData = RecipeData()

    fun getRecipesList() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = foodService.getRecipes()))
            recipeData.title = foodService.getRecipes().recipes[0].title
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
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

