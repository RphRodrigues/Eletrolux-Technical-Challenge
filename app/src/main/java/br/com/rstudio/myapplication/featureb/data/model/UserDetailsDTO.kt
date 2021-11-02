package br.com.rstudio.myapplication.featureb.data.model

import com.squareup.moshi.Json

data class UserDetailsDTO(
    @Json(name = "login") val login: String,
    @Json(name = "name") val name: String?,
    @Json(name = "avatar_url") val avatarUrl: String,
    @Json(name = "bio") val bio: String?
)