package com.fireland.foodapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Recipes(
    @SerializedName("title") val title: String,
    @SerializedName("readyInMinutes") val readyInMinutes: Int) : Parcelable

@Parcelize
data class RecipesMain(@SerializedName("recipes") val recipes: List<Recipes>) : Parcelable