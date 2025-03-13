package com.example.quod.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quod.R
import com.example.quod.entities.TextFieldType
import com.example.quod.presentation.components.QuodButtonPrimary
import com.example.quod.presentation.components.QuodTextField

@Composable
fun UserDataScreen(navController: NavController) {

    val focusManager = LocalFocusManager.current
    var cpf by remember { mutableStateOf("") }
    var cep by remember { mutableStateOf("") }
    val isButtonEnabled = cpf.length == 11 && cep.length == 8

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
                modifier = Modifier
                    .height(30.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Top
            ) {
                Spacer(modifier = Modifier.height(128.dp))
                Text(
                    color = Color.White,
                    fontSize = 24.sp,
                    text = "Para continuar, precisamos que você nos dê algumas informações"
                )
                Spacer(modifier = Modifier.height(64.dp))
                QuodTextField(
                    labelText = "CPF",
                    textFieldType = TextFieldType.CPF,
                    onValueChanged = { cpf = it }
                )
                when(!isButtonEnabled && cpf.isNotEmpty()){
                    true -> {
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "CPF inválido", color = Color.Red)
                    }
                    else -> focusManager.clearFocus()
                }
                Spacer(modifier = Modifier.height(16.dp))
                QuodTextField(
                    labelText = "CEP",
                    textFieldType = TextFieldType.CEP,
                    onValueChanged = { cep = it }
                )
                when(!isButtonEnabled && cpf.isNotEmpty()){
                    true -> {
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = "CEP inválido", color = Color.Red)
                    }
                    else -> focusManager.clearFocus()
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    QuodButtonPrimary(
                        buttonText = "Continuar",
                        showArrow = true,
                        onClick = { navController.navigate(Screen.CellphoneScreen.route) },
                        isEnabled = isButtonEnabled
                    )
                }
                if (isButtonEnabled) focusManager.clearFocus()
            }
        }
    }
}

