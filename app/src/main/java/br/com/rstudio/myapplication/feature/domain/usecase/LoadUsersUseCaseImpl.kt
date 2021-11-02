package br.com.rstudio.myapplication.feature.domain.usecase

import br.com.rstudio.myapplication.feature.domain.model.UserModel
import br.com.rstudio.myapplication.feature.domain.repository.UserRepository

class LoadUsersUseCaseImpl(
    private val repository: UserRepository
) : LoadUsersUseCase {

    override suspend fun invoke(): List<UserModel> {
        return repository.loadUser()
    }
}