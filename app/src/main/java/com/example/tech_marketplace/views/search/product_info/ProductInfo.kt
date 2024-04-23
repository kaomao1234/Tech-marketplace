package com.example.tech_marketplace.views.search.product_info

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import  androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.DialogWindowProvider
import androidx.navigation.NavController
import com.example.tech_marketplace.ui.theme.CustomColor
import com.example.tech_marketplace.viewmodels.SearchViewModel
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductInfo(navController: NavController, viewModel: SearchViewModel) {
    val blurState = remember {
        mutableStateOf(0F)
    }
    val alphaState = remember {
        mutableStateOf(0F)
    }
    val openAlertDialog = remember {
        mutableStateOf(false)
    }
    val animateBlur = animateDpAsState(
        targetValue = blurState.value.dp,
        animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing), label = "blur"
    )
    val animateAlpha = animateFloatAsState(
        targetValue = alphaState.value,
        animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing), label = "alpha"
    )
    val onBack: () -> Unit = {
        navController.popBackStack()
    }
    val onDismiss = {
        openAlertDialog.value = false
        blurState.value = 0F
        alphaState.value = 0F
    }
    val onAddToCart = {
        openAlertDialog.value = true
        blurState.value = 64F
        alphaState.value = 0.64F
    }
    Scaffold(
        containerColor = Color.White, modifier = Modifier
            .fillMaxSize()
            .animateContentSize()
            .blur(animateBlur.value)
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(horizontal = 15.dp)
                .padding(top = 24.dp),
            horizontalAlignment = Alignment.Start,
        ) {
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
            Text(
                viewModel.searchProductInfo.label,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(32.dp))
            Column(
                modifier = Modifier
                    .padding(horizontal = 14.dp),
                verticalArrangement = Arrangement.Top
            ) {
                ProductImageSlider(
                    modifier = Modifier.fillMaxWidth(),
                    viewModel.searchProductInfo.images
                )
                Spacer(modifier = Modifier.height(15.dp))
                ColorRadioButton(
                    colors = viewModel.searchProductInfo.colors,
                    state = viewModel.selectedColorState
                )
                Spacer(modifier = Modifier.height(32.dp))
                CapacityRadioButton(
                    capacities = viewModel.searchProductInfo.capacities,
                    state = viewModel.selectedCapacityState
                )
            }
            Spacer(modifier = Modifier.height(32.dp))
            ElevatedButton(
                onClick = onAddToCart,
                contentPadding = PaddingValues(vertical = 16.dp),
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.elevatedButtonColors(
                    contentColor = Color.White,
                    containerColor = CustomColor.Blue700
                )
            ) {
                Text("Add to cart", fontSize = 18.sp)
            }
            Box(modifier = Modifier
                .fillMaxSize()
                .animateContentSize()
                .alpha(animateAlpha.value)) {
                if (openAlertDialog.value) {
                    AlertDialog(
                        modifier = Modifier.fillMaxSize(),
                        properties = DialogProperties(),
                        onDismissRequest = onDismiss,
                    ) {
                        (LocalView.current.parent as DialogWindowProvider).window.setDimAmount(0f)

                        CartAlert(onDismiss)

                    }
                }
            }
        }
    }
}