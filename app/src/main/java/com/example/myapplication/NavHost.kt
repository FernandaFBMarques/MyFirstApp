package com.example.myapplication

import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String = "Store"
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable("Login"){
            LoginScreen(navController = navController)
        }
        composable("Store"){
            StoreScreen(navController = navController)
        }
        composable("Products") {
            ProductsScreen(navController = navController)
        }
    }
}