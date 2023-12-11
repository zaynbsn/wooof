package com.nils.woofapp.ui.components.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nils.woofapp.R
import com.nils.woofapp.montserratFont
import com.nils.woofapp.ui.theme.WoofAppTheme
import com.nils.woofapp.ui.theme.WoofPurple

@Composable
fun ProfileInfos() {
    Row(
        Modifier
            .padding(horizontal = 24.dp)
            .padding(top = 16.dp)
            .fillMaxWidth()
            .background(WoofPurple, shape = RoundedCornerShape(16.dp))
            .shadow(elevation = 44.dp, spotColor = Color(0x0F000000), ambientColor = Color(0x0F000000)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Column(Modifier.padding(16.dp)) {
            Image(painter = painterResource(id = R.drawable.dominique), contentDescription = "profile picture", modifier = Modifier.size(53.dp))
        }
        Column {
            Row {
                Text(
                    text = "Dominique Dancre",
                    color = Color(0xFFFFFFFF),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W700,
                    fontFamily = montserratFont
                )
            }
            Row {
                Text(
                    text = "@ddancre_cci",
                    color = Color(0xFFFFCF53),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.W600,
                    fontFamily = montserratFont
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileInfosPreview() {
    WoofAppTheme {
        ProfileInfos()
    }
}