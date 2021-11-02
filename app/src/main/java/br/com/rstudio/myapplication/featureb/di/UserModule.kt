package br.com.rstudio.myapplication.featureb.di

import br.com.rstudio.myapplication.featureb.data.api.ApiService
import br.com.rstudio.myapplication.featureb.data.datasource.DataSource
import br.com.rstudio.myapplication.featureb.data.datasource.RemoteDataSource
import br.com.rstudio.myapplication.featureb.data.model.UserMapper
import br.com.rstudio.myapplication.featureb.data.repository.UserRepositoryImpl
import br.com.rstudio.myapplication.featureb.domain.repository.UserRepository
import br.com.rstudio.myapplication.featureb.domain.usecase.LoadUserDetailsUseCase
import br.com.rstudio.myapplication.featureb.domain.usecase.LoadUserDetailsUseCaseImpl
import br.com.rstudio.myapplication.featureb.domain.usecase.LoadUsersUseCase
import br.com.rstudio.myapplication.featureb.domain.usecase.LoadUsersUseCaseImpl
import br.com.rstudio.myapplication.featureb.presentation.userdetails.UserDetailsViewModel
import br.com.rstudio.myapplication.featureb.presentation.userlist.UserListViewModel
import br.com.rstudio.myapplication.getRetrofit
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

object UserModule {

    val module = module {

        single<ApiService> { getRetrofit().create(ApiService::class.java) }

        single<UserMapper> { UserMapper() }

        single<DataSource> { RemoteDataSource(api = get(), mapper = get()) }

        single<UserRepository> { UserRepositoryImpl(remoteDataSource = get()) }

        single<LoadUsersUseCase> { LoadUsersUseCaseImpl(repository = get()) }

        single<LoadUserDetailsUseCase> { LoadUserDetailsUseCaseImpl(repository = get()) }

        viewModel { UserListViewModel(loadUsersUseCase = get(), loadUserDetailsUseCase = get()) }

        viewModel { UserDetailsViewModel() }
    }
}