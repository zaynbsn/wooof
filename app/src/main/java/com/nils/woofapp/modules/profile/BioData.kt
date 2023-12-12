package com.nils.woofapp.modules.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.nils.woofapp.NavigationItem
import com.nils.woofapp.ui.components.Dropdown
import com.nils.woofapp.ui.components.Input
import com.nils.woofapp.ui.components.MainButton
import com.nils.woofapp.ui.components.profile.biodata.BioDataHeader
import com.nils.woofapp.ui.theme.WoofAppTheme

@Composable
fun BioData(navController: NavHostController) {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(color = Color(0xFFFCFCFC)),
    ) {
        BioDataHeader()
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Input("Quel est ton prénom ?")
            Input("Et ton nom de famille ?")
            Input("Numéro de téléphone")
            Dropdown()
            MainButton(label = "Mettre à jour le profil"){
                navController.navigate(NavigationItem.Profile.route)
            }

        }

    }

}

fun onClick() {
    TODO("Not yet implemented")
}

@Preview(showBackground = true)
@Composable
fun BioDataPreview() {
    val navController = rememberNavController()
    WoofAppTheme {
        BioData(navController = navController)
    }
}