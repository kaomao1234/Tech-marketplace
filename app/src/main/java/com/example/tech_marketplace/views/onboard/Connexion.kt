package com.example.tech_marketplace.views.onboard

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tech_marketplace.R
import com.example.tech_marketplace.ui.theme.CustomColor
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Connexion(onPush:(String)->Unit) {
    val coroutine = rememberCoroutineScope()
    val onScrollTo: (String) -> Unit = { route ->
        onPush(route)
    }
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Connextion",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.weight(1F))
        ElevatedButton(
            onClick = { onScrollTo("create_account") },
            contentPadding = PaddingValues(vertical = 16.dp),
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.elevatedButtonColors(
                containerColor = Color.White,
                contentColor = CustomColor.Blue700
            )
        ) {
            Text(text = "Create an account", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
        }
        Spacer(modifier = Modifier.height(20.dp))
        ElevatedButton(
            onClick = { },
            contentPadding = PaddingValues(vertical = 16.dp),
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.elevatedButtonColors(
                containerColor = Color.White,
                contentColor = CustomColor.Neutral600
            )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.google_icon),
                    contentDescription = ""
                )
                Spacer(modifier = Modifier.width(24.dp))
                Text(
                    text = "Connect with Google",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        ElevatedButton(
            onClick = { },
            contentPadding = PaddingValues(vertical = 16.dp),
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.elevatedButtonColors(
                containerColor = CustomColor.Slate600,
                contentColor = Color.White
            )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.facebook_icon),
                    contentDescription = ""
                )
                Spacer(modifier = Modifier.width(24.dp))
                Text(
                    text = "Connect with Facebook",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
        Spacer(modifier = Modifier.height(40.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Already have an account ? ",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = CustomColor.Yellow400
            )
            TextButton(
                onClick = { onScrollTo("login") }, colors = ButtonDefaults.textButtonColors(
                    contentColor = CustomColor.Yellow400,
                    containerColor = Color.Transparent
                ), contentPadding = PaddingValues(
                    0.dp
                )
            ) {
                Text(
                    text = "Login",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
