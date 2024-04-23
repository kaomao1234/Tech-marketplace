package com.example.tech_marketplace.views.account.account_info

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tech_marketplace.viewmodels.AccountViewModel

@Composable
fun AccountInfo(navController: NavController, viewModel: AccountViewModel) {
    val onBack: () -> Unit = {
        navController.popBackStack()
    }
    val onNavigate: (String) -> Unit = {
        it
        navController.navigate("account_modification/${it}")
    }
    Scaffold(containerColor = Color.White) {
        Column(modifier = Modifier.padding(it), horizontalAlignment = Alignment.Start) {
            IconButton(
                onClick = onBack, colors = IconButtonDefaults.iconButtonColors(
                    contentColor = Color.Black
                )
            ) {
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = null,
                    modifier = Modifier.size(27.dp)
                )

            }
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                "Account information",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(32.dp))
            Column(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(40.dp)
            ) {
                AccountInfoItem(
                    title = "User name",
                    subtitle = viewModel.profileInfo.value.username,
                    onChange = {})
                AccountInfoItem(
                    title = "Email",
                    subtitle = viewModel.profileInfo.value.email,
                    onChange = { onNavigate("email") })
                AccountInfoItem(
                    title = "Phone number",
                    subtitle = viewModel.profileInfo.value.phoneNumber,
                    onChange = {})
                AccountInfoItem(
                    title = "Password",
                    subtitle = "*".repeat(viewModel.profileInfo.value.password.length),
                    onChange = {})
                AccountInfoItem(
                    title = "Account type",
                    subtitle = viewModel.profileInfo.value.accountType,
                    onChange = {})
            }
        }
    }
}