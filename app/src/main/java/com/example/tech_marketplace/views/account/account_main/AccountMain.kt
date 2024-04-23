package com.example.tech_marketplace.views.account.account_main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
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
fun AccountMain(navController: NavController, viewModel: AccountViewModel) {
    Scaffold(containerColor = Color.White) {
        Column(modifier = Modifier.padding(it), horizontalAlignment = Alignment.Start) {
            Text(
                "Account",
                color = Color.Black,
                fontSize = 32.sp,
                fontWeight = FontWeight.ExtraBold
            )
            Spacer(modifier = Modifier.height(24.dp))
            ProfileTile(
                username = viewModel.profileInfo.value.username,
                accountType = viewModel.profileInfo.value.accountType,
                image = viewModel.profileInfo.value.image
            )
            Spacer(modifier = Modifier.height(40.dp))
            Column(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                viewModel.settings.forEach {
                    ElevatedButton(
                        {
                            if (viewModel.settingToRoute.containsKey(it)) {
                                navController.navigate(viewModel.settingToRoute[it]!!)
                            }
                        }, colors = ButtonDefaults.elevatedButtonColors(
                            containerColor = Color.White,
                            contentColor = Color.Black
                        ), modifier = Modifier.fillMaxWidth(),
                        contentPadding = PaddingValues(vertical = 16.dp, horizontal = 24.dp),
                        elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 4.dp),
                        shape = RoundedCornerShape(6.dp)
                    ) {
                        Text(
                            it,
                            modifier = Modifier.fillMaxWidth(),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }
        }
    }
}