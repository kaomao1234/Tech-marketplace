package com.example.tech_marketplace.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp

@Composable
fun DotSlider(maxDot: Int, selected: Int,color: Color) {
    LazyRow(
        modifier = Modifier.width((8.5 * maxDot).dp).height(7.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        items(maxDot) { index ->
            val alpha: State<Float> = animateFloatAsState(
                if (index == selected
                ) 1f else 0.5f, label = "alpha"
            )
            Box(
                modifier = Modifier
                    .animateContentSize()
                    .size(
                        if (index == selected) 7.dp else 5.dp
                    )
                    .graphicsLayer(alpha = alpha.value)
                    .background(color, shape = CircleShape)
            )
        }
    }

}