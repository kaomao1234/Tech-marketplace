package com.example.tech_marketplace.views.onboard

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tech_marketplace.components.AccountField
import com.example.tech_marketplace.ui.theme.CustomColor
import com.example.tech_marketplace.viewmodels.OnboardViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CreateAccount(onPush: (String) -> Unit) {
    val viewModel: OnboardViewModel = viewModel()
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Create an account",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.weight(1F))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            AccountField(
                title = "Full name",
                placeHolderText = "Full name",
                controller = viewModel.createAccountFullName,
                onChange = { value -> viewModel.onChange(value, viewModel.createAccountFullName) }
            )
            Spacer(modifier = Modifier.height(24.dp))
            AccountField(
                title = "Email",
                placeHolderText = "Email",
                controller = viewModel.createAccountEmail,
                onChange = { value -> viewModel.onChange(value, viewModel.createAccountEmail) },
                keyboardType = KeyboardType.Email
            )
            Spacer(modifier = Modifier.height(24.dp))
            AccountField(
                title = "Password",
                placeHolderText = "Password",
                controller = viewModel.createAccountPassword,
                onChange = { value -> viewModel.onChange(value, viewModel.createAccountPassword) },
                secure = true,
                keyboardType = KeyboardType.Password
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
        ElevatedButton(
            onClick = viewModel::onCreateAccountValidate,
            contentPadding = PaddingValues(vertical = 16.dp),
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.elevatedButtonColors(
                containerColor = Color.White,
                contentColor = CustomColor.Blue700
            )
        ) {
            Text(text = "Validate", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
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
                onClick = { onPush("login") }, colors = ButtonDefaults.textButtonColors(
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