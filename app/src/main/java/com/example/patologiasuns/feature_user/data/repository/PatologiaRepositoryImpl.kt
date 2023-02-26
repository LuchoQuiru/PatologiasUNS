package com.example.patologiasuns.feature_user.data.repository

import androidx.lifecycle.LiveData
import com.example.patologiasuns.feature_user.data.network.PatologiaDao
import com.example.patologiasuns.feature_user.domain.model.Patologia
import com.example.patologiasuns.feature_user.domain.model.PatologiaWithStep
import com.example.patologiasuns.feature_user.domain.repository.PatologiaRepository
import com.example.patologiasuns.feature_user.domain.repository.PatologiasWithSteps
import kotlinx.coroutines.flow.Flow


class PatologiaRepositoryImpl(
    private val patologiaDao: PatologiaDao
) : PatologiaRepository {

    override fun getPatologiasFromRoom() = patologiaDao.getPatologias()
    override fun addPatologiaToRoom(patologia: Patologia) = patologiaDao.addPatologia(patologia)
    //override fun getStepsById(id: Int) = patologiaDao.getStepsById(id)
    override fun patologiasWithSteps() = patologiaDao.test()

    override fun patologiaWithStepsById(id: Int): Flow<PatologiaWithStep> =
        patologiaDao.getPatologiaWithStepsById(id)
}