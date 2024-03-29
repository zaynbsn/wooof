package com.nils.woofapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nils.woofapp.R
import com.nils.woofapp.ui.theme.WoofAppTheme
import com.nils.woofapp.ui.theme.WoofBlack
import com.nils.woofapp.ui.theme.WoofGrey

@Composable
fun MainTitle(label: String, hasButton: Boolean = false, buttonLabel: String = "") {
    Row(
        Modifier
            .padding(horizontal = 24.dp)
            .padding(vertical = 16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Column {
            Text(text = label, color = WoofBlack, fontSize = 20.sp, fontWeight = FontWeight.W700)
        }
        if (hasButton) {
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                )
                {
                    Text(text = buttonLabel, color = WoofGrey, fontSize = 14.sp)
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.chevron),
                        contentDescription = "chevron"
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainTitlePreview() {
    WoofAppTheme {
        MainTitle("Près de toi", true, "Sur la carte")
    }
}