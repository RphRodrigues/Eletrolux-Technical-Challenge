package br.com.rstudio.myapplication.featureA.domain.usecase

import br.com.rstudio.myapplication.featureA.domain.model.ProductsModel

interface LoadProductsUseCase {
    suspend operator fun invoke(): ProductsModel
}