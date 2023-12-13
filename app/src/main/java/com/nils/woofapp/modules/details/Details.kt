package com.nils.woofapp.modules.details

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.nils.woofapp.R
import com.nils.woofapp.managers.ProductsManager
import com.nils.woofapp.modules.feed.Feed
import com.nils.woofapp.montserratFont
import com.nils.woofapp.ui.theme.WoofAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Details(navController: NavHostController) {

    val productsManager = remember { ProductsManager }
    val product by productsManager.selectedProduct.collectAsState()

    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp)),
                painter = rememberAsyncImagePainter(product?.imageUrl),
                contentDescription = "image",
                contentScale = ContentScale.Crop,
            )
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            )
            {
                Row(
                    Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                )
                {
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.icon_back_white),
                        contentDescription = "back icon",
                        modifier = Modifier
                            .height(18.dp)
                            .width(20.dp)
                            .clickable { navController.navigateUp() }
                    )
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.icon_share),
                        contentDescription = "share icon",
                        modifier = Modifier
                            .height(20.dp)
                            .width(20.dp)
                    )
                }
                Row(Modifier
                    .background(
                        color = Color(40, 40, 40, 90),
                        shape = RoundedCornerShape(30.dp)
                    ),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Box(
                        Modifier
                            .padding(horizontal = 8.dp, vertical = 4.dp)

                    ) {
                        Row(modifier = Modifier
                            .padding(end = 4.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)

                        ) {
                            Image(
                                modifier = Modifier
                                    .size(32.dp),
                                painter = rememberAsyncImagePainter(product?.author?.profilePictureUrl),
                                contentDescription = "profile picture"
                            )
                            Column() {
                                product?.author?.let { it1 ->
                                    Row {
                                        Text(
                                            text = it1.firstName,
                                            color = Color(0xFFFFFFFF),
                                            fontSize = 13.sp,
                                            fontFamily = montserratFont
                                        )
                                        Spacer(modifier = Modifier.width(8.dp))
                                        if (product?.author?.certified == true) {
                                            Image(
                                                imageVector = ImageVector.vectorResource(id = R.drawable.verify),
                                                contentDescription = "verify"
                                            )
                                        }
                                    }
                                    Row(
                                        horizontalArrangement = Arrangement.Center,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Image(
                                            imageVector = ImageVector.vectorResource(id = R.drawable.icon_star),
                                            contentDescription = "star icon",
                                            modifier = Modifier
                                                .height(12.dp)
                                                .width(12.dp)
                                        )
                                        Spacer(modifier = Modifier.width(4.dp))
                                        Text(
                                            text = it1.note.toString(),
                                            color = Color(0xFFFFFFFF),
                                            fontSize = 13.sp,
                                            fontFamily = montserratFont
                                        )
                                        Spacer(modifier = Modifier.width(4.dp))
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Column(Modifier
            .padding(horizontal = 24.dp)
        ) {
            product?.let {
                Row(Modifier.fillMaxWidth()) {
                    Text(
                        text = it.title,
                        style = TextStyle(
                            fontSize = 26.sp,
                            fontFamily = montserratFont,
                            fontWeight = FontWeight(800),
                            color = Color(0xFF313131),
                        )
                    )
                }

                Row(Modifier.fillMaxWidth()) {
                    Text(
                        text = it.description,
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 22.sp,
                            fontFamily = montserratFont,
                            fontWeight = FontWeight(500),
                            color = Color(0xFF313131),
                            letterSpacing = 0.16.sp,
                        )
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailsPreview() {
    val navController = rememberNavController()
    WoofAppTheme {
        Details(navController = navController)
    }
}

