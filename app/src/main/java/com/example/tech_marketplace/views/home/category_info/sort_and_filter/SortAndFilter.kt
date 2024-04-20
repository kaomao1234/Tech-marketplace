package com.example.tech_marketplace.views.home.category_info.sort_and_filter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun SortAndFilter(
    onSorting: (String) -> Unit,
    viewState:String,
    onGridView:()->Unit
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        SorterDropdownButton(onSorting = onSorting)
        Spacer(modifier = Modifier.width(22.dp))
        FilterDropdownButton()
        Spacer(modifier = Modifier.width(51.dp))
        GridViewButton(viewState, onGridView)
        Spacer(modifier = Modifier.weight(1F))
    }


}