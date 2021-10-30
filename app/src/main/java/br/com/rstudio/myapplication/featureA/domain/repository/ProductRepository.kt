package br.com.rstudio.myapplication.featureA.domain.repository

import br.com.rstudio.myapplication.featureA.domain.model.ProductDetailsModel
import br.com.rstudio.myapplication.featureA.domain.model.ProductsModel

interface ProductRepository {

    suspend fun loadProducts(): ProductsModel

    suspend fun loadProductDetails(id: String): ProductDetailsModel
}