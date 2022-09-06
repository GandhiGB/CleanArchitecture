package com.ggb.CleanArchitecture.feature_security.domain.contracts

interface IUserRepository {
    suspend fun login(email : String, password: String) : Boolean
}