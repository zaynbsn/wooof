package com.nils.woofapp.ui.components.feed

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nils.woofapp.R
import com.nils.woofapp.montserratFont
import com.nils.woofapp.ui.theme.WoofAppTheme
import com.nils.woofapp.ui.theme.WoofBlack
import com.nils.woofapp.ui.theme.WoofPurple

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {
    Row(
        Modifier
        .padding(horizontal = 24.dp)
        .padding(top = 16.dp)
        .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    )
    {
        var text by remember { mutableStateOf(TextFieldValue("")) }
        Column {
            TextField(modifier = Modifier
                .height(48.dp)
                .background(Color(0xFFFFFFFF), shape = RoundedCornerShape(12.dp)),
                leadingIcon = { Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.search),
                    contentDescription = "search icon",
                ) },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color(0xFFFFFFFF),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent),
                value = text,
                onValueChange = { newText ->
                    text = newText
                },
                placeholder = { Text(text = "Chercher", color = WoofBlack, fontSize = 14.sp, fontFamily = montserratFont) },
                shape = RoundedCornerShape(16.dp),
            )
        }
        Column {
            Box(
                Modifier
                .size(48.dp)
                .background(WoofPurple, shape = RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.filter),
                    contentDescription = "filter icon"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    WoofAppTheme {
        SearchBar()
    }
}