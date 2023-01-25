package com.example.patologiasuns.feature_user.domain.repository

import com.example.patologiasuns.feature_user.domain.model.Patologia
import kotlinx.coroutines.flow.Flow

typealias Patologias = List<Patologia>

interface PatologiaRepository {
    fun getPatologiasFromRoom() : Flow<Patologias>
    fun addPatologiaToRoom(patologia : Patologia)

}