package com.ggb.assignment.feature_security.domain.contracts

interface IUserRepository {
    suspend fun login(email : String, password: String) : Boolean
}