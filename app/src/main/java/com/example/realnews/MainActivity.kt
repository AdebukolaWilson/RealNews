package com.example.realnews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.realnews.presentation.news_screen.NewsScreen
import com.example.realnews.presentation.theme.RealNewsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RealNewsTheme {
                NavigationView()
            }
        }
    }
}

@Composable
fun NavigationView() {

    val navController = rememberNavController()
    NavHost(navController = navController , startDestination = "welcome"){
        composable("welcome"){ WelcomeScreen(navController)}
        composable("login"){ LoginScreen(navController)}
        composable("signup"){ SignUpScreen(navController)}
        composable("NewsScreen"){ }
    }
}
