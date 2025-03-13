package com.example.quod.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import com.example.quod.BiometricAuthenticator
import com.example.quod.R
import com.example.quod.presentation.components.QuodButtonPrimary

@Composable
fun BiometryScreen(navController: NavController) {

    val context = LocalContext.current
    val biometricAuthenticator = BiometricAuthenticator(context)
    val activity = context as FragmentActivity

    var message by remember { mutableStateOf("") }

    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF1E1E1E))
                .padding(innerPadding)
                .padding(30.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.quod_ic),
                    contentDescription = "Icone",
                    modifier = Modifier
                        .height(30.dp),
                )
            }
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Column {
                    Spacer(modifier = Modifier.height(102.dp))
                    Text(
                        color = Color.White,
                        fontSize = 24.sp,
                        text = "Vamos cadastrar sua",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                    Text(
                        color = Color.White,
                        fontSize = 24.sp,
                        text = "digital",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
            }
            Box {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.biometry),
                            contentDescription = "Imagem de exemplo",
                            modifier = Modifier.height(124.dp)
                        )
                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = message,
                    color = Color.White,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(16.dp))
                QuodButtonPrimary(
                    buttonText = "Registrar Biometria",
                    showArrow = false,
                    isEnabled = true,
                ) {
                    biometricAuthenticator.promptBiometricAuth(
                        title = "Cadastrar biometria",
                        subTitle = "Use sua digital",
                        negativeButtonText = "Biometria cancelada",
                        fragmentActivity = activity,
                        onSuccess = {
                            message = "Registrado com sucesso!"
                            navController.navigate(Screen.ScoreScreen.route)
                        },
                        onError = { _, errorString ->
                            message = errorString.toString()
                        },
                        onFailed = {
                            message = "Erro no cadastro"
                        }
                    )
                }
            }
        }
    }
}