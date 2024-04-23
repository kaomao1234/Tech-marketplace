package com.example.tech_marketplace.views.checkout

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tech_marketplace.viewmodels.CheckOutViewModel
import com.example.tech_marketplace.views.checkout.checkout_main.CheckoutMain
import com.example.tech_marketplace.views.checkout.order_transport.OrderTransport
import org.koin.androidx.compose.koinViewModel

@Composable
fun CheckoutView() {
    val localNavController = rememberNavController()
    val viewModel: CheckOutViewModel = koinViewModel()
    Scaffold(containerColor = Color.White) {
        NavHost(
            navController = localNavController,
            startDestination = "checkout",
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            composable("checkout") {
                CheckoutMain(navController = localNavController, viewModel)
            }
            composable("order_transport") {
                OrderTransport(navController = localNavController, viewModel)
            }
        }
    }

}