package com.nils.woofapp.modules.feed

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nils.woofapp.ui.components.feed.ProductCard
import com.nils.woofapp.ui.theme.WoofAppTheme

@Composable
fun ProductsSlideView() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(start = 24.dp)
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ProductCard()
        ProductCard()
        ProductCard()
        ProductCard()
    }
}

@Preview(showBackground = true)
@Composable
fun ProductsSlideViewPreview() {
    WoofAppTheme {
        ProductsSlideView()
    }
}