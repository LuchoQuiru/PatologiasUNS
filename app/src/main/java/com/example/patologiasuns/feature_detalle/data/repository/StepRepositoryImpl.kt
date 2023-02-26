package com.example.patologiasuns.feature_detalle.data.repository

import com.example.patologiasuns.feature_detalle.data.network.StepDao
import com.example.patologiasuns.feature_detalle.domain.repository.StepRepository

class StepRepositoryImpl(
    private val stepDao: StepDao
) : StepRepository {

    override fun getStepsFromRoom() = stepDao.getAllSteps()
}
