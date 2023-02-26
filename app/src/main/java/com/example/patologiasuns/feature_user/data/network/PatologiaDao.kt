package com.example.patologiasuns.feature_user.data.network

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE

import androidx.room.Query
import androidx.room.Transaction
import com.example.patologiasuns.Constants.Companion.PATOLOGIAS_TABLE
import com.example.patologiasuns.Constants.Companion.STEPS_TABLE
import com.example.patologiasuns.feature_detalle.domain.repository.Steps
import com.example.patologiasuns.feature_user.domain.model.Patologia
import com.example.patologiasuns.feature_user.domain.model.PatologiaWithStep
import com.example.patologiasuns.feature_user.domain.repository.Patologias
import com.example.patologiasuns.feature_user.domain.repository.PatologiasWithSteps
import kotlinx.coroutines.flow.Flow

//Definimos la interfaz que realiza el acceso a los datos (a la db)
@Dao
interface PatologiaDao {
    @Query("SELECT * FROM $PATOLOGIAS_TABLE ORDER BY id ASC")
    fun getPatologias() : Flow<Patologias>

    @Insert(onConflict = IGNORE)
    fun addPatologia(patologia : Patologia)

    @Transaction
    @Query("SELECT * FROM $PATOLOGIAS_TABLE")
    fun test() : Flow<PatologiasWithSteps>

    @Query("SELECT * FROM $PATOLOGIAS_TABLE WHERE id = :id")
    fun getPatologiaWithStepsById( id : Int) : Flow<PatologiaWithStep>

}