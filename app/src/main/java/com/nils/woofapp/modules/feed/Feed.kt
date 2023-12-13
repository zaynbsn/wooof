package com.nils.woofapp.modules.feed

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.nils.woofapp.modules.navigation.BottomNavigationBar
import com.nils.woofapp.ui.components.MainTitle
import com.nils.woofapp.ui.components.feed.SearchBar
import com.nils.woofapp.ui.theme.WoofAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Feed(navController: NavHostController) {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        SearchBar()
        MainTitle("Près de toi", true, "Sur la carte")
        ProductsSlideView(navController = navController)
        MainTitle("Catégories", true, "Voir tout")
        CategoryListView()
    }
}

@Preview(showBackground = true)
@Composable
fun FeedPreview() {
    val navController = rememberNavController()
    WoofAppTheme {
        Feed(navController = navController)
    }
}

