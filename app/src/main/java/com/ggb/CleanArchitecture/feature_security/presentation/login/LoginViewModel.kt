package com.ggb.CleanArchitecture.feature_security.presentation.login

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ggb.CleanArchitecture.feature_security.domain.use_case.LoginUseCase
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
) : ViewModel() {
    var LoginUIState by mutableStateOf(LoginUIState())
        private set
    fun onUserNameChange(userName:String){
        LoginUIState = LoginUIState.copy(username = userName)
    }
    fun onPasswordChange(password:String){
        LoginUIState = LoginUIState.copy(password = password)
    }

    private fun validateLoginForm() =
        LoginUIState.username.isNotBlank() && LoginUIState.password.isNotBlank()

    fun loginUser(context: Context) = viewModelScope.launch{
        try {
            if(!validateLoginForm())
                throw   IllegalArgumentException("email and password can not be empty!")
            var result = loginUseCase(LoginUIState.username, LoginUIState.password)
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
            LoginUIState = LoginUIState.copy(loginerror = e.localizedMessage)
        }
    }
}
data class LoginUIState(
    val username:String = "",
    val password:String = "",
    val loginerror:String? = null
)