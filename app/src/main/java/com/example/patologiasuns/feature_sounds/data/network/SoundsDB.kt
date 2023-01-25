package com.example.patologiasuns.feature_sounds.data.network

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.patologiasuns.feature_sounds.domain.model.Sound

@Database(entities = [Sound::class], version = 1, exportSchema = false)
abstract class SoundsDB: RoomDatabase(){
    abstract fun soundsDao() : SoundsDao
}


