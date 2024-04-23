package com.example.tech_marketplace.views.checkout.order_transport

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.binayshaw7777.kotstep.ui.horizontal.HorizontalSequencedStepper
import com.example.tech_marketplace.ui.theme.CustomColor
import com.example.tech_marketplace.viewmodels.CheckOutViewModel

@Composable
fun OrderTransport(navController: NavController, viewModel: CheckOutViewModel) {
    Scaffold(modifier = Modifier.fillMaxSize(), containerColor = Color.White) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(horizontal = 15.dp)
                .padding(top = 24.dp)
        ) {
            Text(
                "Tracking",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 32.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(24.dp))
            HorizontalSequencedStepper(
                totalSteps = 3,
                currentStep = 3,
                modifier = Modifier.fillMaxWidth(),
                incompleteColor = CustomColor.Gray400,
                completedColor = CustomColor.Blue700,
                stepSize = 50.dp,
                lineThickness = 8.dp,
                stepDescription = listOf("Shipped", "In transit", "Delivered"),
                stepTitleOnIncompleteColor = CustomColor.Gray400
            )
            Spacer(modifier = Modifier.height(32.dp))
            TrackLabel(viewModel.trackNumberState.value)
            Spacer(modifier = Modifier.height(24.dp))
            TrackingSection(items = viewModel.trackingStatusState.value)
            Spacer(modifier = Modifier.height(48.dp))
            Box(
                modifier = Modifier
                    .padding(horizontal = 25.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ) {
                TextButton(
                    onClick = { /*TODO*/ }, colors = ButtonDefaults.textButtonColors(
                        contentColor = CustomColor.Emerald500
                    )
                ) {
                    Text(text = "Report a problem", fontSize = 12.sp)
                }
            }
        }
    }

}