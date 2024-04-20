package com.example.tech_marketplace.views.search

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tech_marketplace.viewmodels.SearchViewModel
import com.example.tech_marketplace.views.search.product_info.ProductInfo
import com.example.tech_marketplace.views.search.search_main.SearchMain
import org.koin.androidx.compose.koinViewModel

@Composable
fun SearchView() {
    val localNavController = rememberNavController()
    val viewModel: SearchViewModel = koinViewModel()
    NavHost(navController = localNavController, startDestination = "search") {
        composable("search") {
            SearchMain(localNavController, viewModel)
        }
        composable("product_info") {
            ProductInfo(navController = localNavController, viewModel = viewModel)
        }
    }

}