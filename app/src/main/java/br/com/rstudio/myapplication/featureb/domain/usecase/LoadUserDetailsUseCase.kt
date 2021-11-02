package br.com.rstudio.myapplication.featureb.domain.usecase

import br.com.rstudio.myapplication.featureb.domain.model.UserDetailsModel

interface LoadUserDetailsUseCase {
    suspend operator fun invoke(id: Int): UserDetailsModel
}