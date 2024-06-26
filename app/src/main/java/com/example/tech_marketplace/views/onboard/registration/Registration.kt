package com.example.tech_marketplace.views.onboard.registration

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tech_marketplace.viewmodels.OnboardViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Registration() {
    val viewModel: OnboardViewModel = koinViewModel()
    val coroutine = rememberCoroutineScope()
    val contentPagerMap = remember {
        mutableMapOf<String, @Composable() (((route: String) -> Unit) -> Unit)>(
            "connexion" to { Connexion(viewModel,it) },
            "create_account" to { CreateAccount(viewModel,onPush = it) },
            "login" to { Login(viewModel,onPush = it) }
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
        pageSpacing = 10.dp,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp)
            .padding(top = 30.dp), userScrollEnabled = false
    ) {
        val key = contentPagerMap.keys.toList()[it]
        contentPagerMap[key]?.invoke(onPush)

    }
}