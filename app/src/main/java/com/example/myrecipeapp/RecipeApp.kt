package com.example.myrecipeapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun RecipeApp(navController: NavHostController){
        val recipeViewModel: MainViewModel = viewModel()
        val viewstate by recipeViewModel.categoriesState
    
    NavHost(navController = navController, startDestination = Screen.RecipeScreen.route ) {
        composable(route = Screen.RecipeScreen.route){
            RecipeScreen(viewstate= viewstate, navigateToDetail = {
                navController.currentBackStackEntry?.savedStateHandle?.set("cat",it)
                navController.navigate(Screen.DetailsScreen.route)
            })
        }
        composable(route= Screen.DetailsScreen.route){
            val category = navController.previousBackStackEntry?.savedStateHandle?.
                get<Category>("cat") ?: Category("","","","")
            CategoryDetailScreen(category = category)
        }
    }

}

@Preview
@Composable
fun Preview_Function(){
    val navController = rememberNavController()
    RecipeApp(navController = navController )
}