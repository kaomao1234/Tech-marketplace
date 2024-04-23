package com.example.tech_marketplace.views.search.product_info

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tech_marketplace.components.DotSlider
import com.example.tech_marketplace.ui.theme.CustomColor

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductImageSlider(modifier: Modifier, images: List<Int>) {
//    val selectedImage = rememberUpdatedState(newValue = 0);
    val pagerState = rememberPagerState(pageCount = { images.size }, initialPage = 0)
    Column(modifier = modifier, horizontalAlignment = Alignment.Start) {
        Text(
            text = "New",
            fontSize = 14.sp,
            color = CustomColor.Blue700,
            modifier = Modifier
                .background(CustomColor.Blue100, shape = RoundedCornerShape(2.dp))
                .padding(4.dp)
        )
        Spacer(modifier = Modifier.height(25.dp))
        HorizontalPager(state = pagerState) {
            Image(
                painter = painterResource(id = images[it]),
                contentDescription = "",
                modifier = Modifier.height(190.dp).fillMaxWidth()
            )
        }
        Spacer(modifier = Modifier.height(23.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            DotSlider(
                maxDot = images.size,
                selected = pagerState.currentPage,
                color = CustomColor.Gray400
            )
        }
    }
}