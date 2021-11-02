package br.com.rstudio.myapplication.feature.domain.usecase

import br.com.rstudio.myapplication.feature.domain.model.UserDetailsModel

interface LoadUserDetailsUseCase {
    suspend operator fun invoke(id: Int): UserDetailsModel
}