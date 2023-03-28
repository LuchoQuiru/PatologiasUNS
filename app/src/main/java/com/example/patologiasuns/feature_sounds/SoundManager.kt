package com.example.patologiasuns.feature_sounds

import com.example.patologiasuns.feature_sounds.domain.model.Sound
import com.example.patologiasuns.feature_sounds.domain.repository.Sounds
import com.example.patologiasuns.feature_sounds.domain.repository.SoundsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SoundManager @Inject constructor(
    private val repo: SoundsRepository
){

    fun getNameSound(id: Int): String {
        return repo.getSoundFromRoomById(id).nombre
    }

    fun getAllSounds(): Flow<Sounds> {
        return repo.getSoundsFromRoom()
    }
}