package com.example.tech_marketplace.views.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tech_marketplace.viewmodels.HomeViewModel
import com.example.tech_marketplace.views.home.categories.CategoriesHome
import com.example.tech_marketplace.views.home.category_info.CategoryInfoHome
import com.example.tech_marketplace.views.home.home_main.HomeMain
import org.koin.androidx.compose.koinViewModel
import org.koin.core.annotation.KoinInternalApi

@OptIn(KoinInternalApi::class)
@Composable
fun HomeView() {
    val localNavController = rememberNavController()
    val viewModel: HomeViewModel = koinViewModel()
    Scaffold(containerColor = Color.White) {
        NavHost(
            navController = localNavController,
            startDestination = "home",
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(horizontal = 15.dp)
                .padding(top = 24.dp)
        ) {
            composable("home") {
                HomeMain(navController = localNavController, viewModel)
            }
            composable("categories") {
                CategoriesHome(navController = localNavController, viewModel)
            }
            composable("category_info") {
                CategoryInfoHome(navController = localNavController, viewModel)
            }
        }
    }
}