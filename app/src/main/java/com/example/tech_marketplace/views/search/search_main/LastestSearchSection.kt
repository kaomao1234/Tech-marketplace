package com.example.tech_marketplace.views.search.search_main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tech_marketplace.ui.theme.CustomColor

@Composable
fun LastestSearchSection(
    modifier: Modifier,
    items: List<String>,
    onHistorySelect: (String) -> Unit,
    onCleanHistory: () -> Unit,
    onRemoveHistory: (String) -> Unit
) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Last search",
                fontSize = 24.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
            TextButton(onClick = onCleanHistory) {
                Text(text = "Clean all history", fontSize = 14.sp, color = CustomColor.Gray400)
            }
        }
      Column(modifier = Modifier.fillMaxWidth()) {
          items.forEach {
              Row(
                  modifier = Modifier.fillMaxWidth(),
                  horizontalArrangement = Arrangement.SpaceBetween,
                  verticalAlignment = Alignment.CenterVertically
              ) {
                  TextButton(
                      onClick = { onHistorySelect(it) },
                      contentPadding = PaddingValues(vertical = 0.dp)
                  ) {
                      Text(text = it, fontSize = 16.sp, color = CustomColor.Gray400)
                  }
                  IconButton(
                      onClick = { onRemoveHistory(it) },
                      colors = IconButtonDefaults.iconButtonColors(
                          contentColor = CustomColor.Gray400
                      )
                  ) {
                      Icon(
                          imageVector = Icons.Default.Clear,
                          contentDescription = "",
                      )
                  }
              }
          }
      }
    }
}