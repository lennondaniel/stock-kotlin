import org.example.controllers.ProductController
import org.example.dataSource.ProductRepository
import org.example.dataSource.memory.ProductDataSourceMemory
import org.example.entities.Product
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.test.assertEquals

class ProductTest {

    @Test
    fun `Should create new entity product`() {
        val uuid = UUID.randomUUID().toString()
        val product = Product(uuid, "Controle")

        assertEquals(uuid, product.id)
        assertEquals("Controle", product.name)
    }

    @Test
    fun `Should create new product`() {
        val productDataSource = ProductDataSourceMemory()
        val productRepository = ProductRepository(productDataSource)
        val productController = ProductController(productRepository)

        val product = productController.addProduct("Pilha")

        assertEquals("Pilha", product.name)

    }

    @Test
    fun `Should get all product`() {
        val productDataSource = ProductDataSourceMemory()
        val productRepository = ProductRepository(productDataSource)
        val productController = ProductController(productRepository)

        val productAdd = productController.addProduct("Pilha")
        productController.getAllProduct().subscribe { product ->
            assertEquals(productAdd, product)
        }
    }

    @Test
    fun `Should show product`() {
        val productDataSource = ProductDataSourceMemory()
        val productRepository = ProductRepository(productDataSource)
        val productController = ProductController(productRepository)

        val product = productController.addProduct("Pilha")
        val productShow = productController.showProduct(product.id)

        assertEquals(product, productShow)

    }

    @Test
    fun `Should update product`() {
        val productDataSource = ProductDataSourceMemory()
        val productRepository = ProductRepository(productDataSource)
        val productController = ProductController(productRepository)

        val product = productController.addProduct("Pilha")
        val productUpdated = productController.updateProduct(product.id, "Pilha atualizada")
        val productShow = productController.showProduct(product.id)

        assertEquals(productUpdated, productShow)

    }

    @Test
    fun `Should delete product`() {
        val productDataSource = ProductDataSourceMemory()
        val productRepository = ProductRepository(productDataSource)
        val productController = ProductController(productRepository)

        val product = productController.addProduct("Pilha")
        productController.deleteProduct(product.id)
        val productShow = productController.showProduct(product.id)

        assertEquals(productShow, "Produto não encontrado")

    }
}
