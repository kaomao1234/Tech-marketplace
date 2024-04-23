package com.example.tech_marketplace.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.tech_marketplace.R
import com.example.tech_marketplace.models.ProfileInfoModel


class AccountViewModel : ViewModel() {
    val profileInfo = mutableStateOf(
        ProfileInfoModel(
            username = "Jame Warden",
            email = "j-warden@email.com",
            phoneNumber = "+33 6 16 39 54 78",
            password = "13245678",
            accountType = "Premium",
            image = R.drawable.profile_image
        )
    )
    val settingToRoute = mapOf<String, String>(
        "Account information" to "account_info"
    )
    val settings = listOf<String>(
        "Orders",
        "Returns and refunds",
        "Account information",
        "Security and settings",
        "Help"
    )

    fun updateEmail(val1: String, val2: String) {
        if (val1 == val2) {
            val data = profileInfo.value.copy(email = val1)
            profileInfo.value = data
        }
    }

}