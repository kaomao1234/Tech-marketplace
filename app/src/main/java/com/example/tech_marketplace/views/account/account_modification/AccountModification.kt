package com.example.tech_marketplace.views.account.account_modification

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tech_marketplace.viewmodels.AccountViewModel

@Composable
fun AccountModification(
    navController: NavController,
    viewModel: AccountViewModel,
    modSelected: String
) {

    val onBack: () -> Unit = {
        navController.popBackStack()
    }
    Scaffold(containerColor = Color.White) {
        Column(modifier = Modifier.padding(it), horizontalAlignment = Alignment.Start) {
            IconButton(
                onClick = onBack, colors = IconButtonDefaults.iconButtonColors(
                    contentColor = Color.Black
                )
            ) {
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = null,
                    modifier = Modifier.size(27.dp)
                )

            }
            Spacer(modifier = Modifier.height(24.dp))
            when (modSelected) {
                "email" -> EmailSection(
                    email = viewModel.profileInfo.value.email,
                    onUpdateEmail = viewModel::updateEmail
                )
            }
        }
    }

}