package com.example.quod.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun QUODPopup(popupText: String, onClick: () -> Unit) {
    val backgroundColor = Color(0xFFD9D9D9)
    val textColor = Color(0xFF121212)
    Box(
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
            .background(backgroundColor, RoundedCornerShape(8.dp))
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(modifier = Modifier,
                text = popupText,
                color = textColor,
                fontSize = 24.sp)
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = "Arrow Icon",
                tint = textColor
            )
        }

    }
}

@Preview
@Composable
fun PopupPreview() {
    QUODPopup("123456") {  }
}