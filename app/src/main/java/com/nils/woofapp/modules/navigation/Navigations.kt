package com.nils.woofapp.modules.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.nils.woofapp.NavigationItem
import com.nils.woofapp.modules.favorites.Favorites
import com.nils.woofapp.modules.feed.Feed
import com.nils.woofapp.modules.profile.Profile

@Composable
fun Navigations(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Feed.route) {
        composable(NavigationItem.Feed.route) {
            Feed()
        }
        composable(NavigationItem.Favorites.route) {
            Favorites()
        }
        composable(NavigationItem.Chat.route) {
            Feed()
        }
        composable(NavigationItem.Profile.route) {
            Profile()
        }
    }
}