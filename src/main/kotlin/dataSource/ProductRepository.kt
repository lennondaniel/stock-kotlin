package org.example.dataSource

import io.reactivex.rxjava3.core.Observable
import org.example.entities.Product
import org.example.dataSource.interfaces.IProductDataSource
import java.util.*


class ProductRepository(private val productDataSource: IProductDataSource): IProductRepository {
    private lateinit var uuid: String

    override fun create(name: String): Product {
        this.uuid = UUID.randomUUID().toString()
        val product = Product(uuid, name)
        this.productDataSource.create(product)
        return product;
    }

    override fun getAll(filterName: String?): Observable<Product> {
        val products =  this.productDataSource.getAll(filterName)
        return this.getObservableFromList(products)
    }

    override fun show(id: String): Any {
        return try {
            this.productDataSource.show(id)
        } catch (e: Exception) {
            "Produto não encontrado"
        }
    }

    override fun update(id: String, name: String): Any {
       return try {
           this.productDataSource.update(id, name)
        } catch (e: Exception) {
            "Erro ao atualizar produto"
        }
    }

    override fun delete(id: String) {
        return this.productDataSource.delete(id)
    }

    private fun getObservableFromList(list: List<Product>): Observable<Product> {
        return Observable.create<Product> { emitter ->
            list.forEach { product ->
                emitter.onNext(product)
            }
            emitter.onComplete()
        }
    }

}