package org.example.useCases

import org.example.dataSource.ProductRepository
import org.example.useCases.interfaces.IAddProductUseCase
import org.example.useCases.interfaces.IDeleteProductUseCase
import org.example.useCases.interfaces.IGetAllProductUseCase
import org.example.useCases.interfaces.IShowProductUseCase

class DeleteProductUseCase(private val productRepository: ProductRepository): IDeleteProductUseCase {
    override fun execute(id: String) {
        this.productRepository.delete(id)
    }
}