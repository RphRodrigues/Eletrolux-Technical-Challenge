package br.com.rstudio.myapplication.featureA.data.datasource

import br.com.rstudio.myapplication.featureA.domain.model.ProductDetailsModel
import br.com.rstudio.myapplication.featureA.domain.model.ProductItemModel
import br.com.rstudio.myapplication.featureA.domain.model.ProductsModel

class LocalDataSourceImpl : DataSource {

    override suspend fun saveProducts(products: ProductsModel) {
//        TODO("Not yet implemented")
    }

    override suspend fun loadProducts(): ProductsModel {
        return ProductsModel(
            data = listOf(
                ProductItemModel("1", "name 1"),
                ProductItemModel("2", "name 2")
            )
        )
    }

    override suspend fun loadProductDetails(id: String): ProductDetailsModel {
        TODO("Not yet implemented")
    }
}