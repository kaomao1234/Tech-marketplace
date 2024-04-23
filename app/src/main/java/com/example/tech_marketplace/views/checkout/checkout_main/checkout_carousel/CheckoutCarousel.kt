package com.example.tech_marketplace.views.checkout.checkout_main.checkout_carousel

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tech_marketplace.models.ProductCheckOutModel
import com.example.tech_marketplace.ui.theme.CustomColor

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CheckoutCarousel(
    props: List<ProductCheckOutModel>,
    onItemRemove: (ProductCheckOutModel) -> Unit
) {
    val pagerState = rememberPagerState(pageCount = { props.size }, initialPage = 0)
    HorizontalPager(state = pagerState, contentPadding = PaddingValues(end = 120.dp)) {
        val item = props[it]
        CheckoutCard(
            props = item,
            onRemove = { onItemRemove(item) },
            modifier = Modifier
                .padding(end = 10.dp)
                .fillMaxHeight(0.51F)
                .fillMaxWidth()
                .border(2.dp, color = CustomColor.Slate100, shape = RoundedCornerShape(6.dp))
                .padding(8.dp)

        )
    }
}