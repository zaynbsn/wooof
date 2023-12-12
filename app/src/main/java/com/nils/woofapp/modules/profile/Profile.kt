package com.nils.woofapp.modules.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.nils.woofapp.NavigationItem
import com.nils.woofapp.R
import com.nils.woofapp.ui.components.MainTitle
import com.nils.woofapp.ui.components.SubTitle
import com.nils.woofapp.ui.components.profile.ProfileInfos
import com.nils.woofapp.ui.components.profile.SettingRow
import com.nils.woofapp.ui.theme.WoofAppTheme

@Composable
fun Profile(navController: NavHostController) {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(color = Color(0xFFFCFCFC)),
    ) {
        MainTitle("Profile", false)
        ProfileInfos()
        Column(
            Modifier
                .padding(top = 16.dp)
                .shadow(
                    elevation = 44.dp,
                    spotColor = Color(0x0F000000),
                    ambientColor = Color(0x0F000000)
                ),
        ) {
            SettingRow(
                text = "Mon compte",
                subText = "Modifie tes informations",
                icon = R.drawable.icon_profile,
                onClick = {
                    navController.navigate(NavigationItem.BioData.route)
                }
            )
            SettingRow(text = "Face ID / Touch ID", subText = "Gère la sécurité", icon = R.drawable.icon_lock, switch = true)
            SettingRow(text = "Déconnexion", subText = "On se revoit bientôt ?", icon = R.drawable.icon_logout)
        }
        SubTitle("More")
        Column(
            Modifier
                .padding(top = 16.dp)
                .shadow(
                    elevation = 44.dp,
                    spotColor = Color(0x0F000000),
                    ambientColor = Color(0x0F000000)
                ),
        ) {
            SettingRow(text = "Aide & Support", subText = "", icon = R.drawable.icon_notification)
            SettingRow(text = "À propos de l'application", subText = "", icon = R.drawable.icon_heart)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    val navController = rememberNavController()
    WoofAppTheme {
        Profile(navController)
    }
}