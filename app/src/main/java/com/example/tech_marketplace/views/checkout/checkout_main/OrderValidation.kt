package com.example.tech_marketplace.views.checkout.checkout_main

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tech_marketplace.ui.theme.CustomColor

@Composable
fun OrderValidation() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box() {
            Box(
                modifier = Modifier
                    .border(10.dp, color = Color.White, shape = CircleShape)
                    .size(137.dp)
                    .background(Color.Transparent, shape = CircleShape)
                    .align(Alignment.Center)
            ) {

            }
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = "",
                modifier = Modifier
                    .size(97.dp)
                    .background(Color.White, shape = CircleShape)
                    .align(Alignment.Center),
                tint = CustomColor.Blue700
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "Order validate!", fontWeight = FontWeight.Bold, fontSize = 24.sp)

    }

}