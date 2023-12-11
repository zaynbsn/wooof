package com.nils.woofapp.modules.feed

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.nils.woofapp.ui.components.MainTitle
import com.nils.woofapp.ui.components.feed.SearchBar
import com.nils.woofapp.ui.theme.WoofAppTheme

@Composable
fun Feed() {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        ) {
        SearchBar()
        MainTitle("Près de toi", true, "Sur la carte")
        ProductsSlideView()
        MainTitle("Catégories", true, "Voir tout")
        CategoryListView()
    }
}

@Preview(showBackground = true)
@Composable
fun FeedPreview() {
    WoofAppTheme {
        Feed()
    }
}