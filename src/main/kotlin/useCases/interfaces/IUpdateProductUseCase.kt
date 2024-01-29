package org.example.useCases.interfaces

interface IUpdateProductUseCase{
    fun execute(id: String, name: String): Any
}