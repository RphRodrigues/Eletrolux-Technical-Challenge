package br.com.rstudio.myapplication.featureb.data.model

import com.squareup.moshi.Json

data class UserDTO(
    @Json(name = "id") val id: Int,
    @Json(name = "login") val login: String,
    @Json(name = "avatar_url") val avatarUrl: String
)