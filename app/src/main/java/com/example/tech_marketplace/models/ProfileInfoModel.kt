package com.example.tech_marketplace.models

data class ProfileInfoModel(
    val username: String,
    val email: String,
    val phoneNumber: String,
    val password: String,
    val accountType: String,
    val image: Int
);