package com.example.tech_marketplace.viewmodels

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeViewModel = HomeViewModel()
val onboardViewModel = OnboardViewModel()
val accountViewModel = AccountViewModel()
val searchViewModel = SearchViewModel()
val checkOutViewModel = CheckOutViewModel()

val viewModelModule = module {
    viewModel {
        onboardViewModel
    }
    viewModel {
        homeViewModel
    }
    viewModel {
        accountViewModel
    }
    viewModel {
        searchViewModel
    }
    viewModel {
        checkOutViewModel
    }
}