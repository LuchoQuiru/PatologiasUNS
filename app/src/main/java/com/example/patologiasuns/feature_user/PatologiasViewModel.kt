package com.example.patologiasuns.feature_user

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.patologiasuns.feature_user.domain.model.Patologia
import com.example.patologiasuns.feature_user.domain.repository.PatologiaRepository
import com.example.patologiasuns.feature_user.domain.repository.PatologiasWithSteps
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/*
El viewmodel es el elemento que maneja la comunicacion entre la vista y el modelo o la base de datos.
Tambien en el, escribimos todos los eventos que realizan cambios en la interfaz de usuario.
*/
@HiltViewModel
class PatologiasViewModel @Inject constructor(
    private val repo: PatologiaRepository
) : ViewModel() {

    var openDialog by mutableStateOf(false)

    //val patologias = repo.getPatologiasFromRoom()
    val patologias = repo.patologiasWithSteps()

    fun addPatologia(patologia: Patologia) = viewModelScope.launch(Dispatchers.IO) {
        repo.addPatologiaToRoom(patologia)
    }

    fun openDialog() {
        /*openDialog = true*/
    }

    fun closeDialog() {
        openDialog = false
    }

    ////////////


}


