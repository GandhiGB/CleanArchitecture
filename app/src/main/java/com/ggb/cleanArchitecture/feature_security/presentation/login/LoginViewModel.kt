package com.ggb.cleanArchitecture.feature_security.presentation.login

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ggb.cleanArchitecture.feature_security.domain.use_case.LoginUseCase
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
) : ViewModel() {
    var loginUIState by mutableStateOf(LoginUIState())
        private set
    fun onUserNameChange(userName:String){
        loginUIState = loginUIState.copy(username = userName)
    }
    fun onPasswordChange(password:String){
        loginUIState = loginUIState.copy(password = password)
    }

    private fun validateLoginForm() =
        loginUIState.username.isNotBlank() && loginUIState.password.isNotBlank()

    fun loginUser(context: Context) = viewModelScope.launch{
        try {
            if(!validateLoginForm())
                throw   IllegalArgumentException("email and password can not be empty!")
            var result = loginUseCase(loginUIState.username, loginUIState.password)
            if(result){
                /*Redirect to main page*/
                Toast.makeText(
                    context,
                    "Login Success!",
                    Toast.LENGTH_LONG
                ).show()
            }
            else{
                Toast.makeText(
                    context,
                    "Invalid Username or Password",
                    Toast.LENGTH_LONG
                ).show()
            }
        } catch (e:Exception){
            loginUIState = loginUIState.copy(loginerror = e.localizedMessage)
        }
    }
}
data class LoginUIState(
    val username:String = "",
    val password:String = "",
    val loginerror:String? = null
)