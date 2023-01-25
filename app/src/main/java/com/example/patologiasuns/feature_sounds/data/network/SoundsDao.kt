package com.example.patologiasuns.feature_sounds.data.network

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE

import androidx.room.Query
import com.example.patologiasuns.Constants.Companion.SOUNDS_TABLE
import com.example.patologiasuns.feature_sounds.domain.model.Sound
import com.example.patologiasuns.feature_sounds.domain.repository.Sounds
import kotlinx.coroutines.flow.Flow

//Definimos la interfaz que realiza el acceso a los datos (a la db)
@Dao
interface SoundsDao {
    @Query("SELECT * FROM $SOUNDS_TABLE ORDER BY id ASC")
    fun getSounds() : Flow<Sounds>

    @Insert(onConflict = IGNORE)
    fun addSound(sound: Sound)

    @Query("SELECT * FROM $SOUNDS_TABLE WHERE id = :id")
    fun getSound(id : Int) :Sound
}