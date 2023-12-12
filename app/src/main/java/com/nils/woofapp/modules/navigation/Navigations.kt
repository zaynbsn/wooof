package com.nils.woofapp.modules.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.nils.woofapp.NavigationItem
import com.nils.woofapp.modules.favorites.Favorites
import com.nils.woofapp.modules.feed.Feed
import com.nils.woofapp.modules.login.LoginPage
import com.nils.woofapp.modules.profile.BioData
import com.nils.woofapp.modules.profile.Profile
import com.nils.woofapp.modules.signup.SignUp

@Composable
fun Navigations(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Login.route) {
        composable(NavigationItem.Login.route) {
            LoginPage(navController = navController)
        }
        composable(NavigationItem.SignUp.route) {
            SignUp(navController = navController)
        }
        composable(NavigationItem.Feed.route) {
            Feed(navController = navController)
        }
        composable(NavigationItem.Favorites.route) {
            Favorites(navController = navController)
        }
        composable(NavigationItem.Chat.route) {
            Feed(navController = navController)
        }
        composable(NavigationItem.Profile.route) {
            Profile(navController = navController)
        }
        composable(NavigationItem.BioData.route) {
            BioData(navController = navController)
        }
    }
}