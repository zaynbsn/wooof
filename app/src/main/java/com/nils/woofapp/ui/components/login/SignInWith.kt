package com.nils.woofapp.ui.components.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nils.woofapp.R

@Composable
fun SignInWith() {
    Box {
        Row(modifier = Modifier.align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.spacedBy(9.09173583984375.dp, Alignment.End),
            verticalAlignment = Alignment.Top,
        ) {
            SignInIcon(icon = R.drawable.icon_google)
            SignInIcon(icon = R.drawable.icon_facebook)
            SignInIcon(icon = R.drawable.icon_apple)
        }
    }
}