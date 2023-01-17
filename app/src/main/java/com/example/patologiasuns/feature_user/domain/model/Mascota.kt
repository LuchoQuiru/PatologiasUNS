package com.example.patologiasuns.feature_user.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.patologiasuns.Constants.Companion.MASCOTA_TABLE

@Entity (tableName = MASCOTA_TABLE  ,)
data class Mascota(
    @PrimaryKey (autoGenerate = true)
    val id : Int,
    val animal : String,
    val raza : String
)
