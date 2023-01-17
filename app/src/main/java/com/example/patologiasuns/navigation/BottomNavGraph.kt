package com.example.patologiasuns.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.patologiasuns.feature_user.presentation.mascotas.HomeScreen
import com.example.patologiasuns.feature_user.presentation.mascotas.SettingScreen


@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Settings.route
    ){
        composable(route = BottomBarScreen.Home.route){
            HomeScreen()
        }
        composable(route = BottomBarScreen.Settings.route){
            SettingScreen()
        }
    }
}
/*
    Each NavController must be associated with a single NavHost composable.
    The NavHost links the NavController with a navigation graph that specifies
    the composable destinations that you should be able to navigate between.
    As you navigate between composables, the content of the NavHost is automatically recomposed.
    Each composable destination in your navigation graph is associated with a route.

*/

