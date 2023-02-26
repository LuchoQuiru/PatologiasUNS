package com.example.patologiasuns.feature_user.domain.repository

import androidx.lifecycle.LiveData
import com.example.patologiasuns.feature_detalle.domain.repository.Steps
import com.example.patologiasuns.feature_user.domain.model.Patologia
import com.example.patologiasuns.feature_user.domain.model.PatologiaWithStep
import kotlinx.coroutines.flow.Flow

typealias Patologias = List<Patologia>
typealias PatologiasWithSteps = List<PatologiaWithStep>

interface PatologiaRepository {
    fun getPatologiasFromRoom() : Flow<Patologias>
    fun addPatologiaToRoom(patologia : Patologia)
    //fun getStepsById(id : Int) : Flow<Steps>
    fun patologiasWithSteps() : Flow<PatologiasWithSteps>



    fun patologiaWithStepsById(id : Int) : Flow<PatologiaWithStep>


}