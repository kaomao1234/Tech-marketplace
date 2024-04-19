package com.example.tech_marketplace.views.home.category_info.SortAndFilter

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.tech_marketplace.ui.theme.CustomColor
import compose.icons.FeatherIcons
import compose.icons.feathericons.Grid


@Composable
fun GridViewButton() {
    IconButton(
        onClick = { /*TODO*/ },
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = Color.Transparent,
            contentColor = CustomColor.Gray400
        )
    ) {
        Icon(imageVector = FeatherIcons.Grid, contentDescription = "")

    }
}
