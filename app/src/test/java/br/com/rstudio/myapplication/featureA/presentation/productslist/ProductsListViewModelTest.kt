package br.com.rstudio.myapplication.featureA.presentation.productslist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import br.com.rstudio.myapplication.featureA.domain.model.ProductDetailsModel
import br.com.rstudio.myapplication.featureA.domain.model.ProductItemModel
import br.com.rstudio.myapplication.featureA.domain.model.ProductsModel
import br.com.rstudio.myapplication.featureA.domain.usecase.LoadProductDetailsUseCase
import br.com.rstudio.myapplication.featureA.domain.usecase.LoadProductsUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class ProductsListViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()
    private val testDispatcher = TestCoroutineDispatcher()

    private val loadProductsUseCase: LoadProductsUseCase = mockk(relaxed = true)
    private val loadProductDetailsUseCase: LoadProductDetailsUseCase = mockk(relaxed = true)

    private val model = ProductsListHelper.makeProductsList()
    private val productsObserver = mockk<Observer<ProductItemModel>>(relaxed = true)

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun `when view model load products then it should call the use case`() {
        val viewModel = instantiateViewModel()

        coEvery { loadProductsUseCase.invoke() } returns model

        viewModel.loadProducts()

        coVerify {
            loadProductsUseCase.invoke()
            productsObserver.onChanged(any())
        }
    }

    private fun instantiateViewModel(): ProductsListViewModel {
        val viewModel = ProductsListViewModel(loadProductsUseCase, loadProductDetailsUseCase)
        viewModel.products.observeForever(productsObserver)
        return viewModel
    }
}
