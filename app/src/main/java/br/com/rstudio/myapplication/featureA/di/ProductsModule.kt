package br.com.rstudio.myapplication.featureA.di

import br.com.rstudio.myapplication.featureA.data.api.ApiService
import br.com.rstudio.myapplication.featureA.data.datasource.DataSource
import br.com.rstudio.myapplication.featureA.data.datasource.LocalDataSourceImpl
import br.com.rstudio.myapplication.featureA.data.datasource.RemoteDataSourceImpl
import br.com.rstudio.myapplication.featureA.data.model.Mapper
import br.com.rstudio.myapplication.featureA.data.repository.ProductRepositoryImpl
import br.com.rstudio.myapplication.featureA.domain.repository.ProductRepository
import br.com.rstudio.myapplication.featureA.domain.usecase.LoadProductDetailsUseCaseImpl
import br.com.rstudio.myapplication.featureA.domain.usecase.LoadProductDetailsUseCase
import br.com.rstudio.myapplication.featureA.domain.usecase.LoadProductsUseCase
import br.com.rstudio.myapplication.featureA.domain.usecase.LoadProductsUseCaseImpl
import br.com.rstudio.myapplication.getRetrofit
import br.com.rstudio.myapplication.featureA.presentation.productslist.ProductsListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module

object ProductsModule {

    val module = module {

        single<ApiService> { getRetrofit().create(ApiService::class.java) }

        single { Mapper() }

        single { RemoteDataSourceImpl(api = get(), mapper = get()) } bind DataSource::class

        single { LocalDataSourceImpl() } bind DataSource::class

        single<ProductRepository> { ProductRepositoryImpl(remoteDataSource = get<RemoteDataSourceImpl>(), localDataSource = get<LocalDataSourceImpl>()) }

        single<LoadProductsUseCase> { LoadProductsUseCaseImpl(repository = get()) }

        single<LoadProductDetailsUseCase> { LoadProductDetailsUseCaseImpl(repository = get()) }

        viewModel { ProductsListViewModel(loadProductsUseCase = get(), loadProductDetailsUseCase = get()) }
    }
}