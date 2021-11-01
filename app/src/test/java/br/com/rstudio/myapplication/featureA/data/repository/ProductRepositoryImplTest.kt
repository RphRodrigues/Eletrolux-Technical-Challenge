package br.com.rstudio.myapplication.featureA.data.repository

import br.com.rstudio.myapplication.featureA.coVerifyNever
import br.com.rstudio.myapplication.featureA.data.datasource.DataSource
import br.com.rstudio.myapplication.featureA.domain.model.ProductsModel
import br.com.rstudio.myapplication.featureA.domain.repository.ProductRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.coVerifyOrder
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class ProductRepositoryImplTest {

    private val testDispatcher = TestCoroutineDispatcher()

    private lateinit var repository: ProductRepository
    private val remoteDataSource: DataSource = mockk(relaxed = true)
    private val localDataSource: DataSource = mockk(relaxed = true)

    @Before
    fun setUp() {
        repository = ProductRepositoryImpl(remoteDataSource, localDataSource)

        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun `when load products is called then it should call remote data source`() {
        val model = ProductsModel(data = listOf())
        coEvery { remoteDataSource.loadProducts() } returns model

        runBlockingTest {
            repository.loadProducts()
        }

        coVerify {
            remoteDataSource.loadProducts()
            localDataSource.saveProducts(model)
        }

        coVerifyNever { localDataSource.loadProducts() }
    }

    @Test
    fun `when load products throw a exception then it should call local data source`() {
        coEvery { remoteDataSource.loadProducts() } throws Exception()
        coEvery { localDataSource.loadProducts() } returns ProductsModel(data = listOf())

        runBlockingTest {
            repository.loadProducts()
        }

        coVerifyOrder {
            remoteDataSource.loadProducts()
            localDataSource.loadProducts()
        }
    }
}