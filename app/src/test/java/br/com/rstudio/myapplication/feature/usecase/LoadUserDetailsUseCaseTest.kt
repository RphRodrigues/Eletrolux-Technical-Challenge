package br.com.rstudio.myapplication.feature.usecase

import br.com.rstudio.myapplication.feature.domain.repository.UserRepository
import br.com.rstudio.myapplication.feature.domain.usecase.LoadUserDetailsUseCase
import br.com.rstudio.myapplication.feature.domain.usecase.LoadUserDetailsUseCaseImpl
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class LoadUserDetailsUseCaseTest {

    private val repository: UserRepository = mockk(relaxed = true)
    private lateinit var loadUserDetailsUseCase: LoadUserDetailsUseCase

    @Before
    fun setUp() {
        loadUserDetailsUseCase = LoadUserDetailsUseCaseImpl(repository)
    }

    @Test
    fun `when load user details use case is called then it should call the repository`() {
        val id = 1

        runBlockingTest {
            loadUserDetailsUseCase.invoke(id)
        }

        coVerify { repository.loadUserById(id) }
    }
}