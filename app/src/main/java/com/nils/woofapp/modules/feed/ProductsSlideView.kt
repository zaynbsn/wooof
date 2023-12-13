package com.nils.woofapp.modules.feed

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.nils.woofapp.NavigationItem
import com.nils.woofapp.managers.ProductsManager
import com.nils.woofapp.ui.components.feed.ProductCard
import com.nils.woofapp.ui.theme.WoofAppTheme

@Composable
fun ProductsSlideView(navController: NavHostController) {
    val productsManager = remember { ProductsManager }
    LaunchedEffect(key1 = true) {
        productsManager.getProducts()
    }
    val productsState by productsManager.products.collectAsState()

    Row(
        Modifier
            .fillMaxWidth()
            .padding(start = 24.dp)
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        for (product in productsState) {
            ProductCard(
                product = product,
                onClick = {
                    productsManager.updateSelectedProduct(product)
                    navController.navigate(NavigationItem.Details.route)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductsSlideViewPreview() {
    val navController = rememberNavController()
    WoofAppTheme {
        ProductsSlideView(navController)
    }
}