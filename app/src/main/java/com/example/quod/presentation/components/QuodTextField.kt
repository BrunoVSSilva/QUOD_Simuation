package com.example.quod.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.quod.entities.TextFieldType

@Composable
fun QuodTextField(
    labelText: String = "",
    textFieldType: TextFieldType,
    onValueChanged: (String) -> Unit
) {
    var text by remember { mutableStateOf("") }
    var filteredInput by remember { mutableStateOf("") }

    val maxLength = when (textFieldType) {
        TextFieldType.CEP -> 8
        TextFieldType.CPF -> 11
        TextFieldType.CELLPHONE -> 11
        TextFieldType.CODE -> 6
    }

    Row(
        modifier = Modifier
    ) {
        TextField(
            modifier = Modifier
                .width(360.dp)
                .background(Color.Transparent),
            value = text,
            label = { Text(text = labelText) },
            onValueChange = { input ->
                filteredInput = input.filter { it.isDigit() }
                if (filteredInput.length <= maxLength) {
                    text = filteredInput
                    onValueChanged(filteredInput)
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                unfocusedLabelColor = Color(0xFF696969),
                focusedContainerColor = Color.Transparent,
                focusedLabelColor = Color(0xFF696969),
                unfocusedIndicatorColor = Color.White,
                focusedIndicatorColor = Color.White,
                unfocusedTextColor = if (filteredInput.length < maxLength) Color.Red else Color.White,
                focusedTextColor = if (filteredInput.length < maxLength) Color.Red else Color.White,
            )
        )
    }
}
