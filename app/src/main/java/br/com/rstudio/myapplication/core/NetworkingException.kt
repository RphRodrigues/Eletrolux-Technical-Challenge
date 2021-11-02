package br.com.rstudio.myapplication.core

sealed class NetworkingException(message: String) : Exception(message) {
    class Error(message: String) : NetworkingException(message)
}