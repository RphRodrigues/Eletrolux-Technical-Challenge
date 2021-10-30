package br.com.rstudio.myapplication.featureA.data.model

import com.squareup.moshi.Json

data class ProductDetailsDTO(
    @field:Json(name = "id") val id: String,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "type") val type: String
)