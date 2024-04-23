package com.example.tech_marketplace.views.home.home_main.sales_grid

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tech_marketplace.models.ProductSaleModel
import com.example.tech_marketplace.ui.theme.CustomColor

@Composable
fun SalesGridItem(model: ProductSaleModel, onProductPress: () -> Unit) {
    ElevatedButton(
        onClick = onProductPress,
        modifier = Modifier
            .height(250.dp),
        colors = ButtonDefaults.elevatedButtonColors(
            contentColor = CustomColor.Blue700,
            containerColor = Color.White
        ),
        contentPadding = PaddingValues(8.dp),
        shape = RoundedCornerShape(6.dp),
        elevation = ButtonDefaults.elevatedButtonElevation(
            defaultElevation = 4.dp
        )
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start,

            ) {
            Text(
                text = model.discount,
                fontSize = 12.sp,
                modifier = Modifier
                    .background(CustomColor.Blue100, shape = RoundedCornerShape(2.dp))
                    .padding(4.dp)
            )
            Image(
                painter = painterResource(id = model.image),
                contentDescription = "",
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = model.label,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}

