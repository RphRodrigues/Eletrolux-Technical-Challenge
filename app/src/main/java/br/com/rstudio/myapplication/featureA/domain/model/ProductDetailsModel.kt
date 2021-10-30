package br.com.rstudio.myapplication.featureA.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductDetailsModel(
    val id: String,
    val name: String,
    val type: String
) : Parcelable
