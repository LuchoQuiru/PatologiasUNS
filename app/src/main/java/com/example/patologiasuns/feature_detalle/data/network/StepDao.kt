package com.example.patologiasuns.feature_detalle.data.network

import androidx.room.Dao
import androidx.room.Query
import com.example.patologiasuns.Constants
import com.example.patologiasuns.feature_detalle.domain.model.Step
import com.example.patologiasuns.feature_detalle.domain.repository.Steps
import kotlinx.coroutines.flow.Flow

@Dao
interface StepDao {
    @Query("SELECT * FROM ${Constants.STEPS_TABLE} ORDER BY id ASC")
    fun getAllSteps() : Flow<Steps>
}

