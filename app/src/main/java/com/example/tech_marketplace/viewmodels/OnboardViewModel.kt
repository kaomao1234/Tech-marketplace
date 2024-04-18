package com.example.tech_marketplace.viewmodels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class OnboardViewModel : ViewModel() {
    val createAccountEmail = mutableStateOf("")
    val createAccountPassword = mutableStateOf("")
    val createAccountFullName = mutableStateOf("")
    val loginEmail = mutableStateOf("")
    val loginPassword = mutableStateOf("")

    fun onChange(value: String, state: MutableState<String>) {
        state.value = value
    }

    fun onConnectWithGoogle() {

    }

    fun onConnectWithFacebook() {

    }

    fun onCreateAccountValidate() {

    }

    fun onLoginValidate() {

    }

    fun clearCreateAccountData() {
        createAccountEmail.value = ""
        createAccountPassword.value = ""
        createAccountFullName.value = ""
    }

    fun clearLoginData() {
        loginEmail.value = ""
        loginPassword.value = ""
    }

}
