package org.example.dataSource.interfaces

import org.example.entities.Product

interface IProductDataSource {
    fun create(product: Product)
    fun getAll(filterName: String? = null): List<Product>
    fun show(id: String): Product
    fun update(id: String, name: String): Product
    fun delete(id: String)
}