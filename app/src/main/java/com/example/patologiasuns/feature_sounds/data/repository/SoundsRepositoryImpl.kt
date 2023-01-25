package com.example.patologiasuns.feature_sounds.data.repository

import com.example.patologiasuns.feature_sounds.data.network.SoundsDao
import com.example.patologiasuns.feature_sounds.domain.model.Sound
import com.example.patologiasuns.feature_sounds.domain.repository.SoundsRepository


class SoundsRepositoryImpl(
    private val soundDao: SoundsDao
) : SoundsRepository {

    override fun getSoundsFromRoom() = soundDao.getSounds()
    override fun addSooundToRoom(sound: Sound) = soundDao.addSound(sound)
    override fun getSoundFromRoomById(id: Int): Sound = soundDao.getSound(id = id)

}