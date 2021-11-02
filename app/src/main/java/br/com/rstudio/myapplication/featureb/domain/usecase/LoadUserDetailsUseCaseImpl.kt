package br.com.rstudio.myapplication.featureb.domain.usecase

import br.com.rstudio.myapplication.featureb.domain.model.UserDetailsModel
import br.com.rstudio.myapplication.featureb.domain.repository.UserRepository

class LoadUserDetailsUseCaseImpl(
    private val repository: UserRepository
) : LoadUserDetailsUseCase {

    override suspend fun invoke(id: Int): UserDetailsModel {
        return repository.loadUserById(id)
    }
}