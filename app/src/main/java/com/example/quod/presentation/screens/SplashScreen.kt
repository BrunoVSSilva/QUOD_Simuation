package com.example.quod.presentation.screens

import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.quod.R

@Composable
fun SplashScreen(navController: NavController) {

    LaunchedEffect(Unit) {
        Handler(Looper.getMainLooper()).postDelayed({
            navController.navigate(Screen.StartScreen.route) {
                popUpTo("splash") { inclusive = true }
            }
        }, 1500)
    }

    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF1E1E1E))
                .padding(innerPadding)
                .padding(32.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.quod_ic),
                contentDescription = "Imagem de fundo",
                modifier = Modifier.fillMaxSize(),
            )
        }
    }
}
