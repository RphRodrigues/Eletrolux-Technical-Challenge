package br.com.rstudio.myapplication.feature.data.datasource

import br.com.rstudio.myapplication.core.NetworkingException
import br.com.rstudio.myapplication.feature.data.api.UserApiService
import br.com.rstudio.myapplication.feature.data.model.UserMapper
import br.com.rstudio.myapplication.feature.domain.model.UserDetailsModel
import br.com.rstudio.myapplication.feature.domain.model.UserModel

class RemoteDataSource(
    private val api: UserApiService,
    private val mapper: UserMapper
) : DataSource {

    override suspend fun loadUser(): List<UserModel> {
        val response = api.loadUsers()

        return if (response.isSuccessful) {
            response.body()!!.map { mapper.transform(it) }
        } else {
            throw NetworkingException.Error(response.message())
        }
    }

    override suspend fun loadUserById(id: Int): UserDetailsModel {
        val response = api.loadUserById(id)

        return if (response.isSuccessful) {
            response.body()!!.let { mapper.transform(it) }
        } else {
            throw NetworkingException.Error(response.message())
        }
    }
}