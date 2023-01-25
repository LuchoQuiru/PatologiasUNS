package com.example.patologiasuns.feature_detalle.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.patologiasuns.Constants.Companion.STEPS_TABLE

@Entity (tableName = STEPS_TABLE)
data class Step(
    @PrimaryKey (autoGenerate = true)
    val id : Int,
    val detalle : String,
    val id_patologia: String
)
