package com.example.myrecipeapp

sealed class Screen(val route:String) {
    object RecipeScreen:Screen("recipe-screen")
    object DetailsScreen:Screen("detail-screen")
}