package com.example.tech_marketplace.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.tech_marketplace.R
import com.example.tech_marketplace.models.Product
import com.example.tech_marketplace.models.ProductSale

class HomeViewModel : ViewModel() {
    val productBanners = listOf<Product>(
        Product(label = "Bose Home Speaker", 279, image = R.drawable.bose_speaker),
        Product(label = "Surface laptop 3", 999, image = R.drawable.surface_laptop),
        Product(label = "XPS laptop 13", 899, image = R.drawable.xps_laptop),
        Product(label = "LG Gram 17", 1399, image = R.drawable.lg_gram)
    )

    val productSales = listOf<ProductSale>(
        ProductSale("Smartphones", "-50%", R.drawable.smartphone_picture),
        ProductSale("Monitors", "-50%", R.drawable.monitor_picture),

        )


    val cateInfoLabel = mutableStateOf("Laptop")
    val cateInfoItems = mutableStateOf(
        listOf<Product>(
            Product(
                label = "Surface laptop 3",
                price = 999,
                image = R.drawable.surface_laptop
            ),
            Product(label = "XPS laptop 13", price = 899, image = R.drawable.xps_laptop),
            Product(label = "LG Gram 17", price = 1399, image = R.drawable.lg_gram),
            Product(label = "Macbook pro 13", price = 1299, image = R.drawable.macbook),
            Product(label = "Huawei", price = 949, image = R.drawable.huawei)
        )
    );
    val categories: List<String> = listOf(
        "All", "Computer", "Accessories", "Smartphones", "Smart objects", "Speaker", "Software"
    )


    fun onSorting(key: String = "Ascending") {
        if (key == "Ascending") {
            cateInfoItems.value = cateInfoItems.value.sortedBy { it.price }
        } else if (key == "Descending") {
            cateInfoItems.value = cateInfoItems.value.sortedByDescending { it.price }
        }

    }

    fun onCateInfoItemPress(value: Product) {

    }

    fun onBannerPress(value: Product) {

    }


    fun onCategoryPress(category: String, callBack: () -> Unit = {}) {
        callBack()
    }

    fun onProductSalePress(value: ProductSale) {}
}