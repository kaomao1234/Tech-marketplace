package com.example.tech_marketplace.views.onboard

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Registration() {
    val contentPager = remember {
        mutableListOf<@Composable() ((PagerState) -> Unit)>(
            { Connexion(it) }, { CreateAccount(it) }, { Login(it) }
        )
    }
    val pagerState = rememberPagerState(pageCount = { contentPager.size })
    HorizontalPager(
        state = pagerState,
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 56.dp, horizontal = 32.dp), userScrollEnabled = false
    ) {
        contentPager[it](pagerState)

    }
}