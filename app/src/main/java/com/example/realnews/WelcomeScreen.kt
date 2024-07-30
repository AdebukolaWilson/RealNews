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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun WelcomeScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Image(painter = painterResource(id = R.drawable.design),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                modifier = Modifier.width(200.dp).height(160.dp),
                contentScale = ContentScale.Fit
            )

            Text(
                text = "WELCOME",
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(66.dp))

            Button(
                onClick = { navController.navigate("Login" ) },
                Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .padding(horizontal = 5.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue
                ),
            ) {
                Text(text = "Go to Login",
                    fontSize = 20.sp)
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
fun WelcomeScreenPreview(){
    WelcomeScreen(rememberNavController())
}