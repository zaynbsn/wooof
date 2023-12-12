package com.nils.woofapp.modules.login

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.nils.woofapp.MainScreen
import com.nils.woofapp.NavigationItem
import com.nils.woofapp.montserratFont
import com.nils.woofapp.ui.components.MainButton
import com.nils.woofapp.ui.components.login.SignInWith
import com.nils.woofapp.ui.theme.WoofAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(navController: NavHostController) {

    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val username = remember { mutableStateOf(TextFieldValue()) }
        val password = remember { mutableStateOf(TextFieldValue()) }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Connexion",
            style = TextStyle(
                fontSize = 26.81.sp,
                fontFamily = montserratFont,
                fontWeight = FontWeight(700),
                color = Color(0xFFA58EFF),
                textAlign = TextAlign.Center,
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Te re-voilà ! Plein d’animaux ont besoin de toi !",
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = montserratFont,
                fontWeight = FontWeight(600),
                color = Color(0xFF000000),
                textAlign = TextAlign.Center,
            ),
            modifier = Modifier.width(200.dp)
        )

        Spacer(modifier = Modifier.height(48.dp))

        TextField(
            label = { Text(text = "Email") },
            value = username.value,
            onValueChange = { username.value = it })

        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            label = { Text(text = "Mot de passe") },
            value = password.value,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            onValueChange = { password.value = it })

        Spacer(modifier = Modifier.height(26.dp))

        ClickableText(
            text = AnnotatedString("Mot de passe oublié ?"),
            onClick = { },
            style = TextStyle(
                fontSize = 12.53.sp,
                fontFamily = montserratFont,
                fontWeight = FontWeight(600),
                color = Color(0xFFA58EFF),

                textAlign = TextAlign.End,
            )
        )

        Spacer(modifier = Modifier.height(26.dp))

        Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
            Column(Modifier
                .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                MainButton(label = "Me connecter"){
                    signIn {
                        navController.navigate(NavigationItem.Feed.route)
                    }

                }
            }
        }

        Spacer(modifier = Modifier.height(26.dp))

        ClickableText(
            text = AnnotatedString("Créer un compte"),
            onClick = { navController.navigate(NavigationItem.SignUp.route) },
            style = TextStyle(
                fontSize = 12.53.sp,
                fontFamily = montserratFont,
                fontWeight = FontWeight(600),
                color = Color(0xFF494949),

                textAlign = TextAlign.Center,
            )
        )

        Spacer(modifier = Modifier.height(100.dp))
        Box {
            Text(
                text = "Ou continue avec",
                style = TextStyle(
                    fontSize = 12.72.sp,
                    fontFamily = montserratFont,
                    fontWeight = FontWeight(600),
                    color = Color(0xFFA58EFF),
                    textAlign = TextAlign.Center,
                ),
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }

        Spacer(modifier = Modifier.height(18.dp))
        SignInWith()
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    val navController = rememberNavController()
    WoofAppTheme {
        MainScreen(navController = navController)
    }
}


fun signIn(email: String = "123@yopmail.com", password: String = "123412DD34!", onSuccess: () -> Unit) {
    val auth = Firebase.auth
    auth.signInWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                Log.d(TAG, "signInWithEmail:success")
                val user = auth.currentUser
                onSuccess.invoke()

            } else {
                // If sign in fails, display a message to the user.
                Log.w(TAG, "signInWithEmail:failure", task.exception)

            }
        }
}