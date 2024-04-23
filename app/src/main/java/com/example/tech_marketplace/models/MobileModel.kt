package com.example.tech_marketplace.models

import androidx.compose.ui.graphics.Color


data class MobileModel(
    val label: String,
    val images: List<Int>,
    val colors: List<Color>,
    val capacities: List<Int>
);
