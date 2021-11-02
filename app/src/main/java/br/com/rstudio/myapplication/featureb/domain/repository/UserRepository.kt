package br.com.rstudio.myapplication.featureb.domain.repository

import br.com.rstudio.myapplication.featureb.domain.model.UserDetailsModel
import br.com.rstudio.myapplication.featureb.domain.model.UserModel

interface UserRepository {
    suspend fun loadUser(): List<UserModel>
    suspend fun loadUserById(id: Int): UserDetailsModel
}