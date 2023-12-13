package com.nils.woofapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nils.woofapp.ui.theme.WoofAppTheme

@Composable
fun SubTitle(label: String) {
    Row(
        Modifier
            .padding(horizontal = 24.dp)
            .padding(vertical = 16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Column {
            Text(text = label, color = Color(0xFF181D27), fontSize = 14.sp, fontWeight = FontWeight.W500)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SubTitlePreview() {
    WoofAppTheme {
        SubTitle("More")
    }
}