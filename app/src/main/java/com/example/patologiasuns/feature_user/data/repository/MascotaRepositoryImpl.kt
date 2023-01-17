package com.example.patologiasuns.feature_user.data.repository

import com.example.patologiasuns.feature_user.data.network.MascotaDao
import com.example.patologiasuns.feature_user.domain.model.Mascota
import com.example.patologiasuns.feature_user.domain.repository.MascotaRepository


class MascotaRepositoryImpl(
    private val mascotaDao: MascotaDao
) : MascotaRepository {

    override fun getMascotasFromRoom() = mascotaDao.getMascotas()
    override fun addMascotasToRoom(mascota: Mascota) = mascotaDao.addMascota(mascota)

}