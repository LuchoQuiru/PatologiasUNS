package com.example.patologiasuns.feature_sounds.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.patologiasuns.Constants.Companion.SOUNDS_TABLE

@Entity (tableName = SOUNDS_TABLE)
data class Sound(
    @PrimaryKey (autoGenerate = true)
    val id : Int,
    val nombre : String,
    val path: String
)
