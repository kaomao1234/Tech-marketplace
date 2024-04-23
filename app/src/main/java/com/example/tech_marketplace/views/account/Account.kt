package com.example.tech_marketplace.views.account

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tech_marketplace.viewmodels.AccountViewModel
import com.example.tech_marketplace.views.account.account_info.AccountInfo
import com.example.tech_marketplace.views.account.account_main.AccountMain
import com.example.tech_marketplace.views.account.account_modification.AccountModification
import org.koin.androidx.compose.koinViewModel

@Composable
fun AccountView() {
    val viewModel: AccountViewModel = koinViewModel()
    val localNavController = rememberNavController()
    Scaffold(containerColor = Color.White) {
        NavHost(
            navController = localNavController,
            startDestination = "account",
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(horizontal = 15.dp)
                .padding(top = 24.dp)


        ) {
            composable("account") {
                AccountMain(navController = localNavController, viewModel = viewModel)
            }
            composable("account_info") {
                AccountInfo(navController = localNavController, viewModel = viewModel)
            }
            composable("account_modification/{modSelected}") {
                AccountModification(
                    navController = localNavController,
                    viewModel = viewModel,
                    it.arguments?.getString("modSelected") ?: ""
                )
            }
        }
    }
}