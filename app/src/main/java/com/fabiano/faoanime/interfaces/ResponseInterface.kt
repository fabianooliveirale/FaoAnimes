package com.fabiano.faoanime.interfaces

interface ResponseInterface {
    fun loading()
    fun afterLoading()
    fun beforeLoading()
    fun dismissLoading()
    fun <T> success(response: T?)
    fun error(error: String)
}