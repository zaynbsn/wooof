package com.nils.woofapp.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nils.woofapp.modules.profile.onClick
import com.nils.woofapp.montserratFont
import com.nils.woofapp.ui.theme.WoofPurple

@Composable
fun MainButton(label: String) {
    Button(modifier = Modifier
        .padding(top = 16.dp),
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(containerColor = WoofPurple), // Change color here
        shape = RoundedCornerShape(16.dp)
    ) {
        Text(modifier = Modifier
            .padding(vertical = 8.dp, horizontal = 48.dp),
            text = label,
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = montserratFont,
                fontWeight = FontWeight(500),
                color = Color(0xFFFFFFFF),
                textAlign = TextAlign.Center,
            )
        )
    }
}