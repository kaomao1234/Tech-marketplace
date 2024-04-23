package com.example.tech_marketplace.views.checkout.checkout_main.checkout_status

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tech_marketplace.models.CheckoutStatusModel
import com.example.tech_marketplace.ui.theme.CustomColor

@Composable
fun CheckoutStatus(props: CheckoutStatusModel) {
    Column(modifier = Modifier .padding(end = 15.dp).fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Delivery",
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                fontSize = 18.sp
            )
            Column(horizontalAlignment = Alignment.End) {
                Text(text = props.deliveryAddress, color = CustomColor.Blue700, fontSize = 16.sp)
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Fast delivery : ${props.fastDeliveryDate}",
                    color = CustomColor.Gray400,
                    fontSize = 12.sp
                )
            }

        }
        Spacer(modifier = Modifier.padding(horizontal = 8.dp)
            .height(1.dp)
            .fillMaxWidth().background(CustomColor.Blue100))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "Payment",
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                fontSize = 18.sp, modifier = Modifier.weight(1F)
            )
            Column(horizontalAlignment = Alignment.End) {
                Text(text = props.paymentMethod, color = CustomColor.Blue700, fontSize = 16.sp)
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = props.paymentDetails,
                    color = CustomColor.Gray400,
                    fontSize = 12.sp
                )
            }
            IconButton(
                onClick = { /*TODO*/ }, colors = IconButtonDefaults.iconButtonColors(
                    contentColor = CustomColor.Gray400
                )
            ) {
                Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "")
            }

        }
        Spacer(modifier = Modifier.padding(horizontal = 8.dp)
            .height(1.dp)
            .fillMaxWidth().background(CustomColor.Blue100))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "Total",
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                fontSize = 18.sp, modifier = Modifier.weight(1F)
            )

            Column(horizontalAlignment = Alignment.End, verticalArrangement = Arrangement.Center) {
                Text(
                    text = "USD ${props.totalAmount.toInt()}",
                    color = CustomColor.Blue700,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Button(
                    onClick = { /*TODO*/ },
                    contentPadding = PaddingValues(),
                    colors = ButtonDefaults.textButtonColors(
                        contentColor = CustomColor.Emerald500
                    ),
                    modifier = Modifier
                        .defaultMinSize(minHeight = 10.dp)
                        .height(16.dp)
                ) {
                    Text(
                        text = "Enter a discount code",
                        fontSize = 12.sp,
                    )
                }
            }

        }
    }
}