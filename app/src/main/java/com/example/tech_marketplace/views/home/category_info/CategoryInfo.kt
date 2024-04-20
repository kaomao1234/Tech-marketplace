package com.example.tech_marketplace.views.home.category_info

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tech_marketplace.viewmodels.HomeViewModel
import com.example.tech_marketplace.views.home.category_info.product_grid.ProductGrid
import com.example.tech_marketplace.views.home.category_info.sort_and_filter.SortAndFilter

@Composable
fun CategoryInfoHome(navController: NavController, viewModel: HomeViewModel) {
    val onBack: () -> Unit = {
        navController.popBackStack()
    }
    val viewState = remember {
        mutableStateOf("grid")
    }

    val onGridView: () -> Unit = {
        if (viewState.value == "grid") {
            viewState.value = "list"
        } else {
            viewState.value = "grid"
        }
    }
    Column(horizontalAlignment = Alignment.Start) {
        IconButton(
            onClick = onBack, colors = IconButtonDefaults.iconButtonColors(
                contentColor = Color.Black
            )
        ) {
            Icon(
                Icons.Default.ArrowBack,
                contentDescription = null,
                modifier = Modifier.size(27.dp)
            )

        }
        Spacer(modifier = Modifier.height(26.dp))
        Text(viewModel.cateInfoLabel.value, fontWeight = FontWeight.ExtraBold, fontSize = 24.sp)
        Spacer(modifier = Modifier.height(15.dp))
        SortAndFilter(
            onSorting = { it -> viewModel.onSorting(it) },
            onGridView = onGridView,
            viewState = viewState.value
        )
        Spacer(modifier = Modifier.height(32.dp))
        ProductGrid(
            viewModel.cateInfoItems.value,
            viewState.value,
            onItemPress = viewModel::onCateInfoItemPress
        )
    }

}