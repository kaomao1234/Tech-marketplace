package com.example.tech_marketplace.views.search.search_main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.example.tech_marketplace.viewmodels.SearchViewModel

@Composable
fun SearchMain(navController: NavController, viewModel: SearchViewModel) {

    Scaffold(
        containerColor = Color.White, modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 15.dp)
            .padding(top = 24.dp)
    ) {
        Column(
            modifier = Modifier.padding(it),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            Text("Search", fontWeight = FontWeight.ExtraBold, fontSize = 32.sp, color = Color.Black)
            SearchField(value = viewModel.searchController.value, onChange = viewModel::onChange)
            LastViewedSection(
                modifier = Modifier.padding(horizontal = 8.dp),
                products = viewModel.products,
                onItemPress = { it ->
                    navController.navigate("product_info")
                    viewModel.onLastViewedItemPress(it)
                }
            )
            LastestSearchSection(
                modifier = Modifier.fillMaxWidth(),
                items = viewModel.history,
                onCleanHistory = viewModel::onCleanHistory,
                onHistorySelect = viewModel::onHistorySelect,
                onRemoveHistory = viewModel::onRemoveHistory
            )
        }
    }
}