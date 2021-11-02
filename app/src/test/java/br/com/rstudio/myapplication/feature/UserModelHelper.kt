package br.com.rstudio.myapplication.feature

import br.com.rstudio.myapplication.feature.domain.model.UserDetailsModel
import br.com.rstudio.myapplication.feature.domain.model.UserModel

object UserModelHelper {

    val mockedList: List<UserModel>
        get() = listOf(
            UserModel(id = 1, login = "login 1", avatarUrl = "url"),
            UserModel(id = 2, login = "login 2", avatarUrl = "url")
        )

    val mockedUserDetails: UserDetailsModel
        get() = UserDetailsModel(
            login = "",
            name = "",
            avatarUrl = "",
            bio = ""
        )
}