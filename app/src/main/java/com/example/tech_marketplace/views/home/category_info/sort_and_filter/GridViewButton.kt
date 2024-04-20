package com.example.tech_marketplace.views.home.category_info.sort_and_filter

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.tech_marketplace.ui.theme.CustomColor
import compose.icons.FeatherIcons
import compose.icons.feathericons.Grid
import compose.icons.feathericons.List


@Composable
fun GridViewButton(viewState: String, onPress: () -> Unit) {
    val stringMapIcon = mutableMapOf<String, ImageVector>(
        "grid" to FeatherIcons.Grid,
        "list" to FeatherIcons.List
    )
    IconButton(
        onClick = onPress,
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = Color.Transparent,
            contentColor = CustomColor.Gray400
        )
    ) {
        Icon(imageVector = stringMapIcon[viewState]!!, contentDescription = "")
    }
}
