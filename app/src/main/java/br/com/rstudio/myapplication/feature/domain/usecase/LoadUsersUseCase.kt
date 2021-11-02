package br.com.rstudio.myapplication.feature.domain.usecase

import br.com.rstudio.myapplication.feature.domain.model.UserModel

interface LoadUsersUseCase {
    suspend operator fun invoke(): List<UserModel>
}