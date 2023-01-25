package com.example.patologiasuns.feature_user.data.network

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.patologiasuns.feature_user.domain.model.Patologia

//Definimos la clase que hereda de RoomDatabase
//Esta clase crea una DB de Room con la entidad que definimos en la clase Mascota

@Database(entities = [Patologia::class], version = 1, exportSchema = false)
abstract class PatologiaDB: RoomDatabase(){
    abstract fun patologiaDao() : PatologiaDao
}


