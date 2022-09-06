package com.ggb.assignment.feature_security.domain.use_case

import com.ggb.assignment.feature_security.domain.contracts.IUserRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val  _repo : IUserRepository
) {
    suspend operator fun invoke(email:String, password:String): Boolean {
         return _repo.login(email, password)
    }
}