package com.nils.woofapp.managers

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.nils.woofapp.models.Author
import com.nils.woofapp.models.Place
import com.nils.woofapp.models.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

object ProductsManager: ViewModel() {
    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products = _products.asStateFlow()

    private val _selectedProduct = MutableStateFlow<Product?>(null)
    val selectedProduct = _selectedProduct.asStateFlow()

    fun updateSelectedProduct(product: Product) {
        _selectedProduct.value = product
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
                            certified = authorData["certified"] as? Boolean ?: false
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




}