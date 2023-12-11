package com.nils.woofapp.modules.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nils.woofapp.R
import com.nils.woofapp.ui.theme.WoofAppTheme

@Composable
fun CustomNavigationBar() {
    Row(
        Modifier
            .background(color = Color(0xFFFCFCFC))
            .height(67.dp)
            .fillMaxWidth(),

        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        CustomNavigationBarItem(R.drawable.icon_menu_list)
        CustomNavigationBarItem(R.drawable.icon_menu_heart)
        CustomNavigationBarItem(R.drawable.icon_menu_chat)
        CustomNavigationBarItem(R.drawable.icon_menu_user)
    }
}

@Composable
fun CustomNavigationBarItem(icon: Int) {
    Column(Modifier
        .fillMaxHeight(),
    ) {
        Image(
            imageVector = ImageVector.vectorResource(id = icon),
            contentDescription = "list icon",

            modifier = Modifier.fillMaxHeight().size(24.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NavPreview() {
    WoofAppTheme {
        CustomNavigationBar()
    }
}
