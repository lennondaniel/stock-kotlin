package org.example.dataSource

import io.reactivex.rxjava3.core.Observable
import org.example.entities.Product

interface IProductRepository {
    fun create(name: String): Product
    fun getAll(filterName: String? = null): Observable<Product>
    fun show(id: String): Any
    fun update(id: String, name: String): Any
    fun delete(id: String)
}