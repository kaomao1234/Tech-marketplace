package com.example.tech_marketplace.views.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tech_marketplace.ui.theme.CustomColor
import com.example.tech_marketplace.views.account.AccountView
import com.example.tech_marketplace.views.checkout.CheckOutView
import com.example.tech_marketplace.views.home.HomeView
import com.example.tech_marketplace.views.search.SearchView
import kotlinx.coroutines.launch


sealed class BottomNavItem(val route: String, val icon: ImageVector) {
    data object Home : BottomNavItem("home", Icons.Default.Home)
    data object Search : BottomNavItem("search", Icons.Default.Search)
    data object CheckOut : BottomNavItem("checkout", Icons.Default.ShoppingCart)
    data object Account : BottomNavItem("account", Icons.Default.AccountCircle)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainView(navController: NavController) {
    val contentPagerMap = remember {
        mutableListOf<@Composable() (() -> Unit)>(
            { HomeView() },
            { SearchView() },
            { CheckOutView() },
            { AccountView() }
        )
    }
    val pagerState = rememberPagerState(pageCount = { contentPagerMap.size }, initialPage = 1)
    val coroutine = rememberCoroutineScope()
    val onPush: (index: Int) -> Unit = {
        coroutine.launch {
            pagerState.animateScrollToPage(it)
        }
    }
    val views = remember {
        mutableListOf(
            BottomNavItem.Home,
            BottomNavItem.Search,
            BottomNavItem.CheckOut,
            BottomNavItem.Account
        )
    }
    Scaffold(
        containerColor = Color.White,
        bottomBar = {
            NavigationBar(containerColor = CustomColor.Slate100) {
                views.forEachIndexed { index, bottomNavItem ->
                    NavigationBarItem(colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = CustomColor.Blue700,
                        unselectedIconColor = Color.Black,
                        indicatorColor = CustomColor.Slate100
                    ),
                        selected = index == pagerState.currentPage,
                        onClick = { onPush(index) },
                        icon = { Icon(imageVector = bottomNavItem.icon, contentDescription = "") })
                }
            }
        }
    ) {

        HorizontalPager(
            state = pagerState,
            userScrollEnabled = false,
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .padding(horizontal = 15.dp)
                .padding(top = 24.dp)
        ) { index ->
            contentPagerMap[index]()
        }

    }

}