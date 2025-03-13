package com.example.quod.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quod.presentation.ui.theme.QUODTheme

@Composable
fun QuodButtonPrimary(
    buttonText: String,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    showArrow: Boolean = false,
    onClick: () -> Unit
) {
    val backgroundColor = if (isEnabled) Color(0xFFD9D9D9) else Color.Gray
    val textColor = if (isEnabled) Color(0xFF121212) else Color.LightGray

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(backgroundColor, RoundedCornerShape(8.dp))
            .clickable(isEnabled) { if (isEnabled) onClick() },
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = buttonText,
                color = textColor,
                fontSize = 24.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(end = if (showArrow) 8.dp else 0.dp)
            )
            if (showArrow) {
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Arrow Icon",
                    tint = textColor
                )
            }
        }
    }
}

@Composable
fun QuodButtonSecondary(
    buttonText: String,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    showArrow: Boolean = false,
    onClick: () -> Unit
) {
    val backgroundColor = if (isEnabled) Color.Transparent else Color.Gray
    val textColor = if (isEnabled) Color.White else Color.LightGray
    val borderColor = if (isEnabled) Color.White else Color.LightGray


    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(backgroundColor, RoundedCornerShape(8.dp))
            .clickable(isEnabled) { if (isEnabled) onClick() }
            .border(
                width = 2.dp,
                color = borderColor,
                shape = RoundedCornerShape(8.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = buttonText,
                color = textColor,
                fontSize = 24.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(end = if (showArrow) 8.dp else 0.dp)
            )
            if (showArrow) {
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Arrow Icon",
                    tint = textColor
                )
            }
        }
    }
}



@Preview
@Composable
fun QuodButtonPrimaryWithIconPreview() {
    QUODTheme {
        QuodButtonPrimary("Primary Button", showArrow = true, onClick = {})
    }
}

@Preview
@Composable
fun QuodButtonPrimaryPreview() {
    QUODTheme {
        QuodButtonPrimary("Primary Button", showArrow = false, onClick = {})
    }
}

@Preview
@Composable
fun QuodButtonSecondaryWithIconPreview() {
    QUODTheme {
        QuodButtonSecondary("Secondary Button", showArrow = true, onClick = {})
    }
}

@Preview
@Composable
fun QuodButtonSecondaryPreview() {
    QUODTheme {
        QuodButtonSecondary("Secondary Button", showArrow = false, onClick = {})
    }
}
