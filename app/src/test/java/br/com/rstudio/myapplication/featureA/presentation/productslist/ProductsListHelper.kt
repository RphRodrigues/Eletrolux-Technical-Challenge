package br.com.rstudio.myapplication.featureA.presentation.productslist

import br.com.rstudio.myapplication.featureA.domain.model.ProductItemModel
import br.com.rstudio.myapplication.featureA.domain.model.ProductsModel

object ProductsListHelper {

    fun makeProductsList() = ProductsModel(
        data = makeProductItemModel()
    )

    private fun makeProductItemModel() = listOf(
        ProductItemModel(id = "1", name = "name 1"),
        ProductItemModel(id = "2", name = "name 2"),
        ProductItemModel(id = "3", name = "name 3")
    )
}