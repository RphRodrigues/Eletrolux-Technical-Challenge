package br.com.rstudio.myapplication.featureb.data.datasource

import br.com.rstudio.myapplication.featureb.domain.model.UserDetailsModel
import br.com.rstudio.myapplication.featureb.domain.model.UserModel

interface DataSource {
    suspend fun loadUser(): List<UserModel>
    suspend fun loadUserById(id: Int): UserDetailsModel
}