package br.com.rstudio.myapplication.featureb.usecase

import br.com.rstudio.myapplication.featureb.domain.repository.UserRepository
import br.com.rstudio.myapplication.featureb.domain.usecase.LoadUsersUseCase
import br.com.rstudio.myapplication.featureb.domain.usecase.LoadUsersUseCaseImpl
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class LoadUsersUseCaseTest {

    private val repository: UserRepository = mockk(relaxed = true)
    private lateinit var loadUsersUseCase: LoadUsersUseCase

    @Before
    fun setUp() {
        loadUsersUseCase = LoadUsersUseCaseImpl(repository)
    }

    @Test
    fun `when load users use case is called then it should call the repository`() {
        runBlockingTest {
            loadUsersUseCase.invoke()
        }

        coVerify { repository.loadUser() }
    }
}