package br.com.rstudio.myapplication.featureA.domain.usecase

import br.com.rstudio.myapplication.featureA.domain.model.ProductDetailsModel
import br.com.rstudio.myapplication.featureA.domain.repository.ProductRepository

class LoadProductDetailsUseCaseImpl(
    private val repository: ProductRepository
) : LoadProductDetailsUseCase {

    override suspend fun invoke(id: String): ProductDetailsModel {
        return repository.loadProductDetails(id)
    }
}