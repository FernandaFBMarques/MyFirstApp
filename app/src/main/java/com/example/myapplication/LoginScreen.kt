package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun LoginScreen(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

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
                onValueChange = { username = it },
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
                onValueChange = { password = it },
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
            Button(onClick = {
                navController.navigate("Store")
            }) {
                Text(text = "Login")
            }
        }
    }
}

@Preview
@Composable
fun Preview() {
    LoginScreen(navController = NavController(LocalContext.current))
}
