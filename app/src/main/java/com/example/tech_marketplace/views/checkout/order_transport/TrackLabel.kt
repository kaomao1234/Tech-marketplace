package com.example.tech_marketplace.views.checkout.order_transport

import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ClipboardManager
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tech_marketplace.ui.theme.CustomColor

@Composable
fun TrackLabel(trackNumber:String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(width = 1.dp, color = CustomColor.Stone200, shape = RoundedCornerShape(4.dp))
            .padding(horizontal = 23.dp, vertical = 16.dp)

    ) {
        val context = LocalContext.current
        val clipboardManager: ClipboardManager = LocalClipboardManager.current
        Text(
            text = "Tracking number",
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 47.dp)
        ) {
            Text(
                text = "UPS",
                color = Color.Black,
                fontSize = 16.sp,
            )
            TextButton(onClick = {
                Toast.makeText(context, "copy $trackNumber", Toast.LENGTH_SHORT).show()
                clipboardManager.setText(AnnotatedString(trackNumber))
            }) {
                Text(
                    text = trackNumber,
                    color = CustomColor.Blue700,
                    fontSize = 16.sp,
                )
            }
        }
    }
}