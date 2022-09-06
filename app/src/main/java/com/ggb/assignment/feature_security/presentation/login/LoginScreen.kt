package com.ggb.assignment.feature_security.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ggb.assignment.feature_security.presentation.login.LoginViewModel
import com.ggb.assignment.ui.theme.AssignmentTheme

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel? = null,
    onClick: () -> Unit
) {
    val loginUIState = loginViewModel?.LoginUIState
    val context = LocalContext.current
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Login",
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.Black,
            color = MaterialTheme.colors.primary,
            textAlign = TextAlign.End

        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            value = loginUIState?.username ?: "",
            onValueChange = {loginViewModel?.onUserNameChange(it)},
            label = {
                Text(text = "Email")
            }

        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            value = loginUIState?.password ?: "",
            onValueChange = {loginViewModel?.onUserNameChange(it)},
            label = {
                Text(text = "Password")
            }
        )
        
        Button(
            modifier = Modifier
                .padding(16.dp),
            onClick = { loginViewModel?.loginUser(context) }) {
            Text(
                modifier = Modifier
                    .padding(5.dp),
                text = "Login"
            )
        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun PrevLoginScreen(){
    AssignmentTheme{
        LoginScreen(loginViewModel = null) {
        }
    }
}

