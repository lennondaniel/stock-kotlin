package org.example.useCases

import org.example.dataSource.ProductRepository
import org.example.entities.Product
import org.example.useCases.interfaces.IAddProductUseCase
import org.example.useCases.interfaces.IGetAllProductUseCase
import org.example.useCases.interfaces.IShowProductUseCase

class ShowProductUseCase(private val productRepository: ProductRepository): IShowProductUseCase {
    override fun execute(id: String): Any {
        return this.productRepository.show(id)
    }
}