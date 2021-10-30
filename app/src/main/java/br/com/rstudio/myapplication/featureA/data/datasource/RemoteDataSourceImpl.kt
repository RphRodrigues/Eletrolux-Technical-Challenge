package br.com.rstudio.myapplication.featureA.data.datasource

import br.com.rstudio.myapplication.featureA.data.api.ApiService
import br.com.rstudio.myapplication.featureA.data.model.Mapper
import br.com.rstudio.myapplication.featureA.domain.model.ProductDetailsModel
import br.com.rstudio.myapplication.featureA.domain.model.ProductsModel
import retrofit2.Response

class RemoteDataSourceImpl(
    private val api: ApiService,
    private val mapper: Mapper
) : DataSource {

    override suspend fun saveProducts(products: ProductsModel) = Unit

    override suspend fun loadProducts(): ProductsModel {
        val response = api.loadProducts()

        return if (response.isSuccessful) {
            response.body()?.let { mapper.transform(it) } ?: throw Exception()
        } else {
            throw Exception()
        }
    }

    override suspend fun loadProductDetails(id: String): ProductDetailsModel {
        val response = api.loadProductDetails(id)

        return if (response.isSuccessful) {
            response.body()?.let { mapper.transform(it) } ?: throw Exception()
        } else {
            throw Exception()
        }
    }

    private fun <T> handleRequest(response: Response<T>, transform: (T) -> Unit) {
        if (response.isSuccessful) {
            response.body()?.let { mapper.transform(it) } ?: throw Exception()
        } else {
            throw Exception()
        }
    }
}