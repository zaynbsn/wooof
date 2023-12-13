package com.nils.woofapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.List
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.nils.woofapp.managers.ProductsManager
import com.nils.woofapp.models.Product
import com.nils.woofapp.modules.feed.CategoryListView
import com.nils.woofapp.modules.feed.ProductsSlideView
import com.nils.woofapp.modules.navigation.BottomNavigationBar
import com.nils.woofapp.modules.navigation.Navigations
import com.nils.woofapp.ui.components.MainTitle
import com.nils.woofapp.ui.components.feed.SearchBar
import com.nils.woofapp.ui.theme.WoofAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            WoofAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(navController = navController)
                }
            }
        }
    }
}

val montserratFont = FontFamily(
    Font(R.font.montserrat_thin, FontWeight.Thin),
    Font(R.font.montserrat_light, FontWeight.Light),
    Font(R.font.montserrat_regular, FontWeight.Normal),
    Font(R.font.montserrat_medium, FontWeight.Medium),
    Font(R.font.montserrat_semibold, FontWeight.SemiBold),
    Font(R.font.montserrat_bold, FontWeight.Bold)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavHostController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    
    when (val currentRoute = navBackStackEntry?.destination?.route) {
        NavigationItem.Login.route,
        NavigationItem.SignUp.route,
        NavigationItem.BioData.route,
        NavigationItem.Details.route -> {
            Navigations(navController = navController)
        } else -> {
            Scaffold(
                bottomBar = {
                    BottomAppBar(modifier = Modifier) {
                        BottomNavigationBar(navController = navController)
                    }
                },
                floatingActionButton = {
                    FloatingActionButton(onClick = {}) {
                        Icon(Icons.Filled.Add, "Add")
                    }
                }
            ) { innerPadding ->
                Box(
                    modifier = Modifier.padding(
                        PaddingValues(
                            0.dp,
                            0.dp,
                            0.dp,
                            innerPadding.calculateBottomPadding()
                        )
                    )
                ) {
                    Navigations(navController = navController)
                }
            }
        }
    }
}

sealed class NavigationItem(var route: String, val icon: ImageVector?, var title: String) {
    object Feed : NavigationItem("Feed", Icons.Rounded.List, "Feed")
    object Favorites : NavigationItem("Chat", Icons.Rounded.FavoriteBorder, "Favorites")
    object Chat : NavigationItem("Profile", Icons.Filled.Send, "Chat")
    object Profile : NavigationItem("Profile", Icons.Rounded.Person, "Profile")
    object Login : NavigationItem("Login", Icons.Filled.Send, "login")
    object SignUp : NavigationItem("SignUp", Icons.Filled.Send, "SignUp")
    object MainScreen : NavigationItem("MainScreen", Icons.Filled.Send, "MainScreen")
    object BioData : NavigationItem("BioData", Icons.Filled.Send, "BioData")
    object Details : NavigationItem("Details", Icons.Filled.Send, "Details")
}

@Composable
fun Greetings(modifier: Modifier = Modifier) {
    val products: State<List<Product>> = ProductsManager.products.collectAsState()
    Column {
       products.value.forEach { product ->
            Text(text = product.title)
            Text(text = product.description)
        }
    }
    Button(onClick = { ProductsManager.getProducts()}) {
        Text(text = "Récuperer les produits")
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    val navController = rememberNavController()
    WoofAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MainScreen(navController = navController)
        }
    }
}
