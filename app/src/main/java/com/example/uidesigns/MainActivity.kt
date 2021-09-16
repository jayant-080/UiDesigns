package com.example.uidesigns

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.uidesigns.screens.HomeScreen
import com.example.uidesigns.screens.SplashScreen
import com.example.uidesigns.ui.theme.UiDesignsTheme


object NavRoute{

    val SPLASH_SCREEN = "splash_Screen"
    val HOME_SCREEN = "HomeScreen"
}
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UiDesignsTheme {
                val navController = rememberNavController()
                MyNavHost(navHostController = navController)
                print("experimental changes")
                print("master things")
            }
        }
    }
}


@Composable
fun MyNavHost(navHostController: NavHostController){
    NavHost(navController = navHostController, startDestination = NavRoute.SPLASH_SCREEN){
        composable(NavRoute.SPLASH_SCREEN){
            SplashScreen {
                navHostController.navigate(NavRoute.HOME_SCREEN)
            }
        }

        composable(NavRoute.HOME_SCREEN){
            HomeScreen {
                navHostController.navigate(NavRoute.HOME_SCREEN)
            }

        }

    }
}