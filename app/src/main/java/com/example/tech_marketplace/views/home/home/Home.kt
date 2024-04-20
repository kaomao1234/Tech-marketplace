package com.example.tech_marketplace.views.home.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
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
import com.example.tech_marketplace.views.home.home.sales_grid.SalesGrid

@Composable
fun Home(navController: NavController, viewModel: HomeViewModel) {

    Scaffold(containerColor = Color.White) {
        Column(
            modifier = Modifier
                .padding(it)
                .verticalScroll(rememberScrollState()), horizontalAlignment = Alignment.Start
        ) {
            Text("Home", fontWeight = FontWeight.ExtraBold, fontSize = 32.sp, color = Color.Black)
            Spacer(modifier = Modifier.height(24.dp))
            BannerSlide(items = viewModel.productBanners, onBannerPress = viewModel::onBannerPress)
            Spacer(modifier = Modifier.height(29.dp))
            ActionButton(
                onCategories = {
                    navController.navigate("categories")
                },
                onFavorites = {},
                onGifts = {}, onBestSelling = {}
            )
            Spacer(modifier = Modifier.height(40.dp))
            SalesGrid(
                listItem = viewModel.productSales,
                onProductPress = { it -> viewModel.onProductSalePress(it) })
        }
    }
}