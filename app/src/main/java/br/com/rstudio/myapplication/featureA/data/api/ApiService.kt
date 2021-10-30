package br.com.rstudio.myapplication.featureA.data.api

import br.com.rstudio.myapplication.featureA.data.model.ProductDTO
import br.com.rstudio.myapplication.featureA.data.model.ProductDetailsDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    @GET("api/products/")
    suspend fun loadProducts(): Response<ProductDTO>

    @GET("api/products/{id}")
    suspend fun loadProductDetails(
        @Path("id") id: String
    ): Response<ProductDetailsDTO>
}