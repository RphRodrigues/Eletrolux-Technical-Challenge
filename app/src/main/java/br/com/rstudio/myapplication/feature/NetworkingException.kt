package br.com.rstudio.myapplication.feature

sealed class NetworkingException(message: String) : Exception(message) {
    class Error(message: String) : NetworkingException(message)
}