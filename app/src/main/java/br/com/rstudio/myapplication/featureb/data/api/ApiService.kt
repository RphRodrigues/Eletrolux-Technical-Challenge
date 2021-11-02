package br.com.rstudio.myapplication.featureb.data.api

import br.com.rstudio.myapplication.featureb.data.model.UserDTO
import br.com.rstudio.myapplication.featureb.data.model.UserDetailsDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("users")
    suspend fun loadUsers(): Response<List<UserDTO>>

    @GET("users/{id}")
    suspend fun loadUserById(
        @Path("id") id: Int
    ): Response<UserDetailsDTO>

}