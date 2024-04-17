package com.example.tech_marketplace.views.onboard

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tech_marketplace.R
import com.example.tech_marketplace.components.DotSlider
import com.example.tech_marketplace.ui.theme.CustomColor
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardView(navController: NavController) {
    val coroutineScope = rememberCoroutineScope()
    val heroBodies = remember {
        mutableListOf<@Composable() (() -> Unit)>(
            { Benefits(image = R.drawable.connection_node, label = "The best tech market") },
            { Benefits(image = R.drawable.computer, label = "A lot of exclusives") },
            { Benefits(image = R.drawable.math_operator, label = "Sales all the time") },
            { Registration() }
        )
    }
    val pagerState = rememberPagerState(pageCount = { heroBodies.size })
    val onNext = {
        if (pagerState.currentPage + 1 < heroBodies.size) {
            coroutineScope.launch {
                pagerState.animateScrollToPage(page = pagerState.currentPage + 1)
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(CustomColor.Blue700),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .padding(horizontal = 5.dp, vertical = 10.dp)
                .weight(1F)
        ) {
            heroBodies[it]()
        }
        Spacer(modifier = Modifier.height(40.dp))
        DotSlider(maxDot = heroBodies.size, selected = pagerState.currentPage)
        Spacer(modifier = Modifier.height(40.dp))
        TextButton(
            onClick = onNext,
            colors = ButtonDefaults.textButtonColors(
                containerColor = Color.Transparent,
                contentColor = Color.White
            )
        ) {
            Text(
                text = if (pagerState.currentPage == 3) "Skip for now" else "Next",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
        Spacer(modifier = Modifier.height(80.dp))
    }

}