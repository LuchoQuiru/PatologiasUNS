package com.example.patologiasuns.feature_sounds.domain.repository

import com.example.patologiasuns.feature_sounds.domain.model.Sound
import kotlinx.coroutines.flow.Flow

typealias Sounds = List<Sound>

interface SoundsRepository {
    fun getSoundsFromRoom() : Flow<Sounds>
    fun addSooundToRoom(sound : Sound)
    fun getSoundFromRoomById(id : Int) : Sound
}
