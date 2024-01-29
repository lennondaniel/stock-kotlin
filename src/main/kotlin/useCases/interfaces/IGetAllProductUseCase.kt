package org.example.useCases.interfaces

import io.reactivex.rxjava3.core.Observable
import org.example.entities.Product

interface IGetAllProductUseCase {
    fun execute(filterName: String?): Observable<Product>
}