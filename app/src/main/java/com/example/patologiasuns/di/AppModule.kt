package com.example.patologiasuns.di

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.example.patologiasuns.Constants.Companion.PATOLOGIAS_TABLE
import com.example.patologiasuns.Constants.Companion.SOUNDS_TABLE
import com.example.patologiasuns.Constants.Companion.STEPS_TABLE
import com.example.patologiasuns.feature_detalle.data.network.StepDB
import com.example.patologiasuns.feature_detalle.data.network.StepDao
import com.example.patologiasuns.feature_detalle.data.repository.StepRepositoryImpl
import com.example.patologiasuns.feature_detalle.domain.repository.StepRepository
import com.example.patologiasuns.feature_sounds.SoundManager
import com.example.patologiasuns.feature_sounds.data.network.SoundsDB
import com.example.patologiasuns.feature_sounds.data.network.SoundsDao
import com.example.patologiasuns.feature_sounds.data.repository.SoundsRepositoryImpl
import com.example.patologiasuns.feature_sounds.domain.repository.SoundsRepository
import com.example.patologiasuns.feature_user.data.network.PatologiaDB
import com.example.patologiasuns.feature_user.data.network.PatologiaDao
import com.example.patologiasuns.feature_user.data.repository.PatologiaRepositoryImpl
import com.example.patologiasuns.feature_user.domain.repository.PatologiaRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun providePatologiaDb(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context, PatologiaDB::class.java, PATOLOGIAS_TABLE
    ).build()

    @Provides
    fun providePatologiaDao(
        patologiaDB: PatologiaDB
    ) = patologiaDB.patologiaDao()

    @Provides
    fun providePatologiaRepository(
        patologiaDao: PatologiaDao
    ): PatologiaRepository = PatologiaRepositoryImpl(
        patologiaDao = patologiaDao
    )

    @Provides
    fun provideSoundDb(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context, SoundsDB::class.java, SOUNDS_TABLE
    ).allowMainThreadQueries().build()

    @Provides
    fun provideSoundsDao(
        soundsDB: SoundsDB
    ) = soundsDB.soundsDao()

    @Provides
    fun provideSoundRepository(
        soundsDao: SoundsDao
    ): SoundsRepository = SoundsRepositoryImpl(
        soundDao = soundsDao
    )

    @Provides
    fun provideSoundManager(
        soundsDao: SoundsDao
    ): SoundManager = SoundManager(
        repo =
        SoundsRepositoryImpl(soundDao = soundsDao)
    )

    @Provides
    fun provideStepsDb(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context, StepDB::class.java, STEPS_TABLE
    ).build()

    @Provides
    fun provideStepDao(
        stepDB: StepDB
    ) = stepDB.stepDao()

    @Provides
    fun provideStepRepository(
        stepDao: StepDao
    ): StepRepository = StepRepositoryImpl(
        stepDao = stepDao
    )
}