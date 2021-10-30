package br.com.rstudio.myapplication.featureA.presentation.productslist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.rstudio.myapplication.featureA.domain.model.ProductDetailsModel
import br.com.rstudio.myapplication.featureA.domain.model.ProductItemModel
import br.com.rstudio.myapplication.featureA.domain.usecase.LoadProductDetailsUseCase
import br.com.rstudio.myapplication.featureA.domain.usecase.LoadProductsUseCase
import kotlinx.coroutines.launch

class ProductsListViewModel(
    private val loadProductsUseCase: LoadProductsUseCase,
    private val loadProductDetailsUseCase: LoadProductDetailsUseCase,
) : ViewModel() {

    private var _products = MutableLiveData<ProductItemModel>()
    val products = _products

    private var _productDetails = MutableLiveData<ProductDetailsModel>()
    val productDetails = _productDetails

    fun loadProducts() = viewModelScope.launch {
        loadProductsUseCase().data.forEach {
            _products.value = it
        }
    }

    fun loadProductDetails(id: String) = viewModelScope.launch {
        val details = loadProductDetailsUseCase(id)
        productDetails.value = details
    }
}