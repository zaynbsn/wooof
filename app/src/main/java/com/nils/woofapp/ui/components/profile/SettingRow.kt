package com.nils.woofapp.ui.components.profile

import  androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nils.woofapp.R
import com.nils.woofapp.montserratFont
import com.nils.woofapp.ui.theme.WoofGrey

@Composable
fun SettingRow(text: String, subText: String, icon: Int, switch: Boolean = false) {
    Row(
        Modifier
        .padding(horizontal = 24.dp)
        .fillMaxWidth()
        .background(color = Color(0xFFFFFFFF)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Column(
            Modifier
            .padding(16.dp)
            .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(48.dp))
            .size(40.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                imageVector = ImageVector.vectorResource(id = icon),
                contentDescription = "profile icon",
                modifier = Modifier.size(20.dp)
            )
        }
        Column {
            Row {
                Text(text = text, color = Color(0xFF181D27), fontSize = 13.sp, fontFamily = montserratFont)

            }
            Row {
                Text(text = subText, color = WoofGrey, fontSize = 11.sp, fontWeight = FontWeight.W400, fontFamily = montserratFont)
            }
        }
        Spacer(Modifier.weight(1f))
        Column(Modifier.padding(end = 16.dp)) {
            if (switch) {
                var checked by remember { mutableStateOf(false) }

                Switch(
                    checked = checked,
                    onCheckedChange = {
                        checked = it
                    }
                )
            } else {
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.chevron),
                    contentDescription = "chevron",
                    modifier = Modifier.size(12.dp)
                )
            }
        }
    }
}