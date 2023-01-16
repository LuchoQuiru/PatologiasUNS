package com.example.peopleapp.navigation

import com.example.peopleapp.Constants.Companion.MASCOTAS_SCREEN
import com.example.peopleapp.Constants.Companion.UPDATE_SCREEN

sealed class Screen(val route : String) {
    //Creamos las pantallas que tendra nuestra aplicacion

    object MascotasScreen : Screen(MASCOTAS_SCREEN)
    object UpdateMascotaScreen : Screen(UPDATE_SCREEN)
}