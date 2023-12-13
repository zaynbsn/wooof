package com.nils.woofapp.modules.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.nils.woofapp.NavigationItem
import com.nils.woofapp.modules.details.Details
import com.nils.woofapp.modules.favorites.Favorites
import com.nils.woofapp.modules.feed.Feed
import com.nils.woofapp.modules.login.LoginPage
import com.nils.woofapp.modules.profile.BioData
import com.nils.woofapp.modules.profile.Profile
import com.nils.woofapp.modules.signup.SignUp

@Composable
fun Navigations(navController: NavHostController) {
    val auth = Firebase.auth

    DisposableEffect(Unit) {
        // Observe the authentication state
        val authStateListener = FirebaseAuth.AuthStateListener { auth ->
            val user = auth.currentUser
            if (user != null) {
                // User is signed in
                navController.navigate(NavigationItem.Feed.route)
            } else {
                // User is signed out
                navController.navigate(NavigationItem.Login.route)
            }
        }
        auth.addAuthStateListener(authStateListener)

        // Remove the listener when the composable is disposed
        onDispose {
            auth.removeAuthStateListener(authStateListener)
        }
    }

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
        composable(NavigationItem.Details.route) {
            Details(navController = navController)
        }
    }
}