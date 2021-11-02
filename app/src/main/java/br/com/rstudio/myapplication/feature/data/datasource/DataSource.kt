package br.com.rstudio.myapplication.feature.data.datasource

import br.com.rstudio.myapplication.feature.domain.model.UserDetailsModel
import br.com.rstudio.myapplication.feature.domain.model.UserModel

interface DataSource {
    suspend fun loadUser(): List<UserModel>
    suspend fun loadUserById(id: Int): UserDetailsModel
}