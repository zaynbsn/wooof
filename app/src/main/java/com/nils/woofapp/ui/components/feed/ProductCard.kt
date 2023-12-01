package com.nils.woofapp.ui.components.feed

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nils.woofapp.R

@Composable
fun ProductCard() {
    Column(
        Modifier
            .width(264.dp)
            .height(326.dp)
            .background(color = Color.White, shape = RoundedCornerShape(28.dp))
    ) {
        Row(
            Modifier
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
        ) {
            Box(modifier = Modifier
                .width(230.dp)
                .height(230.dp),) {
                Image(modifier = Modifier
                    .fillMaxSize(),
                    painter = painterResource(id = R.drawable.img_dog_card),
                    contentDescription = "dog card")
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.SpaceBetween)
                {
                    Row(
                        Modifier
                        .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween)
                    {
                        Text(text = "Pour le 26.09", color = Color(0xFFFFFFFF), fontSize = 13.sp)
                        Icon(imageVector = Icons.Rounded.FavoriteBorder, contentDescription = null, tint = Color(0xFFFFFFFF), modifier = Modifier
                            .height(18.dp)
                            .width(20.dp))
                    }
                    Row(
                        Modifier
                        .background(
                            color = Color(255, 255, 255, 90),
                            shape = RoundedCornerShape(30.dp)
                        ),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Box(
                            Modifier
                            .padding(horizontal = 8.dp, vertical = 4.dp)

                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                Image(painter = painterResource(id = R.drawable.profile_picture), contentDescription = "profile picture", modifier = Modifier.size(20.dp) )
                                Text(text = "Dominique D.", color = Color(0xFFFFFFFF), fontSize = 13.sp)
                                Image(imageVector = ImageVector.vectorResource(id = R.drawable.verify), contentDescription = "verify")
                            }
                        }
                    }
                }
            }
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 12.dp, start = 16.dp, end = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "Balader et nourir mon petit Roger",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W600,
                    modifier = Modifier.weight(1f)
                )
            }
            Column {
                Image(imageVector = ImageVector.vectorResource(id = R.drawable.verify), contentDescription = "icon chat")
            }
        }
    }
}