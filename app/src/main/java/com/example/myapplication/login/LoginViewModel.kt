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

    private val isLoginValid: Boolean
        get() = viewState.value.isLoginValid

    fun onUsernameChanged(input: String) {
        _viewState.update { currentViewState ->
            currentViewState.copy(
                username = input,
                isInvalidUser = false
            )
        }
    }

    fun onPasswordChanged(input: String) {
        _viewState.update { currentViewState ->
            currentViewState.copy(
                password = input,
                isInvalidUser = false
            )
        }
    }

    fun onLoginClicked() {
        if (isLoginValid) {
            navController.navigate("Store")
        } else {
            _viewState.update { currentState ->
                currentState.copy(isInvalidUser = true)
            }
        }
    }

    data class ViewState(
        val username: String? = null,
        val password: String? = null,
        val isInvalidUser: Boolean = false
    ) {
        val isLoginValid: Boolean
            get() = username != null && password != null
    }
}
