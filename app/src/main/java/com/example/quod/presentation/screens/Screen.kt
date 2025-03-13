package com.example.quod.presentation.screens

sealed class Screen (val route: String) {
    object SplashScreen : Screen("splash_screen")
    object StartScreen : Screen("start_screen")
    object UserDataScreen : Screen("userData_screen")
    object CellphoneScreen : Screen("cellphone_screen")
    object DocumentScreen : Screen("document_screen")
    object TokenValidationScreen : Screen("tokenValidation_screen")
    object DocumentFrontalScreen : Screen("document_frontal_screen")
    object DocumentVerseScreen : Screen("document_verse_screen")
    object SelfieScreen : Screen("selfie_screen")
    object BiometryScreen : Screen("biometry_screen")
    object ScoreScreen : Screen("score_screen")
}