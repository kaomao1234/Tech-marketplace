package com.example.tech_marketplace.views.home.category_info.product_grid

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import com.example.tech_marketplace.models.Product

@Composable
fun ProductGrid(products: List<Product>, viewState: String, onItemPress: (Product) -> Unit) {
    when (viewState) {
        "grid" -> LazyVerticalGrid(columns = GridCells.Fixed(2)) {

            items(products.size) {
                val item = products[it]
                ProductItem(props = item, viewState = viewState, { onItemPress(item) })
            }
        }

        "list" -> LazyColumn {
            items(products.size) {
                val item = products[it]
                ProductItem(props = item, viewState = viewState, { onItemPress(item) })
            }
        }
    }
}