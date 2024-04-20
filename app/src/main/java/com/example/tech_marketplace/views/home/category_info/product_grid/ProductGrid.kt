package com.example.tech_marketplace.views.home.category_info.product_grid

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tech_marketplace.models.Product

@Composable
fun ProductGrid(products: List<Product>, viewState: String, onItemPress: (Product) -> Unit) {
    when (viewState) {
        "grid" -> LazyVerticalGrid(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(top = 8.dp, start = 8.dp, end = 8.dp),
            columns = GridCells.Fixed(2),
        ) {

            items(products.size) {
                val item = products[it]
                ProductItem(props = item, viewState = viewState, { onItemPress(item) })
            }
        }

        "list" -> LazyColumn(
            contentPadding = PaddingValues(
                top = 8.dp,
                start = 8.dp,
                end = 8.dp
            ),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(products.size) {
                val item = products[it]
                ProductItem(props = item, viewState = viewState, { onItemPress(item) })
            }
        }
    }

}