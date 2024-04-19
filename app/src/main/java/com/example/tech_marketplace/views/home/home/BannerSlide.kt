package com.example.tech_marketplace.views.home.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tech_marketplace.components.DotSlider
import com.example.tech_marketplace.models.Product
import com.example.tech_marketplace.ui.theme.CustomColor
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BannerSlide(items: List<Product>, onBannerPress: ((Product) -> Unit)?) {
    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { items.size })
    val isReverse = remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        HorizontalPager(
            pageSpacing = 5.dp,
            state = pagerState, modifier = Modifier
                .fillMaxWidth()
                .height(110.dp)
        ) {
            val item = items[it]
            ElevatedButton(
                onClick = { onBannerPress?.invoke(item) },
                contentPadding = PaddingValues(0.dp),
                shape = RoundedCornerShape(6.dp),
                colors = ButtonDefaults.elevatedButtonColors(
                    containerColor = CustomColor.Blue700,
                    contentColor = Color.White
                )
            ) {
                Row(
                    Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Column(horizontalAlignment = Alignment.Start) {
                        Text(item.label, fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text("USD ${item.price}", fontSize = 12.sp)
                    }
                    Spacer(modifier = Modifier.width(44.dp))
                    Image(
                        painter = painterResource(id = item.image),
                        contentDescription = "",
                        Modifier.size(78.dp)
                    )

                }
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
        DotSlider(
            maxDot = items.size,
            selected = pagerState.currentPage,
            color = CustomColor.Gray400
        )
        LaunchedEffect(Unit) {
            while (true) {
                delay(2000) // Adjust delay between scrolls
                coroutineScope.launch {
                    if (!isReverse.value) {
                        if (pagerState.currentPage < items.size - 1) {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        } else {
                            isReverse.value = true
                        }
                    } else {
                        if (pagerState.currentPage > 0) {
                            pagerState.animateScrollToPage(pagerState.currentPage - 1)
                        } else {
                            isReverse.value = false
                        }
                    }
                }
            }
        }
    }
}