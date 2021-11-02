package br.com.rstudio.myapplication.featureb.data.datasource

import br.com.rstudio.myapplication.featureb.NetworkingException
import br.com.rstudio.myapplication.featureb.data.api.ApiService
import br.com.rstudio.myapplication.featureb.data.model.UserMapper
import br.com.rstudio.myapplication.featureb.domain.model.UserDetailsModel
import br.com.rstudio.myapplication.featureb.domain.model.UserModel

class RemoteDataSource(
    private val api: ApiService,
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