package com.example.patologiasuns.feature_user.data.network

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.patologiasuns.feature_user.domain.model.Patologia
import com.example.patologiasuns.feature_user.domain.model.Step

//Definimos la clase que hereda de RoomDatabase
//Esta clase crea una DB de Room con la entidad que definimos en la clase Mascota

@Database(entities = [Patologia::class, Step::class], version = 2, exportSchema = false)
abstract class PatologiaDB: RoomDatabase(){
    abstract fun patologiaDao() : PatologiaDao
}


