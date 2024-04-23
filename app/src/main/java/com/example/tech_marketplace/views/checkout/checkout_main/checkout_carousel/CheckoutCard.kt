package com.example.tech_marketplace.views.checkout.checkout_main.checkout_carousel

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tech_marketplace.models.ProductCheckOutModel
import com.example.tech_marketplace.ui.theme.CustomColor
import compose.icons.FeatherIcons
import compose.icons.feathericons.XCircle

@Composable
fun CheckoutCard(modifier: Modifier,props:ProductCheckOutModel,onRemove:()->Unit) {
    Column(modifier = modifier, verticalArrangement = Arrangement.SpaceBetween) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "New",
                fontSize = 12.sp,
                color = CustomColor.Blue700,
                modifier = Modifier
                    .background(CustomColor.Blue100, shape = RoundedCornerShape(2.dp))
                    .padding(4.dp)
            )
            IconButton(
                onClick = onRemove, colors = IconButtonDefaults.iconButtonColors(
                    contentColor = CustomColor.Gray400
                )
            ) {
                Icon(imageVector = FeatherIcons.XCircle, contentDescription = "")
            }
        }
        Spacer(modifier = Modifier.height(43.dp))
        Image(
            painter = painterResource(id = props.image),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .weight(1F)
        )
        Spacer(modifier = Modifier.height(37.dp))
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                props.label,
                fontSize = 18.sp,
                color = Color.Black,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "USD ${props.price}",
                    fontSize = 14.sp,
                    color = CustomColor.Blue700,
                )
                Text(
                    text = "x${props.quantity}",
                    fontSize = 14.sp,
                    color = CustomColor.Blue700,
                    modifier = Modifier
                        .background(CustomColor.Blue100, shape = RoundedCornerShape(2.dp))
                        .padding(4.dp)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text =props.color,
                fontSize = 12.sp,
                color = CustomColor.Gray400,
            )
        }

    }

}