package com.example.myapplication

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

data class Product(val name: String, val currency_type:  String ,val price: Double)

@Composable
fun ProductsScreen(navController: NavController) {
    val products = listOf(
        Product("Product 1", "US$",10.00),
        Product("Product 2","US$", 20.00),
        Product("Product 3","US$", 3000.00)
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 56.dp)
    ) {
        Button(onClick = { navController.navigate("Store") }) {
            Text(text = "Back to store")
        }
        Spacer(modifier = Modifier.height(16.dp))
        products.forEach { product ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text (
                    text = product.name,
                    modifier = Modifier.weight(1f)
                )
                 Text (
                    text = "${product.currency_type} ${product.price}",
                    textAlign = TextAlign.End,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}