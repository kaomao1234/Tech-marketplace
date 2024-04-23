package com.example.tech_marketplace.views.search.search_main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tech_marketplace.ui.theme.CustomColor

@Composable
fun SearchField(value: String, onChange: (String) -> Unit) {
    TextField(
        textStyle = TextStyle(fontSize = 16.sp),
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(22.dp),
        leadingIcon = {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 20.dp)
            ) {
                Icon(imageVector = Icons.Default.Search, contentDescription = "")
                Spacer(
                    modifier = Modifier
                        .background(CustomColor.Gray400)
                        .height(30.dp)
                        .width(1.dp)
                )
            }


        },
        placeholder = {
            Text("What are you looking for ?")
        },
        value = value, onValueChange = onChange, colors = TextFieldDefaults.colors(
            unfocusedTextColor = CustomColor.Blue700,
            focusedTextColor = CustomColor.Blue700,
            unfocusedPlaceholderColor = CustomColor.Blue700,
            focusedPlaceholderColor = CustomColor.Blue700,
            focusedLeadingIconColor = CustomColor.Blue700,
            unfocusedLeadingIconColor = CustomColor.Blue700,
            unfocusedContainerColor = CustomColor.Blue100,
            focusedContainerColor = CustomColor.Blue100,
            cursorColor = CustomColor.Blue700,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}