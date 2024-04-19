package com.example.tech_marketplace.views.home.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tech_marketplace.ui.theme.CustomColor
import compose.icons.AllIcons
import compose.icons.FeatherIcons
import compose.icons.feathericons.Gift
import compose.icons.feathericons.List
import compose.icons.feathericons.Star
import compose.icons.feathericons.Users

@Composable
fun ActionButtonItem(label: String, icon: ImageVector, onPress: () -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        ElevatedButton(
            onClick = onPress,
            modifier = Modifier.size(56.dp),
            colors = ButtonDefaults.elevatedButtonColors(
                contentColor = CustomColor.Blue700, containerColor = CustomColor.Blue100
            ),
            contentPadding = PaddingValues(0.dp),
            shape = CircleShape
        ) {
            Icon(
                imageVector = icon,
                contentDescription = "",

                )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(label, fontSize = 14.sp, color = CustomColor.Blue700)
    }
}

@Composable
fun ActionButton(
    onCategories: () -> Unit,
    onFavorites: () -> Unit,
    onGifts: () -> Unit,
    onBestSelling: () -> Unit,
) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        ActionButtonItem(label = "Categories", icon = FeatherIcons.List, onPress = onCategories)
        ActionButtonItem(label = "Favorites", icon = FeatherIcons.Star, onPress = onFavorites)
        ActionButtonItem(label = "Gifts", icon = FeatherIcons.Gift, onPress = onGifts)
        ActionButtonItem(label = "Best selling", icon = FeatherIcons.Users, onPress = onBestSelling)

    }
}