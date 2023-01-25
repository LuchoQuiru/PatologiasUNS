package com.example.patologiasuns.feature_user.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.patologiasuns.Constants.Companion.PATOLOGIAS_TABLE

@Entity (tableName = PATOLOGIAS_TABLE  ,)
data class Patologia(
    @PrimaryKey (autoGenerate = true)
    val id : Int,
    val nombre : String,
    val detalles: String
)
