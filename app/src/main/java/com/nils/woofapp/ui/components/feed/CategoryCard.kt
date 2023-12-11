package com.nils.woofapp.ui.components.feed

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nils.woofapp.R
import com.nils.woofapp.ui.theme.WoofAppTheme

@Composable
fun CategoryCard() {
    Row(
        Modifier
            .padding(horizontal = 24.dp)
            .fillMaxWidth()
            .background(color = Color.White, shape = RoundedCornerShape(16.dp)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            Modifier
            .padding(start = 12.dp, top = 12.dp, bottom = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Column {
                // Image(imageVector = ImageVector.vectorResource(id = R.drawable.icon_moving), contentDescription = "Icon")
                Image(painter = painterResource(id = R.drawable.moving), contentDescription = "moving icon", modifier = Modifier.size(48.dp) )
            }
            Column {
                Row {
                    Text(text = "Balade Proches", color = Color(0xFF313131), fontSize = 16.sp, fontWeight = FontWeight.W600)
                }
                Row {
                    Text(text = "24 disponibles", color = Color(0x80313180), fontSize = 14.sp, fontWeight = FontWeight.W500)
                }
            }
        }
        Column(Modifier.padding(end = 12.dp)) {
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.chevron),
                contentDescription = "chevron",
                modifier = Modifier
                    .height(12.dp)
                    .width(6.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryCardPreview() {
    WoofAppTheme {
        CategoryCard()
    }
}