package com.example.peopleapp.di

import android.content.Context
import androidx.room.Room
import com.example.peopleapp.Constants.Companion.MASCOTA_TABLE
import com.example.peopleapp.feature_user.data.network.MascotaDB
import com.example.peopleapp.feature_user.data.network.MascotaDao
import com.example.peopleapp.feature_user.data.repository.MascotaRepositoryImpl
import com.example.peopleapp.feature_user.domain.repository.MascotaRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideMascotaDb(
        @ApplicationContext
        context: Context
    ) = Room.databaseBuilder(
        context,
        MascotaDB::class.java,
        MASCOTA_TABLE
    ).build()

    @Provides
    fun provideMascotaDao(
        mascotaDB: MascotaDB
    ) = mascotaDB.mascotaDao()

    @Provides
    fun provideMascotaRepository(
        mascotaDao : MascotaDao
    ) : MascotaRepository = MascotaRepositoryImpl(
        mascotaDao = mascotaDao
    )
}