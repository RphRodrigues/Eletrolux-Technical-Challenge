package br.com.rstudio.myapplication.featureb.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserDetailsModel(
    val login: String,
    val name: String?,
    val avatarUrl: String,
    val bio: String?,
) : Parcelable