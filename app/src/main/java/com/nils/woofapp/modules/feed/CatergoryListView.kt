package com.nils.woofapp.modules.feed

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nils.woofapp.ui.components.feed.CategoryCard
import com.nils.woofapp.ui.theme.WoofAppTheme

@Composable
fun CategoryListView() {
    Column(
        Modifier
        .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        CategoryCard()
        CategoryCard()
        CategoryCard()
        CategoryCard()
        CategoryCard()
        CategoryCard()
        CategoryCard()
        CategoryCard()
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryListViewPreview() {
    WoofAppTheme {
        CategoryListView()
    }
}