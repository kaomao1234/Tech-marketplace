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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tech_marketplace.viewmodels.HomeViewModel
import com.example.tech_marketplace.views.home.category_info.SortAndFilter.SortAndFilter
import org.koin.androidx.compose.koinViewModel

@Composable
fun CategoryInfoHome(navController: NavController,viewModel: HomeViewModel) {
    val onBack: () -> Unit = {
        navController.popBackStack()
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
        Text(viewModel.cateInfo.value.label, fontWeight = FontWeight.ExtraBold, fontSize = 24.sp)
        Spacer(modifier = Modifier.height(15.dp))
        SortAndFilter(
            onSorting = { it -> viewModel.onSorting(it) }
        )
        Spacer(modifier = Modifier.height(32.dp))
        ProductGrid(viewModel.cateInfo.value.items)
    }

}