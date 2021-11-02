package br.com.rstudio.myapplication.featureb

sealed class NetworkingException(message: String) : Exception(message) {
    class Error(message: String) : NetworkingException(message)
}