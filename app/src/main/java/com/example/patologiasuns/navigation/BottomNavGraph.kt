package com.example.patologiasuns.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.patologiasuns.feature_detalle.DetalleScreen
import com.example.patologiasuns.feature_detalle.presentation.components.DetallesContent
import com.example.patologiasuns.feature_user.presentation.patologias.HomeScreen
import com.example.patologiasuns.feature_user.presentation.patologias.SettingScreen


@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(route = BottomBarScreen.Settings.route) {
            SettingScreen()
        }
        /*composable(
            "${BottomBarScreen.Detalles.route}/{id}/{nombre}",
            arguments = listOf(
                navArgument("id") { type = NavType.IntType },
                navArgument("nombre") { type = NavType.StringType },
            )
        ) {
            DetalleScreen(id = it.arguments?.getInt("id") ?: 0)
        }*/
    }
}
/*
    Each NavController must be associated with a single NavHost composable.
    The NavHost links the NavController with a navigation graph that specifies
    the composable destinations that you should be able to navigate between.
    As you navigate between composables, the content of the NavHost is automatically recomposed.
    Each composable destination in your navigation graph is associated with a route.

*/

