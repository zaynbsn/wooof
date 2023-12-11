package com.nils.woofapp.ui.components.profile.biodata

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nils.woofapp.R
import com.nils.woofapp.montserratFont
import com.nils.woofapp.ui.theme.WoofBlack
import com.nils.woofapp.ui.theme.WoofGrey

@Composable
fun BioDataHeader() {
    Column(
        Modifier
            .padding(horizontal = 24.dp)
            .padding(top = 16.dp, bottom = 40.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(21.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Image(painter = painterResource(id = R.drawable.dominique), contentDescription = "profile picture", modifier = Modifier.size(72.dp) )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                Text(
                    text = "Dominique Dancre",
                    color = WoofBlack,
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W700,
                    fontFamily = montserratFont
                )
            }
            Row {
                Text(
                    text = "@ddancre.cci",
                    color = WoofGrey,
                    textAlign = TextAlign.Center,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.W400,
                    fontFamily = montserratFont
                )
            }
        }
    }
}