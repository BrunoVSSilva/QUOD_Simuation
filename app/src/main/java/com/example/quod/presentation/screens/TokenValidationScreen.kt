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
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quod.R
import com.example.quod.entities.TextFieldType
import com.example.quod.presentation.components.QUODPopup
import com.example.quod.presentation.components.QuodButtonPrimary
import com.example.quod.presentation.components.QuodTextField
import kotlin.random.Random

@Composable
fun TokenValidationScreen(navController: NavController) {
    val focusManager = LocalFocusManager.current
    val clipboardManager = LocalClipboardManager.current
    var insertedCode by remember { mutableStateOf("") }
    val generatedCode = remember { generateCode() }
    val isButtonEnabled = insertedCode == generatedCode

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
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Spacer(modifier = Modifier.height(128.dp))
                    Text(
                        color = Color.White,
                        fontSize = 24.sp,
                        text = "Por favor, insira seu número de celular"
                    )
                    Spacer(modifier = Modifier.height(64.dp))
                    QuodTextField(
                        labelText = "Código de validação",
                        textFieldType = TextFieldType.CODE,
                        onValueChanged = { insertedCode = it }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    when(!isButtonEnabled && insertedCode.isNotEmpty()){
                        true -> Text(text = "Código inválido", color = Color.Red)
                        else -> focusManager.clearFocus()
                    }
                    Spacer(modifier = Modifier.height(64.dp))
                    QUODPopup(generatedCode) {
                        clipboardManager.setText(AnnotatedString(text = generatedCode))
                    }
                }
                QuodButtonPrimary(
                    buttonText = "Continuar",
                    showArrow = true,
                    onClick = { navController.navigate(Screen.DocumentScreen.route) },
                    isEnabled = isButtonEnabled
                )
            }
        }
    }
}

fun generateCode(): String {
    return List(6) { Random.nextInt(0, 10) }.joinToString("")
}
