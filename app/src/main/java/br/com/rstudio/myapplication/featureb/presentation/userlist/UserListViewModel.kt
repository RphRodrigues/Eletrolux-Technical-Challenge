package br.com.rstudio.myapplication.featureb.presentation.userlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.rstudio.myapplication.featureb.domain.model.UserDetailsModel
import br.com.rstudio.myapplication.featureb.domain.model.UserModel
import br.com.rstudio.myapplication.featureb.domain.usecase.LoadUserDetailsUseCase
import br.com.rstudio.myapplication.featureb.domain.usecase.LoadUsersUseCase
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

    fun loadUsers() = viewModelScope.launch {
        runCatching {
            loadUsersUseCase()
        }.onSuccess { data ->
            _users.value = data
        }.onFailure { error ->
            _error.value = error.message

//            {
//                "message":"API rate limit exceeded for 189.84.176.185. (But here's the good news: Authenticated requests get a higher rate limit. Check out the documentation for more details.)",
//                "documentation_url":"https://docs.github.com/rest/overview/resources-in-the-rest-api#rate-limiting"
//            }
        }
    }

    fun loadUserDetails(id: Int) = viewModelScope.launch {
        runCatching {
            loadUserDetailsUseCase(id)
        }.onSuccess { data ->
            _user.value = data
        }.onFailure { error ->
            _error.value = error.message
        }
    }
}