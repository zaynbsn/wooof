package com.nils.woofapp.modules.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.nils.woofapp.managers.ProductsManager

@Composable
fun Details(navController: NavHostController) {

    val productsManager = remember { ProductsManager }
    val selectedProduct by productsManager.selectedProduct.collectAsState()

    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        Text(text = "Helo it's details page")
        selectedProduct?.let { Text(text = it.title) }
        selectedProduct?.let { Text(text = it.description) }
    }
}