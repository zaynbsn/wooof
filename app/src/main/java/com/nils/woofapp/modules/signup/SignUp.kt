package com.nils.woofapp.modules.signup

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
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
import com.google.firebase.firestore.firestore
import com.nils.woofapp.NavigationItem
import com.nils.woofapp.models.Author
import com.nils.woofapp.models.Place
import com.nils.woofapp.models.Product
import com.nils.woofapp.montserratFont
import com.nils.woofapp.ui.components.CustomTopAppBar
import com.nils.woofapp.ui.components.MainButton
import com.nils.woofapp.ui.components.login.SignInWith
import com.nils.woofapp.ui.theme.WoofAppTheme

@Composable
fun SignUp(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()) {
        ScaffoldWithTopBar(navController)
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldWithTopBar(navController: NavHostController) {
    Scaffold(
        topBar = {
            CustomTopAppBar(navController, "", true)
        }, content = {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                val email = remember { mutableStateOf(TextFieldValue()) }
                val password = remember { mutableStateOf(TextFieldValue()) }
                val passwordConfirmation = remember { mutableStateOf(TextFieldValue()) }

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = "Inscription",
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
                    text = "Crée un compte pour pouvoir explorer les offres de garde d'animaux",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = montserratFont,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF000000),
                        textAlign = TextAlign.Center,
                    ),
                    modifier = Modifier.width(290.dp)
                )

                Spacer(modifier = Modifier.height(48.dp))

                TextField(
                    label = { Text(text = "Email") },
                    value = email.value,
                    onValueChange = { email.value = it })

                Spacer(modifier = Modifier.height(20.dp))
                TextField(
                    label = { Text(text = "Mot de passe") },
                    value = password.value,
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    onValueChange = { password.value = it })

                Spacer(modifier = Modifier.height(20.dp))
                TextField(
                    label = { Text(text = "Confirmation du mot de passe") },
                    value = passwordConfirmation.value,
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    onValueChange = { passwordConfirmation.value = it })

                Spacer(modifier = Modifier.height(26.dp))

                Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                    Column(Modifier
                        .fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        MainButton(label = "M'inscrire"){
                            if (password.value.text == passwordConfirmation.value.text) {
                                signUpUser(email = email.value.text, password = password.value.text) {
                                    navController.navigate(NavigationItem.Feed.route)
                                }
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(26.dp))

                ClickableText(
                    text = AnnotatedString("j'ai déjà un compte"),
                    onClick = { navController.navigate(NavigationItem.Login.route) },
                    style = TextStyle(
                        fontSize = 12.53.sp,
                        fontFamily = montserratFont,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF494949),

                        textAlign = TextAlign.Center,
                    )
                )

                ClickableText(
                    text = AnnotatedString("Ajout produit"),
                    onClick = { getProducts() },
                    style = TextStyle(
                        fontSize = 12.53.sp,
                        fontFamily = montserratFont,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF494949),

                        textAlign = TextAlign.Center,
                    )
                )

                Spacer(modifier = Modifier.height(50.dp))
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
    )
}

@Preview(showBackground = true)
@Composable
fun SignUpPreview() {
    val navController = rememberNavController()
    WoofAppTheme {
        SignUp(navController = navController)
    }
}


fun signUpUser(email: String, password: String, onSuccess: () -> Unit) {
    val auth = Firebase.auth
    auth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                Log.d(TAG, "createUserWithEmail:success")
                addUserToFirestore(email, "john", 20, "0769802577")
                val user = auth.currentUser
                // Passer à l'ecran du feed
                onSuccess.invoke()
            } else {
                // If sign in fails, display a message to the user.
                Log.w(TAG, "createUserWithEmail:failure", task.exception)
                // afficher erreur
            }
        }
}

fun addProduct() {
    val product = Product(
        title = "Séjour VIP pour Chiens",
        description = "Offrez à votre chien un séjour VIP avec des services de luxe ! Promenades privées, repas gastronomiques et sessions de spa pour chien incluses.",
        price = 50.0,
        date = "2021-12-05",
        place = Place(
            latitude = 34.052235,
            longitude = -118.243683,
            address = "Beverly Hills, Los Angeles"
        ),
        author = Author(
            firstName = "Isabella",
            lastName = "Garcia",
            note = 5.0,
            profilePictureUrl = "https://example.com/isabellagarcia.jpg",
            certified = true
        ),
        isFavorite = false,
        imageUrl = "https://example.com/dog_vip_stay.jpg"
    )
    val db = Firebase.firestore
    db.collection("products").add(product)
}


fun getProducts() {
    val db = Firebase.firestore
    db.collection("products")
        .get()
        .addOnSuccessListener { result ->
            for (document in result) {
                Log.d(TAG, "${document.id} => ${document.data}")
            }
        }
        .addOnFailureListener { exception ->
            Log.w(TAG, "Error getting documents.", exception)
        }
}

fun getUsers() {
    val db = Firebase.firestore
    db.collection("users")
        .get()
        .addOnSuccessListener { result ->
            for (document in result) {
                Log.d(TAG, "${document.id} => ${document.data}")
            }
        }
        .addOnFailureListener { exception ->
            Log.w(TAG, "Error getting documents.", exception)
        }
}

fun addUserToFirestore(email: String, firstname: String, age: Int, phoneNumber: String) {
    val user = hashMapOf(
        "email" to email,
        "firstname" to firstname,
        "age" to age,
        "phoneNumber" to phoneNumber
    )

// Add a new document with a generated ID
    val db = Firebase.firestore
    db.collection("users")
        .add(user)
        .addOnSuccessListener { documentReference ->
            Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
        }
        .addOnFailureListener { e ->
            Log.w(TAG, "Error adding document", e)
        }
}