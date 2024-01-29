package org.example.useCases

import io.reactivex.rxjava3.core.Observable
import org.example.dataSource.ProductRepository
import org.example.entities.Product
import org.example.useCases.interfaces.IAddProductUseCase
import org.example.useCases.interfaces.IGetAllProductUseCase

class GetAllProductUseCase(private val productRepository: ProductRepository): IGetAllProductUseCase {
    override fun execute(filterName: String?): Observable<Product> {
        return this.productRepository.getAll(filterName)
    }
}