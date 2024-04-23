package com.example.tech_marketplace.views.account.account_modification

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tech_marketplace.components.AccountField
import com.example.tech_marketplace.ui.theme.CustomColor

@Composable
fun EmailSection(email: String, onUpdateEmail: (String,String)->Unit) {
    val emailAddress = remember {
        mutableStateOf("")
    }
    val confirmEmailAddress = remember {
        mutableStateOf("")
    }
    Column(horizontalAlignment = Alignment.Start) {
        Text(
            "Email",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(32.dp))
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(horizontal = 8.dp)
        ) {
            Text(
                "Actual email address",
                fontSize = 18.sp,
                color = Color.Black,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(email, fontSize = 16.sp, color = CustomColor.Blue700)
            Spacer(modifier = Modifier.height(56.dp))
            AccountField(
                title = "New email address",
                placeHolderText = "email",
                controller = emailAddress,
                titleColor = Color.Black,
                placeHolderColor = CustomColor.Gray400,
                borderColor = CustomColor.Gray400,
                cursorColor = Color.Black,
                textColor = Color.Black,
                onChange = {
                    emailAddress.value = it
                }
            )
            Spacer(modifier = Modifier.height(32.dp))
            AccountField(
                title = "Confirm email address",
                placeHolderText = "email",
                controller = confirmEmailAddress,
                titleColor = Color.Black,
                placeHolderColor = CustomColor.Gray400,
                borderColor = CustomColor.Gray400,
                cursorColor = Color.Black,
                textColor = Color.Black,
                onChange = {
                    confirmEmailAddress.value = it
                }
            )
            Spacer(modifier = Modifier.height(40.dp))
            ElevatedButton(
                onClick = { onUpdateEmail(emailAddress.value, confirmEmailAddress.value) },
                contentPadding = PaddingValues(vertical = 16.dp),
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.elevatedButtonColors(
                    contentColor = Color.White,
                    containerColor = CustomColor.Blue700
                )
            ) {
                Text("Confirm modification", fontSize = 18.sp)
            }
        }
    }
}