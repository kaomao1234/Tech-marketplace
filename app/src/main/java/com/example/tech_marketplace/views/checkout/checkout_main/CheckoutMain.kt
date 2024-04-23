package com.example.tech_marketplace.views.checkout.checkout_main

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.DialogWindowProvider
import androidx.navigation.NavController
import com.example.tech_marketplace.ui.theme.CustomColor
import com.example.tech_marketplace.viewmodels.CheckOutViewModel
import com.example.tech_marketplace.views.checkout.checkout_main.checkout_carousel.CheckoutCarousel
import com.example.tech_marketplace.views.checkout.checkout_main.checkout_status.CheckoutStatus
import com.example.tech_marketplace.views.search.product_info.CartAlert
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckoutMain(navController: NavController, viewModel: CheckOutViewModel) {
    val couroutine = rememberCoroutineScope()
    val blurState = remember {
        mutableStateOf(0F)
    }
    val alphaState = remember {
        mutableStateOf(0F)
    }
    val animateBlur = animateDpAsState(
        targetValue = blurState.value.dp, label = "blur",
        animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing)
    )
    val animateBackground =
        animateColorAsState(
            targetValue = CustomColor.Blue700.copy(alphaState.value),
            animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing),
            label = "background"
        )
    val openAlertDialog = remember {
        mutableStateOf(false)
    }
    val onDismiss = {
        openAlertDialog.value = false
        alphaState.value = 0F
        blurState.value = 0F
    }
    val onPay = {
        openAlertDialog.value = true
        alphaState.value = 0.64F
        blurState.value = 64F
    }
    Scaffold(
        containerColor = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .animateContentSize()
            .blur(animateBlur.value)


    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(top = 24.dp, start = 15.dp)
        ) {
            Text(
                "Checkout",
                color = Color.Black,
                fontSize = 32.sp,
                fontWeight = FontWeight.ExtraBold
            )
            Spacer(modifier = Modifier.height(16.dp))
            CheckoutCarousel(
                viewModel.productCheckOutsState.value,
                onItemRemove = viewModel::onRemove
            )
            Spacer(modifier = Modifier.height(32.dp))
            CheckoutStatus(viewModel.checkoutStatusState.value)
            Spacer(modifier = Modifier.height(32.dp))
            ElevatedButton(
                onClick = onPay,
                contentPadding = PaddingValues(vertical = 16.dp),
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 15.dp),
                colors = ButtonDefaults.elevatedButtonColors(
                    contentColor = Color.White,
                    containerColor = CustomColor.Blue700
                )
            ) {
                Text("Pay", fontSize = 18.sp)
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .animateContentSize()
                .background(animateBackground.value)
        ) {
            if (openAlertDialog.value) {
                AlertDialog(
                    modifier = Modifier.fillMaxSize(),
                    properties = DialogProperties(),
                    onDismissRequest = onDismiss,
                ) {
                    (LocalView.current.parent as DialogWindowProvider).window.setDimAmount(0f)
                    OrderValidation()
                    LaunchedEffect(Unit) {
                        delay(500)
                        onDismiss()
                        navController.navigate("order_transport")

                    }

                }
            }
        }
    }
}