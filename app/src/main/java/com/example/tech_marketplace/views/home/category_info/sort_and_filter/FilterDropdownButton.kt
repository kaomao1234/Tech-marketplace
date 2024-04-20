package com.example.tech_marketplace.views.home.category_info.sort_and_filter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tech_marketplace.ui.theme.CustomColor

@Composable
fun FilterDropdownButton() {
    val selectedFilter = remember {
        mutableStateOf("")
    }
    val filterExpand = remember {
        mutableStateOf(false)
    };
    val onItemsPress: (key: String) -> Unit = {
        selectedFilter.value = it
        filterExpand.value = !filterExpand.value
    }
    val filterKeys = remember {
        mutableListOf<String>()
    }
    val onExpand: (Boolean) -> Unit = {
        filterExpand.value = it
    }

    Box(modifier = Modifier.wrapContentSize(Alignment.BottomCenter)) {
        TextButton(
            onClick = { onExpand(true) },
            shape = RoundedCornerShape(6.dp),
            colors = ButtonDefaults.textButtonColors(
                contentColor = CustomColor.Gray400,
                containerColor = Color.Transparent
            )
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Filter", fontSize = 14.sp)
                Spacer(modifier = Modifier.width(6.dp))
                Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "")
            }

            DropdownMenu(
                expanded = filterExpand.value,
                onDismissRequest = { onExpand(false) }
            ) {

            }

        }
    }
}
