package com.example.tech_marketplace.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.tech_marketplace.R
import com.example.tech_marketplace.models.ProductModel
import com.example.tech_marketplace.models.ProductSaleModel

class HomeViewModel : ViewModel() {
    val productBanners = listOf<ProductModel>(
        ProductModel(label = "Bose Home Speaker", 279, image = R.drawable.bose_speaker),
        ProductModel(label = "Surface laptop 3", 999, image = R.drawable.surface_laptop),
        ProductModel(label = "XPS laptop 13", 899, image = R.drawable.xps_laptop),
        ProductModel(label = "LG Gram 17", 1399, image = R.drawable.lg_gram)
    )

    val productSales = listOf<ProductSaleModel>(
        ProductSaleModel("Smartphones", "-50%", R.drawable.smartphone_picture),
        ProductSaleModel("Monitors", "-50%", R.drawable.monitor_picture),

        )


    val cateInfoLabel = mutableStateOf("Laptop")
    val cateInfoItems = mutableStateOf(
        listOf<ProductModel>(
            ProductModel(
                label = "Surface laptop 3",
                price = 999,
                image = R.drawable.surface_laptop
            ),
            ProductModel(label = "XPS laptop 13", price = 899, image = R.drawable.xps_laptop),
            ProductModel(label = "LG Gram 17", price = 1399, image = R.drawable.lg_gram),
            ProductModel(label = "Macbook pro 13", price = 1299, image = R.drawable.macbook),
            ProductModel(label = "Huawei", price = 949, image = R.drawable.huawei)
        )
    );
    val categories: List<String> = listOf(
        "All","Laptop", "Computer", "Accessories", "Smartphones", "Smart objects", "Speaker", "Software"
    )


    fun onSorting(key: String = "Ascending") {
        if (key == "Ascending") {
            cateInfoItems.value = cateInfoItems.value.sortedBy { it.price }
        } else if (key == "Descending") {
            cateInfoItems.value = cateInfoItems.value.sortedByDescending { it.price }
        }

    }

    fun onCateInfoItemPress(value: ProductModel) {

    }

    fun onBannerPress(value: ProductModel) {

    }


    fun onCategoryPress(category: String, callBack: () -> Unit = {}) {
        callBack()
    }

    fun onProductSalePress(value: ProductSaleModel) {}
}