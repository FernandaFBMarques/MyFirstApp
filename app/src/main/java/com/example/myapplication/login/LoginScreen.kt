package com.example.myapplication.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@Composable
fun LoginScreen(viewModel: LoginViewModel) {
    val viewState = viewModel.viewState.collectAsState()
    val username = viewState.value.username ?: ""
    val password = viewState.value.password ?: ""
    LoginScreen(
        username = username,
        password = password,
        onUsernameChanged = viewModel::onUsernameChanged,
        onPasswordChanged = viewModel::onPasswordChanged,
        onLoginClicked = viewModel::onLoginClicked
    )
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun LoginScreen(
    username: String,
    password: String,
    onUsernameChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onLoginClicked: () -> Unit
) {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        GlideImage(
            model = android.R.drawable.screen_background_dark,
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
        ) {
            Text(
                text = "Login",
                fontSize = 32.sp,
                modifier = Modifier
                    .padding(bottom = 16.dp)
            )
            BasicTextField(
                value = username,
                onValueChange = onUsernameChanged,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .background(Color.White)
                    .height(72.dp)
                    .padding(16.dp),
                keyboardOptions = KeyboardOptions.Default,
                decorationBox = { innerTextField ->
                    if (username.isEmpty()) {
                        Text(text = "Username", color = Color.Gray)
                    }
                    innerTextField()
                }
            )
            BasicTextField(
                value = password,
                onValueChange = onPasswordChanged,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .background(Color.White)
                    .height(72.dp)
                    .padding(16.dp),
                keyboardOptions = KeyboardOptions.Default,
                visualTransformation = PasswordVisualTransformation(),
                decorationBox = { innerTextField ->
                    if (password.isEmpty()) {
                        Text(text = "Password", color = Color.Gray)
                    }
                    innerTextField()
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onLoginClicked) {
                Text(text = "Login")
            }
        }
    }
}

@Preview
@Composable
fun Preview() {
    LoginScreen(
        username = "Nanda",
        password = "12345",
        onUsernameChanged = {},
        onPasswordChanged = {},
        onLoginClicked = {}
    )
}
