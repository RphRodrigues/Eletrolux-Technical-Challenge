package br.com.rstudio.myapplication.featureb.presentation.userdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.rstudio.myapplication.featureb.domain.model.UserDetailsModel
import br.com.rstudio.myapplication.featureb.domain.model.UserModel

class UserDetailsViewModel : ViewModel() {

    private var _user = MutableLiveData<UserDetailsModel>()
    val user: LiveData<UserDetailsModel> = _user

    fun init(user: UserDetailsModel) {
        _user.value = user
    }
}