package org.example
import org.example.controllers.ProductController
import org.example.dataSource.ProductRepository
import org.example.dataSource.memory.ProductDataSourceMemory


fun main() {

    val productDataSource = ProductDataSourceMemory()
    val productRepository = ProductRepository(productDataSource)
    val productController = ProductController(productRepository)
    val productCarrinho = productController.addProduct("Carrinho")
    val productBoneca = productController.addProduct("Boneca")
    productController.addProduct("Bola")

    productController.getAllProduct(null).subscribe{ product ->
        println(product)
    }
//    println(productController.getAllProduct("Carrinho"))
//
//    println(productController.showProduct(productCarrinho.id))
//
//    productController.updateProduct(productCarrinho.id, "CarrinhoAtualizado")
//
//    println(productController.showProduct("be65d6e2-5987-47d7-ab8d-9e097fdb0904"))
//
//    productController.deleteProduct(productBoneca.id)
//
//    println(productController.getAllProduct(null))

}