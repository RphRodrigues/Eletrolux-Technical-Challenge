package br.com.rstudio.myapplication.feature.domain.repository

import br.com.rstudio.myapplication.feature.domain.model.UserDetailsModel
import br.com.rstudio.myapplication.feature.domain.model.UserModel

interface UserRepository {
    suspend fun loadUser(): List<UserModel>
    suspend fun loadUserById(id: Int): UserDetailsModel
}