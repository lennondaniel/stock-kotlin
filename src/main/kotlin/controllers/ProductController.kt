package org.example.controllers

import io.reactivex.rxjava3.core.Observable
import org.example.entities.Product
import org.example.dataSource.ProductRepository
import org.example.useCases.*

class ProductController(private val productRepository: ProductRepository): IProductController {
    override fun addProduct(name: String): Product {
        return AddProductUseCase(this.productRepository).execute(name)
    }

    override fun getAllProduct(filterName: String?): Observable<Product> {
        return GetAllProductUseCase(this.productRepository).execute(filterName)
    }

    override fun showProduct(id: String): Any {
       return ShowProductUseCase(this.productRepository).execute(id)
    }

    override fun updateProduct(id: String, name: String): Any {
       return UpdateProductUseCase(this.productRepository).execute(id, name)
    }

    override fun deleteProduct(id: String) {
        DeleteProductUseCase(this.productRepository).execute(id)
    }
}