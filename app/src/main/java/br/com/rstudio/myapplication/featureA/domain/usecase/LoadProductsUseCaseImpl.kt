package br.com.rstudio.myapplication.featureA.domain.usecase

import br.com.rstudio.myapplication.featureA.domain.repository.ProductRepository
import br.com.rstudio.myapplication.featureA.domain.model.ProductsModel

class LoadProductsUseCaseImpl(
    private val repository: ProductRepository
) : LoadProductsUseCase {

    override suspend operator fun invoke(): ProductsModel {
        return repository.loadProducts()
    }
}