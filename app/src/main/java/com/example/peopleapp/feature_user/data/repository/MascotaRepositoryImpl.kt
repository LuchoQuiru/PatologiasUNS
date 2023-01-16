package com.example.peopleapp.feature_user.data.repository

import com.example.peopleapp.feature_user.data.network.MascotaDao
import com.example.peopleapp.feature_user.domain.model.Mascota
import com.example.peopleapp.feature_user.domain.repository.MascotaRepository
import com.example.peopleapp.feature_user.domain.repository.Mascotas
import kotlinx.coroutines.flow.Flow


class MascotaRepositoryImpl(
    private val mascotaDao: MascotaDao
) : MascotaRepository {

    override fun getMascotasFromRoom() = mascotaDao.getMascotas()
    override fun addMascotasToRoom(mascota: Mascota) = mascotaDao.addMascota(mascota)

}