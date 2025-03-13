package com.example.quod.presentation

import DocumentVerseScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quod.presentation.screens.BiometryScreen
import com.example.quod.presentation.screens.CellphoneScreen
import com.example.quod.presentation.screens.DocumentFrontalScreen
import com.example.quod.presentation.screens.DocumentScreen
import com.example.quod.presentation.screens.ScoreScreen
import com.example.quod.presentation.screens.Screen
import com.example.quod.presentation.screens.SelfieScreen
import com.example.quod.presentation.screens.SplashScreen
import com.example.quod.presentation.screens.StartScreen
import com.example.quod.presentation.screens.TokenValidationScreen
import com.example.quod.presentation.screens.UserDataScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screen.SplashScreen.route) {
        composable(route = Screen.SplashScreen.route) { SplashScreen(navController = navController) }
        composable(route = Screen.StartScreen.route) { StartScreen(navController = navController) }
        composable(route = Screen.UserDataScreen.route){ UserDataScreen(navController = navController) }
        composable(route = Screen.CellphoneScreen.route){ CellphoneScreen(navController = navController) }
        composable(route = Screen.TokenValidationScreen.route){ TokenValidationScreen(navController = navController) }
        composable(route = Screen.DocumentScreen.route){ DocumentScreen(navController = navController) }
        composable(route = Screen.DocumentFrontalScreen.route){ DocumentFrontalScreen(navController = navController) }
        composable(route = Screen.DocumentVerseScreen.route){ DocumentVerseScreen(navController = navController) }
        composable(route = Screen.SelfieScreen.route){ SelfieScreen(navController = navController) }
        composable(route = Screen.BiometryScreen.route){ BiometryScreen(navController = navController) }
        composable(route = Screen.ScoreScreen.route){ ScoreScreen(navController = navController) }
    }
}