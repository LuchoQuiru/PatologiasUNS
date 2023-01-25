package com.example.patologiasuns.feature_sounds

import com.example.patologiasuns.feature_sounds.domain.repository.SoundsRepository
import javax.inject.Inject

class SoundManager @Inject constructor(
    private val repo: SoundsRepository
){

    fun getNameSound(id: Int): String {
        return repo.getSoundFromRoomById(id).nombre
    }
}