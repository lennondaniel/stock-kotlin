package org.example.dataSource.memory

import org.example.entities.Product
import org.example.dataSource.interfaces.IProductDataSource

class ProductDataSourceMemory: IProductDataSource {
    private var products = mutableListOf<Product>()

    override fun create(product: Product) {
        this.products.add(product)
    }

    override fun getAll(filterName: String?): List<Product> {
        if(filterName !== null) {
            return this.products.filter {
                it.name.lowercase().contains(filterName.lowercase())
            }
        }
        return this.products
    }

    override fun show(id: String): Product {
        this.products.filter {
            it.id === id
        }.map {
            return Product(it.id, it.name)
        }
        throw Exception("Product not found!")
    }

    override fun update(id: String, name: String): Product {
        var product = this.products.find{
            it.id === id
        }

        if (product !== null) {
            product.name = name
            return product
        }

        throw Exception("Product not found!")

    }

    override fun delete(id: String) {
        this.products.removeIf{
            it.id === id
        }
    }
}