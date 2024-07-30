package com.example.realnews

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun LoginScreen(
    navController: NavHostController,
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.design),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(90.dp))

            Text(
                text = "Login Below",
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(66.dp))


            var email by remember { mutableStateOf("") }
            TextField(
                value = email,
                onValueChange = { it -> email = it },
                label = { Text("Enter Your Email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp, top = 10.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            )

            var password by remember { mutableStateOf("") }
            var passwordVisible by remember { mutableStateOf(false) }

            TextField(
                value = password,
                onValueChange = { it -> password = it },
                label = { Text(" Password") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp, top = 10.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val image = if (passwordVisible) {
                        Icons.Filled.Visibility
                    } else {
                        Icons.Filled.VisibilityOff
                    }

                    var description = if (passwordVisible) {
                        "Hide password"
                    } else {
                        "Show password"
                    }

                    IconButton(onClick = {
                        passwordVisible = !passwordVisible
                    }) { Icon(imageVector = image, contentDescription = description) }
                },
            )

            Spacer(modifier = Modifier.height(66.dp))
            Button(
                onClick = { navController.navigate("NewsScreen" ) },
                Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .padding(horizontal = 5.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue
                ),
            ) {
                Text(
                    text = "Login",
                    fontSize = 30.sp
                )
            }

            Spacer(modifier = Modifier.height(26.dp))

            OutlinedButton(
                onClick = { navController.navigate("SignUp" ) },
                Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .padding(horizontal = 5.dp)
            ) {
                Text(text = "Don't Have an Account? SignUp",
                    fontSize = 20.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview(){
    LoginScreen(rememberNavController())
}