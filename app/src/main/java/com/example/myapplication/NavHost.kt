package com.example.myapplication

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.login.LoginScreen
import com.example.myapplication.login.LoginViewModel

@Composable
fun MainNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String = "Login"
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable("Login"){
            val viewModel = LoginViewModel(navController = navController)
            LoginScreen(viewModel)
        }
        composable("Store"){
            StoreScreen(navController = navController)
        }
        composable("Products") {
            ProductsScreen(navController = navController)
        }
    }
}