package br.com.rstudio.myapplication.featureA.domain.usecase

import br.com.rstudio.myapplication.featureA.domain.model.ProductDetailsModel

interface LoadProductDetailsUseCase {

    suspend operator fun invoke(id: String): ProductDetailsModel
}