package br.com.rstudio.myapplication.featureA.data.model

import com.squareup.moshi.Json

data class ProductDTO(
    @field:Json(name = "data") val data: List<ProductItemDTO>
)

data class ProductItemDTO(
    @field:Json(name = "id") val id: String,
    @field:Json(name = "name") val name: String
)
