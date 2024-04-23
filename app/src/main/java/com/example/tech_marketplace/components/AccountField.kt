package com.example.tech_marketplace.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AccountField(
    title: String,
    placeHolderText: String,
    controller: MutableState<String>,
    keyboardType: KeyboardType = KeyboardType.Text,
    secure: Boolean = false,
    titleColor: Color=Color.White,
    placeHolderColor: Color = Color.White,
    containerColor: Color = Color.Transparent,
    textColor: Color = Color.White,
    indicatorColor: Color = Color.Transparent,
    cursorColor: Color = Color.White,
    borderColor: Color = Color.White,
    onChange: (value: String) -> Unit
) {
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.Start) {
        Text(text = title, color = titleColor, fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = controller.value,
            onValueChange = onChange,
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    shape = RoundedCornerShape(4.dp),
                    border = BorderStroke(1.dp, color = borderColor)
                ),
            placeholder = {
                Text(
                    text = placeHolderText,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            visualTransformation = if (secure) PasswordVisualTransformation() else VisualTransformation.None,
            colors = TextFieldDefaults.colors(
                focusedPlaceholderColor = placeHolderColor,
                unfocusedPlaceholderColor = placeHolderColor,
                unfocusedContainerColor = containerColor,
                focusedContainerColor = containerColor,
                focusedTextColor = textColor,
                unfocusedTextColor = textColor,
                focusedIndicatorColor = indicatorColor,
                unfocusedIndicatorColor = indicatorColor,
                cursorColor = cursorColor

            )
        )

    }
}