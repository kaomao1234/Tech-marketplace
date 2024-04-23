package com.example.tech_marketplace.viewmodels

import android.annotation.SuppressLint
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.tech_marketplace.R
import com.example.tech_marketplace.models.CheckoutStatusModel
import com.example.tech_marketplace.models.ProductCheckOutModel
import com.example.tech_marketplace.models.TrackingStatus
import java.time.LocalDate
import java.util.Date

class CheckOutViewModel : ViewModel() {
    private val productCheckOuts = mutableListOf<ProductCheckOutModel>(
        ProductCheckOutModel(
            label = "iPhone 11 Pro",
            price = 999,
            quantity = 1,
            color = "White",
            image = R.drawable.iphone_11
        ),
        ProductCheckOutModel(
            label = "Airpods Pro",
            price = 249,
            quantity = 1,
            color = "White",
            image = R.drawable.airpod
        )
    )

    private val checkoutStatusModel = CheckoutStatusModel(
        deliveryAddress = "12 Madison Avenue, NYC",
        totalAmount = calculateAllProduct(),
        fastDeliveryDate = LocalDate.of(2019, 11, 19).toString(),
        paymentDetails = "Expire 02/20",
        paymentMethod = "Visa ***678"
    )
    private val trackNumber = "LO40569863554NI"
    private val trackingStatuses = mutableListOf<TrackingStatus>(
        TrackingStatus(
            date = LocalDate.of(2019, 11, 1).toString(),
            status = "Seller shipped your order."
        ),
        TrackingStatus(
            date = LocalDate.of(2019, 11, 3).toString(),
            status = "Your order left the sorting center."
        ),
        TrackingStatus(
            date = LocalDate.of(2019, 11, 4).toString(),
            status = "Your order has arrived in Paris, France"
        ),
        TrackingStatus(
            date = LocalDate.of(2019, 11, 5).toString(),
            status = "Your order has left Paris, France."
        )
    )
    val productCheckOutsState = mutableStateOf(productCheckOuts.toList())
    val checkoutStatusState = mutableStateOf(checkoutStatusModel)
    val trackNumberState = mutableStateOf(trackNumber)
    val trackingStatusState = mutableStateOf(trackingStatuses.toList())

    fun onRemove(value: ProductCheckOutModel) {
        productCheckOuts.remove(value)
        checkoutStatusState.value = checkoutStatusModel.copy(totalAmount = calculateAllProduct())
        productCheckOutsState.value = productCheckOuts.toList()
    }

    private fun calculateAllProduct(): Float {
        var sum = 0F
        productCheckOuts.forEach {
            sum += it.quantity * it.price
        }
        return sum
    }
}