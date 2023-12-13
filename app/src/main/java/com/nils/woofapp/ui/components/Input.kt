package com.nils.woofapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nils.woofapp.montserratFont
import com.nils.woofapp.ui.theme.WoofAppTheme
import com.nils.woofapp.ui.theme.WoofBlack

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Input(placeholder: String) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    Column(
        Modifier
        .padding(horizontal = 16.dp)
        .fillMaxWidth()
    ) {
        TextField(modifier = Modifier
            .height(48.dp)
            .fillMaxWidth()
            .background(Color(0xFFFFFFFF)),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0xFFFFFFFF)
            ),
            value = text,
            onValueChange = { newText ->
                text = newText
            },
            placeholder = { Text(text = placeholder, color = WoofBlack, fontSize = 14.sp, fontFamily = montserratFont) },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun InputPreview() {
    WoofAppTheme {
        Input("placeholder")
    }
}