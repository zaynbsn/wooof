package com.nils.woofapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.nils.woofapp.R
import com.nils.woofapp.montserratFont

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun CustomTopAppBar(navController: NavHostController, title: String, showBackIcon: Boolean) {
    TopAppBar(modifier = Modifier
        .fillMaxWidth(),
        title = {
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 19.sp,
                    fontFamily = montserratFont,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF181D27),
                    textAlign = TextAlign.Center,
                )
            )
        },
        navigationIcon = {
            if (showBackIcon && navController.previousBackStackEntry != null) {
                IconButton(onClick = { navController.navigateUp() }) {
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.chevron_left),
                        contentDescription = "chevron left"
                    )
                }
            } else {
                null
            }
        }
    )
}