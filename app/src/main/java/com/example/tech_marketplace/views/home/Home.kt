package com.example.tech_marketplace.views.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tech_marketplace.viewmodels.HomeViewModel
import com.example.tech_marketplace.viewmodels.OnboardViewModel
import com.example.tech_marketplace.views.home.categories.CategoriesHome
import com.example.tech_marketplace.views.home.category_info.CategoryInfoHome
import com.example.tech_marketplace.views.home.home.Home
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.getKoin
import org.koin.compose.koinInject
import org.koin.core.Koin
import org.koin.core.annotation.KoinInternalApi
import org.koin.core.qualifier.named

@OptIn(KoinInternalApi::class)
@Composable
fun HomeView() {
    val localNavController = rememberNavController()
    val viewModel: HomeViewModel = koinViewModel()
    Scaffold {
        NavHost(
            navController = localNavController,
            startDestination ="category_info",
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            composable("home") {
                Home(navController = localNavController,viewModel)
            }
            composable("categories") {
                CategoriesHome(navController = localNavController,viewModel)
            }
            composable("category_info") {
                CategoryInfoHome(navController = localNavController,viewModel)
            }

        }
    }
}