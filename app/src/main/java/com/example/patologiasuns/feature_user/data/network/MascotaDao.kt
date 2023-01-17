package com.example.patologiasuns.feature_user.data.network

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE

import androidx.room.Query
import com.example.patologiasuns.Constants.Companion.MASCOTA_TABLE
import com.example.patologiasuns.feature_user.domain.model.Mascota
import com.example.patologiasuns.feature_user.domain.repository.Mascotas
import kotlinx.coroutines.flow.Flow

//Definimos la interfaz que realiza el acceso a los datos (a la db)
@Dao
interface MascotaDao {
    @Query("SELECT * FROM $MASCOTA_TABLE ORDER BY id ASC")
    fun getMascotas() : Flow<Mascotas>

    @Insert(onConflict = IGNORE)
    fun addMascota(mascota : Mascota)
}