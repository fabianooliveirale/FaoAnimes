package com.fabiano.faoanime.interfaces

interface ResponseInterface {
    fun <T> success(response: T) : Unit?
    fun error(error: String) : Unit?
}