package com.example.peopleapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import com.example.peopleapp.navigation.Screen.*
import com.example.peopleapp.feature_user.presentation.mascotas.MascotasScreen

//ACa Creamos las rutas de navegacion

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = MascotasScreen.route
    ) {
        composable(
            route = MascotasScreen.route
        ){
            MascotasScreen()
        }
    }
}