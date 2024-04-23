package com.example.tech_marketplace.models

import java.util.Date

data class CheckoutStatusModel(
    val deliveryAddress: String,
    val fastDeliveryDate: String?,  // Nullable to represent cases where fast delivery isn't chosen
    val paymentMethod: String,
    val paymentDetails: String,
    val totalAmount: Float
)