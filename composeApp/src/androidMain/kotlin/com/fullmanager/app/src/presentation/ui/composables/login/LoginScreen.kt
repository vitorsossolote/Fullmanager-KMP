package com.fullmanager.app.src.presentation.ui.composables.login

import android.R.attr.onClick
import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.fullmanager.app.R
import com.fullmanager.app.presentation.screens.login.LoginEvents
import com.fullmanager.app.presentation.screens.login.LoginUiState
import com.fullmanager.app.presentation.screens.login.LoginViewModel
import com.fullmanager.app.src.presentation.ui.composables.theme.FullmanagerTheme
import com.fullmanager.app.src.presentation.ui.composables.theme.TextFieldTokens
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.koinInject

@Composable
fun LoginScreen(
    navController: NavController?,
    ) {

    val viewModel: LoginViewModel = koinInject<LoginViewModel>()
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.navigationEvents.collect {route ->
            navController?.navigate(route)
        }
    }

    LoginContent(
        onEvent = viewModel::onEvent,
        uiState = state
    )
}

@Composable
private fun LoginContent(
    onEvent: (LoginEvents) -> Unit,
    uiState: LoginUiState
) {

    Scaffold(
        topBar = {},
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .statusBarsPadding()
                .background(MaterialTheme.colorScheme.background)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                Image(
                    painterResource(R.drawable.fullmanager_logo),
                    contentDescription = "Logo Fullmanager",
                    modifier = Modifier
                        .absoluteOffset(x = 20.dp, y = (-5).dp)
                        .size(85.dp)

                )
                Image(
                    painterResource(R.drawable.logo_background),
                    contentDescription = "Logo Fullmanager",
                )
            }

            Spacer(Modifier.height(30.dp))

            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ){

                LoginTextInput(
                    text = uiState.username,
                    onTextChange = { onEvent(LoginEvents.OnUserNameChange(it)) },
                    inputLabel = "Usuário",
                    inputPlacerHolder = "Digite seu usuário",
                    inputType = InputType.USER,
                )

                LoginTextInput(
                    text = uiState.password,
                    onTextChange = { onEvent(LoginEvents.OnPasswordChange(it)) },
                    inputLabel = "Senha",
                    inputPlacerHolder = "Digite sua senha",
                    inputType = InputType.PASSWORD,
                    onShowPasswordClick = { onEvent(LoginEvents.OnShowPasswordChange)},
                    showPassword = uiState.showPassword
                )
            }
        }
    }
}

@Composable
fun LoginTextInput(
    text: String,
    onTextChange: (String) -> Unit,
    inputLabel: String,
    inputPlacerHolder: String,
    inputType: InputType,
    onShowPasswordClick: () -> Unit = {},
    showPassword: Boolean ?= null,
) {
    TextField(
        value = text,
        onValueChange = onTextChange,
        label = { Text(inputLabel) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        shape = RoundedCornerShape(25),
        singleLine = true,
        leadingIcon = {
            when(inputType){
                InputType.USER -> InputIcon(
                    R.drawable.person,
                    "Usuário"
                )
                InputType.PASSWORD -> InputIcon(
                    R.drawable.lock,
                    "Senha"
                )
            }
        },
        trailingIcon = {
            if(inputType == InputType.PASSWORD){
                InputIcon(
                    icon =  if (showPassword == true) R.drawable.eye else R.drawable.eye_off ,
                    contentDescription = if (showPassword == true) "Esconder senha" else "Mostrar senha",
                    modifier = Modifier.clickable(
                        onClick = onShowPasswordClick
                    )
                )
            }
        },
        placeholder = { Text(inputPlacerHolder) },
        colors = TextFieldTokens.defaultColors(),
        visualTransformation = if (showPassword == true) VisualTransformation.None else PasswordVisualTransformation()
    )
}


@Composable
private fun InputIcon(icon: Int, contentDescription: String, modifier: Modifier = Modifier) {
    Icon(
        painterResource(icon),
        contentDescription = contentDescription,
        modifier = modifier
            .size(35.dp)
            .padding(5.dp)
    )
}
enum class InputType {
    USER,
    PASSWORD
}

@Preview(
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Preview(
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
private fun LoginContentPreview() {
    FullmanagerTheme{
        LoginContent(
            onEvent = {},
            uiState = LoginUiState()
        )
    }
}