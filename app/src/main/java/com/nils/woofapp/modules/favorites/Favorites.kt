package com.nils.woofapp.modules.favorites

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.nils.woofapp.modules.feed.ProductsSlideView
import com.nils.woofapp.ui.components.MainTitle
import com.nils.woofapp.ui.theme.WoofAppTheme

@Composable
fun Favorites(navController: NavHostController) {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        MainTitle("Gardes à venir")
        ProductsSlideView(navController = navController)
        MainTitle("Gardes passées")
        ProductsSlideView(navController = navController)
    }
}

@Preview(showBackground = true)
@Composable
fun FavoritesPreview() {
    val navController = rememberNavController()
    WoofAppTheme {
        Favorites(navController = navController)
    }
}