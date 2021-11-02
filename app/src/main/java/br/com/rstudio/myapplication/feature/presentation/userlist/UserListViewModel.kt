package br.com.rstudio.myapplication.feature.presentation.userlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.rstudio.myapplication.feature.domain.model.UserDetailsModel
import br.com.rstudio.myapplication.feature.domain.model.UserModel
import br.com.rstudio.myapplication.feature.domain.usecase.LoadUserDetailsUseCase
import br.com.rstudio.myapplication.feature.domain.usecase.LoadUsersUseCase
import kotlinx.coroutines.launch

class UserListViewModel(
    private val loadUsersUseCase: LoadUsersUseCase,
    private val loadUserDetailsUseCase: LoadUserDetailsUseCase
) : ViewModel() {

    private var _users = MutableLiveData<List<UserModel>>()
    val users: LiveData<List<UserModel>> = _users

    private var _user = MutableLiveData<UserDetailsModel>()
    val user: LiveData<UserDetailsModel> = _user

    private var _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private var _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun loadUsers() {
        handleRequest {
            val data = loadUsersUseCase()
            _users.value = data
        }
    }

    fun loadUserDetails(id: Int) {
        handleRequest {
            val data = loadUserDetailsUseCase(id)
            _user.value = data
        }
    }

    private fun handleRequest(doWork: suspend () -> Unit) = viewModelScope.launch {
        try {
            _isLoading.value = true
            doWork()
        } catch (error: Exception) {
            _error.value = error.message
        } finally {
            _isLoading.value = false
        }
    }
}