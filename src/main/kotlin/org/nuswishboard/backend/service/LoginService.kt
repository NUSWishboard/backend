package org.nuswishboard.backend.service

interface LoginService {
    fun loginByToken(token: String)
}
