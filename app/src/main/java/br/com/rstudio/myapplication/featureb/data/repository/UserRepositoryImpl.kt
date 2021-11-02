package br.com.rstudio.myapplication.featureb.data.repository

import br.com.rstudio.myapplication.featureb.data.datasource.DataSource
import br.com.rstudio.myapplication.featureb.domain.model.UserDetailsModel
import br.com.rstudio.myapplication.featureb.domain.model.UserModel
import br.com.rstudio.myapplication.featureb.domain.repository.UserRepository

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