package com.example.patologiasuns.feature_detalle.data.network

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.patologiasuns.feature_user.domain.model.Step

@Database(entities = [Step::class], version = 1, exportSchema = false)

abstract class StepDB: RoomDatabase() {
    abstract fun stepDao() : StepDao
}