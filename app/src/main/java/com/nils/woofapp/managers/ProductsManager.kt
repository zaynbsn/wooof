package com.nils.woofapp.managers

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.nils.woofapp.models.Author
import com.nils.woofapp.models.Place
import com.nils.woofapp.models.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

object ProductsManager: ViewModel() {
    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products = _products.asStateFlow()


    fun getProductAsync() {
        val db = Firebase.firestore

        viewModelScope.launch {
            try {
                val result = db.collection("products").get().await()

                val productList = result.documents.map { document ->
                    document.toObject(Product::class.java) ?: throw Exception("Unable to parse product")
                }

                _products.value = productList
            } catch (e: Exception) {
                // Gérer les erreurs ici
                Log.e("ProductsManager", "Error getting products", e)
            }
        }
    }
    fun getProducts() {
        val db = Firebase.firestore
        db.collection("products")
            .get()
            .addOnSuccessListener { result ->
                val productList = mutableListOf<Product>()

                for (document in result) {
                    val title = document.getString("title") ?: ""
                    val description = document.getString("description") ?: ""
                    val price = document.getDouble("price") ?: 0.0
                    val date = document.getString("date") ?: ""
                    val placeData = document.get("place") as? Map<*, *>
                    val place = if (placeData != null) {
                        Place(
                            latitude = placeData["latitude"] as? Double ?: 0.0,
                            longitude = placeData["longitude"] as? Double ?: 0.0,
                            address = placeData["address"] as? String ?: ""
                        )
                    } else {
                        Place(0.0, 0.0, "")
                    }

                    val authorData = document.get("author") as? Map<*, *>
                    val author = if (authorData != null) {
                        Author(
                            firstName = authorData["firstName"] as? String ?: "",
                            lastName = authorData["lastName"] as? String ?: "",
                            note = authorData["note"] as? Double ?: 0.0,
                            profilePictureUrl = authorData["profilePictureUrl"] as? String ?: "",
                            isCertified = authorData["isCertified"] as? Boolean ?: false
                        )
                    } else {
                        Author("", "", 0.0, "", false)
                    }

                    val isFavorite = document.getBoolean("isFavorite") ?: false
                    val imageUrl = document.getString("imageUrl") ?: ""

                    val product = Product(
                        title = title,
                        description = description,
                        price = price,
                        date = date,
                        place = place,
                        author = author,
                        isFavorite = isFavorite,
                        imageUrl = imageUrl
                    )

                    productList.add(product)
                }

                // Update the state with the list of products
                _products.value = productList
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }
    }

    fun getProductsTest() {
        // TODO : get product from firebase
        // _products = retourDeFirebase
        _products.value =
            listOf(
                Product(
                    "title",
                    "description",
                    50.0,
                    "20/09/2023",
                    Place(1.111, 0.2222, "paris"),
                    Author("Jack", "Sparrow", 4.8, "", true),
                    true,
                    "imageUrl"
                )
            )
    }


}