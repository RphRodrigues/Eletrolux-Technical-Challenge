package br.com.rstudio.myapplication.featureb.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import br.com.rstudio.myapplication.featureb.UserModelHelper
import br.com.rstudio.myapplication.featureb.domain.model.UserDetailsModel
import br.com.rstudio.myapplication.featureb.domain.model.UserModel
import br.com.rstudio.myapplication.featureb.domain.usecase.LoadUserDetailsUseCase
import br.com.rstudio.myapplication.featureb.domain.usecase.LoadUsersUseCase
import br.com.rstudio.myapplication.featureb.presentation.userlist.UserListViewModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class UserListViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()
    private val testDispatcher = TestCoroutineDispatcher()

    private lateinit var viewModel: UserListViewModel

    private val loadUsersUseCase = mockk<LoadUsersUseCase>(relaxed = true)
    private val loadUserDetailsUseCase = mockk<LoadUserDetailsUseCase>(relaxed = true)
    private val onUsersObserver = mockk<Observer<List<UserModel>>>(relaxed = true)
    private val onUserObserver = mockk<Observer<UserDetailsModel>>(relaxed = true)

    private val mockedList = UserModelHelper.mockedList

    @Before
    fun setUp() {
        viewModel = instantiateViewModel()
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun `when view model load users is called then it should call use case`() {
        coEvery { loadUsersUseCase.invoke() } returns mockedList

        viewModel.loadUsers()

        coVerify { loadUsersUseCase.invoke() }
    }

    @Test
    fun `when loading users successfully then refresh the view`() {
        coEvery { loadUsersUseCase.invoke() } returns mockedList

        viewModel.loadUsers()

        verify { onUsersObserver.onChanged(mockedList) }
    }

    @Test
    fun `when view model load user details is called then it should call use case`() {
        val id = 1
        coEvery { loadUserDetailsUseCase.invoke(any()) } returns UserModelHelper.mockedUserDetails

        viewModel.loadUserDetails(id)

        coVerify { loadUserDetailsUseCase.invoke(id) }
    }

    @Test
    fun `when loading user details successfully then refresh the view`() {
        val id = 1
        val user = UserModelHelper.mockedUserDetails
        coEvery { loadUserDetailsUseCase.invoke(any()) } returns user

        viewModel.loadUserDetails(id)

        verify { onUserObserver.onChanged(user) }
    }

    private fun instantiateViewModel(): UserListViewModel {
        val viewModel = UserListViewModel(loadUsersUseCase, loadUserDetailsUseCase)
        viewModel.users.observeForever(onUsersObserver)
        viewModel.user.observeForever(onUserObserver)
        return viewModel
    }
}
