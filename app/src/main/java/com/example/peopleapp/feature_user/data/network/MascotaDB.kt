package com.example.peopleapp.feature_user.data.network

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.peopleapp.feature_user.domain.model.Mascota

//Definimos la clase que hereda de RoomDatabase
//Esta clase crea una DB de Room con la entidad que definimos en la clase Mascota

@Database(entities = [Mascota::class], version = 1, exportSchema = false)
abstract class MascotaDB: RoomDatabase(){
    abstract fun mascotaDao() : MascotaDao
}


