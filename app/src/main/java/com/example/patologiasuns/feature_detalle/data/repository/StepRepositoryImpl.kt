package com.example.patologiasuns.feature_detalle.data.repository

import com.example.patologiasuns.feature_detalle.data.network.StepDao
import com.example.patologiasuns.feature_detalle.domain.model.Step
import com.example.patologiasuns.feature_detalle.domain.repository.StepRepository
import com.example.patologiasuns.feature_detalle.domain.repository.Steps
import kotlinx.coroutines.flow.Flow

class StepRepositoryImpl(
    private val stepDao: StepDao
) : StepRepository {

    override fun getStepsFromRoom() = stepDao.getAllSteps()
}
