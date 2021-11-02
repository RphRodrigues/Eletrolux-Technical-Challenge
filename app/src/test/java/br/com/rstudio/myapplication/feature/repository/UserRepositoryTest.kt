package br.com.rstudio.myapplication.feature.repository

import br.com.rstudio.myapplication.feature.UserModelHelper
import br.com.rstudio.myapplication.feature.data.datasource.DataSource
import br.com.rstudio.myapplication.feature.data.repository.UserRepositoryImpl
import br.com.rstudio.myapplication.feature.domain.model.UserModel
import br.com.rstudio.myapplication.feature.domain.repository.UserRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.coVerifyOrder
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
class UserRepositoryTest {

    private val testDispatcher = TestCoroutineDispatcher()

    private lateinit var repository: UserRepository
    private val remoteDataSource: DataSource = mockk(relaxed = true)

    private val mockedList: List<UserModel> = UserModelHelper.mockedList

    @Before
    fun setUp() {
        repository = UserRepositoryImpl(remoteDataSource)
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun `when load users is called then it should call remote data source`() {
        coEvery { remoteDataSource.loadUser() } returns mockedList

        runBlockingTest {
            repository.loadUser()
        }

        coVerify { remoteDataSource.loadUser() }
    }

    @Test
    fun `when load user details is called then it should call remote data source`() {
        val id = 1
        val user = UserModelHelper.mockedUserDetails
        coEvery { remoteDataSource.loadUserById(any()) } returns user

        runBlockingTest {
            repository.loadUserById(id)
        }

        coVerifyOrder { remoteDataSource.loadUserById(id) }
    }
}