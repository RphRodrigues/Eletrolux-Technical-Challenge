package br.com.rstudio.myapplication.featureA.data.datasource

import br.com.rstudio.myapplication.featureA.domain.model.ProductDetailsModel
import br.com.rstudio.myapplication.featureA.domain.model.ProductsModel

interface DataSource {

    suspend fun saveProducts(products: ProductsModel)

    suspend fun loadProducts(): ProductsModel

    suspend fun loadProductDetails(id: String): ProductDetailsModel
}