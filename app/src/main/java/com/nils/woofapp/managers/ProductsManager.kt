package com.nils.woofapp.managers

import androidx.lifecycle.ViewModel
import com.nils.woofapp.models.Author
import com.nils.woofapp.models.Place
import com.nils.woofapp.models.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

object ProductsManager: ViewModel() {
    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products = _products.asStateFlow()

    fun getProducts() {
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