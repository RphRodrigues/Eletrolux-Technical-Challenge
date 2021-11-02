package br.com.rstudio.myapplication.feature.data.repository

import br.com.rstudio.myapplication.feature.data.datasource.DataSource
import br.com.rstudio.myapplication.feature.domain.model.UserDetailsModel
import br.com.rstudio.myapplication.feature.domain.model.UserModel
import br.com.rstudio.myapplication.feature.domain.repository.UserRepository

class UserRepositoryImpl(
    private val remoteDataSource: DataSource
) : UserRepository {

    override suspend fun loadUser(): List<UserModel> {
        return remoteDataSource.loadUser()
    }

    override suspend fun loadUserById(id: Int): UserDetailsModel {
        return remoteDataSource.loadUserById(id)
    }
}