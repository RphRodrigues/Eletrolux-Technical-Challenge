package br.com.rstudio.myapplication.feature.data.api

import br.com.rstudio.myapplication.feature.data.model.UserDTO
import br.com.rstudio.myapplication.feature.data.model.UserDetailsDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApiService {

    @GET("users")
    suspend fun loadUsers(): Response<List<UserDTO>>

    @GET("users/{id}")
    suspend fun loadUserById(
        @Path("id") id: Int
    ): Response<UserDetailsDTO>
}