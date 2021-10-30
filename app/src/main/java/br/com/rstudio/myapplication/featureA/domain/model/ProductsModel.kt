package br.com.rstudio.myapplication.featureA.domain.model

data class ProductsModel(
    val data: List<ProductItemModel>
)

data class ProductItemModel(
    val id: String,
    val name: String
)
