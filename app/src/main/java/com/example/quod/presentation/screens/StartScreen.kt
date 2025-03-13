package com.example.quod.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.quod.R
import com.example.quod.presentation.components.QuodButtonPrimary

@Composable
fun StartScreen(navController: NavController) {
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
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                QuodButtonPrimary(
                    buttonText = "Crie sua conta",
                    isEnabled = true,
                    onClick = { navController.navigate(Screen.UserDataScreen.route) }
                )
            }
        }
    }

}
