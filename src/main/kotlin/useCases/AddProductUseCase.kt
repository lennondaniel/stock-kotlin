package org.example.useCases

import org.example.dataSource.ProductRepository
import org.example.entities.Product
import org.example.useCases.interfaces.IAddProductUseCase

class AddProductUseCase(private val productRepository: ProductRepository): IAddProductUseCase {
    override fun execute(name: String): Product {
       return this.productRepository.create(name)
    }
}