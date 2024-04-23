package com.example.tech_marketplace.views.intro

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tech_marketplace.R
import com.example.tech_marketplace.extension.boxShadow
import com.example.tech_marketplace.ui.theme.CustomColor

@Composable
fun IntroView(navController: NavController) {
    val onPush: (String) -> Unit = { route ->
        navController.navigate(route)
    }
    Scaffold {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .background(CustomColor.Blue700)
                .padding(horizontal = 32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "LATECH",
                fontSize = 42.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 5.sp,
                color = Color.White
            )
            Text(
                "TECH  MARKET",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = 5.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(57.dp))
            Image(
                painterResource(id = R.drawable.logo),
                contentDescription = "",
                modifier = Modifier
                    .size(216.dp)
                    .boxShadow(
                        color = Color.White,
                        blurRadius = 35.dp,
                        spreadRadius = (-8).dp,
                        shape = CircleShape,
                        offset = DpOffset((-10).dp, (-10).dp)
                    )
                    .clip(shape = CircleShape)
                    .background(CustomColor.Blue700)
                    .padding(horizontal = 32.dp)

            )
            Spacer(modifier = Modifier.height(73.dp))
            ElevatedButton(
                onClick = { onPush("onboard") },
                contentPadding = PaddingValues(vertical = 16.dp),
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.elevatedButtonColors(
                    containerColor = Color.White,
                    contentColor = CustomColor.Blue700
                )
            ) {
                Text(text = "Let's start", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
            }
            Spacer(modifier = Modifier.height(73.dp))
            TextButton(
                onClick = { onPush("main") },
                colors = ButtonDefaults.textButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.White
                )
            ) {
                Text(text = "Skip for now", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
            }
        }
    }
}