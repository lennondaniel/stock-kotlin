package org.example.controllers

import io.reactivex.rxjava3.core.Observable
import org.example.entities.Product

interface IProductController {
    fun addProduct(name: String): Product
    fun getAllProduct(filterName: String? = null): Observable<Product>
    fun showProduct(id: String): Any
    fun updateProduct(id: String, name: String): Any
    fun deleteProduct(id: String)
}