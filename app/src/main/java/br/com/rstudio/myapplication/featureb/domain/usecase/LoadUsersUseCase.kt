package br.com.rstudio.myapplication.featureb.domain.usecase

import br.com.rstudio.myapplication.featureb.domain.model.UserModel

interface LoadUsersUseCase {
    suspend operator fun invoke(): List<UserModel>
}