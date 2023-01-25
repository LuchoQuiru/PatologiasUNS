package com.example.patologiasuns

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
/*
* Esto significa que esta clase, es la primera en llamarse cuando se inicie la app
* Sera nuestro contenedor del grafico de hilt, donde van a estar todas las dependencias.
*/

class MyAppCrud : Application()