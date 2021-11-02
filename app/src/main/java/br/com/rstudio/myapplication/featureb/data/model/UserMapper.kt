package br.com.rstudio.myapplication.featureb.data.model

import br.com.rstudio.myapplication.featureb.domain.model.UserDetailsModel
import br.com.rstudio.myapplication.featureb.domain.model.UserModel

class UserMapper {

    fun transform(dto: UserDTO) = UserModel(
        id = dto.id,
        login = dto.login,
        avatarUrl = dto.avatarUrl
    )

    fun transform(dto: UserDetailsDTO) = UserDetailsModel(
        login = dto.login,
        name = dto.name,
        avatarUrl = dto.avatarUrl,
        bio = dto.bio
    )
}