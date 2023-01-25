package com.example.patologiasuns.feature_detalle.domain.repository

import com.example.patologiasuns.feature_detalle.domain.model.Step
import kotlinx.coroutines.flow.Flow

typealias Steps = List<Step>

interface StepRepository {
    fun getStepsFromRoom() : Flow<Steps>
}