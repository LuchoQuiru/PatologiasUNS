package com.example.patologiasuns.feature_user.domain.model

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.patologiasuns.Constants.Companion.STEPS_TABLE

@Entity (tableName = STEPS_TABLE)
data class Step(
    @PrimaryKey (autoGenerate = true)
    val id : Int,
    val patologia_id : Int,
    val detalle : String,
)
