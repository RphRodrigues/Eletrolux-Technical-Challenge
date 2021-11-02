package br.com.rstudio.myapplication.featureb.domain.usecase

import br.com.rstudio.myapplication.featureb.domain.model.UserModel
import br.com.rstudio.myapplication.featureb.domain.repository.UserRepository

class LoadUsersUseCaseImpl(
    private val repository: UserRepository
) : LoadUsersUseCase {

    override suspend fun invoke(): List<UserModel> {
        return repository.loadUser()
    }
}