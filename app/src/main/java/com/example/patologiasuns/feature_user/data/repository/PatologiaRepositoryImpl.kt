package com.example.patologiasuns.feature_user.data.repository

import com.example.patologiasuns.feature_user.data.network.PatologiaDao
import com.example.patologiasuns.feature_user.domain.model.Patologia
import com.example.patologiasuns.feature_user.domain.repository.PatologiaRepository


class PatologiaRepositoryImpl(
    private val patologiaDao: PatologiaDao
) : PatologiaRepository {

    override fun getPatologiasFromRoom() = patologiaDao.getPatologias()
    override fun addPatologiaToRoom(patologia: Patologia) = patologiaDao.addPatologia(patologia)

}