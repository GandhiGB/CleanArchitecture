package com.ggb.assignment.feature_security.data.repositories

import com.ggb.assignment.feature_security.domain.contracts.IUserRepository

class UserRepository : IUserRepository{
    override suspend fun login(email: String, password: String): Boolean {
        if(email == "ggb" && password == "ggb")
            return true
        return false
    }
}