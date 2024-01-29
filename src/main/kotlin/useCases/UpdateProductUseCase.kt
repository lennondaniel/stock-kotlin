package org.example.useCases

import org.example.dataSource.ProductRepository
import org.example.useCases.interfaces.IUpdateProductUseCase

class UpdateProductUseCase(private val productRepository: ProductRepository): IUpdateProductUseCase {
    override fun execute(id: String, name: String): Any {
        return this.productRepository.update(id, name)
    }
}