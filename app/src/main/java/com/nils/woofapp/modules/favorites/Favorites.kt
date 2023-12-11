package com.nils.woofapp.modules.favorites

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.nils.woofapp.modules.feed.ProductsSlideView
import com.nils.woofapp.ui.components.MainTitle
import com.nils.woofapp.ui.theme.WoofAppTheme

@Composable
fun Favorites() {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        MainTitle("Gardes à venir")
        ProductsSlideView()
        MainTitle("Gardes passées")
        ProductsSlideView()
    }
}

@Preview(showBackground = true)
@Composable
fun FavoritesPreview() {
    WoofAppTheme {
        Favorites()
    }
}