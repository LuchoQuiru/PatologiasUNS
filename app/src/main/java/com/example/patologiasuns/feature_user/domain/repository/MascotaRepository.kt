package com.example.patologiasuns.feature_user.domain.repository

import com.example.patologiasuns.feature_user.domain.model.Mascota
import kotlinx.coroutines.flow.Flow

typealias Mascotas = List<Mascota>

interface MascotaRepository {
    fun getMascotasFromRoom() : Flow<Mascotas>
    fun addMascotasToRoom(mascota : Mascota)

}