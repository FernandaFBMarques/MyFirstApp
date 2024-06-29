package com.example.myapplication.login

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel(
    private val navController: NavController
) : ViewModel() {
    private val _viewState = MutableStateFlow(ViewState())
    val viewState = _viewState.asStateFlow()

    fun onUsernameChanged(input: String) {
        _viewState.update { currentViewState ->
            currentViewState.copy(username = input)
        }
    }

    fun onPasswordChanged(input: String) {
        _viewState.update { currentViewState ->
            currentViewState.copy(password = input)
        }
    }

    fun onLoginClicked() {
        navController.navigate("Store")
    }

    data class ViewState(
        val username: String? = null,
        val password: String? = null
    )
}
