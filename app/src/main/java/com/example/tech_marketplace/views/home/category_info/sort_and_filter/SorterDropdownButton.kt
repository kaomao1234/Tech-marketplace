package com.example.tech_marketplace.views.home.category_info.sort_and_filter

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
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
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tech_marketplace.ui.theme.CustomColor
import compose.icons.FeatherIcons
import compose.icons.feathericons.ArrowUp

@Composable
fun SorterDropdownButton(onSorting: (String) -> Unit) {
    val selectedSort = remember {
        mutableStateOf("Ascending")
    }
    val sortExpand = remember {
        mutableStateOf(false)
    };
    val animateRotate =
        animateFloatAsState(
            targetValue = if (selectedSort.value == "Descending") 180F else 0F,
            label = "rotateZ"
        )
    val onItemsPress: (key: String) -> Unit = {
        onSorting(it)
        selectedSort.value = it
        sortExpand.value = !sortExpand.value
    }
    val sortKeys = remember {
        mutableListOf("Ascending", "Descending")
    }
    val onExpand: (Boolean) -> Unit = {
        sortExpand.value = it
    }
    Box(modifier = Modifier.wrapContentSize(Alignment.BottomCenter)) {
        ElevatedButton(
            onClick = { onExpand(true) },
            shape = RoundedCornerShape(6.dp),
            modifier = Modifier.width(180.dp),
            border = BorderStroke(
                width = 1.dp,
                color = CustomColor.Gray400,
            ),

            colors = ButtonDefaults.elevatedButtonColors(
                contentColor = CustomColor.Gray400,
                containerColor = Color.White
            )
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(selectedSort.value, fontSize = 14.sp)
                Spacer(modifier = Modifier.weight(1F))
                Icon(
                    imageVector = FeatherIcons.ArrowUp,
                    contentDescription = "",
                    modifier = Modifier.graphicsLayer(rotationZ = animateRotate.value)
                )
                Spacer(modifier = Modifier.weight(1F))
                Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "")
            }

        }
        DropdownMenu(
            expanded = sortExpand.value,
            onDismissRequest = { onExpand(false) },
            modifier = Modifier.background(Color.White)
        ) {

            sortKeys.forEach {
                DropdownMenuItem(
                    text = { Text(text = it) },
                    colors = MenuDefaults.itemColors(
                        textColor = CustomColor.Gray400,

                    ),
                    onClick = {
                        onItemsPress(it)
                    })
            }

        }
    }


}
