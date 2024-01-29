package org.example.useCases.interfaces

import org.example.entities.Product

interface IAddProductUseCase {
    fun execute(name: String): Product
}