package br.com.rstudio.myapplication.featureA.data.repository

import br.com.rstudio.myapplication.featureA.data.datasource.DataSource
import br.com.rstudio.myapplication.featureA.domain.model.ProductDetailsModel
import br.com.rstudio.myapplication.featureA.domain.repository.ProductRepository
import br.com.rstudio.myapplication.featureA.domain.model.ProductsModel

class ProductRepositoryImpl(
    private val remoteDataSource: DataSource,
    private val localDataSource: DataSource
) : ProductRepository {

    override suspend fun loadProducts(): ProductsModel {
        return try {
            remoteDataSource.loadProducts().also {
                localDataSource.saveProducts(it)
            }
        } catch (e: Exception) {
            localDataSource.loadProducts()
        }
    }

    override suspend fun loadProductDetails(id: String): ProductDetailsModel {
        return remoteDataSource.loadProductDetails(id)
    }
}