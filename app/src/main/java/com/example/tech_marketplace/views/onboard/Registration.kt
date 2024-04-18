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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Registration() {
    val coroutine = rememberCoroutineScope()
    val contentPagerMap = remember {
        mutableMapOf<String, @Composable() (((route: String) -> Unit) -> Unit)>(
            "connexion" to { Connexion(it) },
            "create_account" to { CreateAccount(onPush = it) },
            "login" to { Login(onPush = it) }
        )
    }
    val pagerState = rememberPagerState(pageCount = { contentPagerMap.size }, initialPage = 0)
    val onPush:(String)->Unit = {
        coroutine.launch {
            val dest = contentPagerMap.keys.indexOf(it)
            pagerState.animateScrollToPage(dest)
        }
    }
    HorizontalPager(
        state = pagerState,
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 56.dp, horizontal = 32.dp), userScrollEnabled = false
    ) {
        val key = contentPagerMap.keys.toList()[it]
        contentPagerMap[key]?.invoke(onPush)

    }
}