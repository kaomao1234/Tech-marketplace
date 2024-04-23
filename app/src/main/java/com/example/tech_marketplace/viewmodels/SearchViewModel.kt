package com.example.tech_marketplace.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.tech_marketplace.R
import com.example.tech_marketplace.models.MobileModel
import com.example.tech_marketplace.models.ProductModel
import com.example.tech_marketplace.ui.theme.CustomColor

class SearchViewModel : ViewModel() {
    val searchController = mutableStateOf<String>("")
    val products = listOf<ProductModel>(
        ProductModel("Google Home mini", price = 49, R.drawable.google_home_mini),
        ProductModel("USB C Charger", price = 11, R.drawable.usb_c_charger)
    )
    val history = mutableStateListOf("Smart speaker", "USB-C charger")

    val searchProductInfo = MobileModel(
        label = "iPhone 11 Pro", images = listOf(
            R.drawable.iphone_11, R.drawable.iphone_11, R.drawable.iphone_11, R.drawable.iphone_11
        ), colors = listOf(
            CustomColor.Neutral600, CustomColor.Stone200, CustomColor.Neutral500, CustomColor.Red200
        ), capacities = listOf(64, 256, 512)
    )

    val selectedColorState = mutableStateOf<Color>(searchProductInfo.colors[0])
    val selectedCapacityState = mutableIntStateOf(searchProductInfo.capacities[0])
    fun onChange(value: String) {
        searchController.value = value
    }

    fun onLastViewedItemPress(value: ProductModel) {
    }

    fun onHistorySelect(value: String) {
        searchController.value = value
    }

    fun onCleanHistory() {
        history.clear()
    }

    fun onRemoveHistory(value: String) {
        history.remove(value)
    }
}