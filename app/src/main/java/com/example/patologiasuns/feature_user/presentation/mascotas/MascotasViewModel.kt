package com.example.patologiasuns.feature_user.presentation.mascotas

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.patologiasuns.feature_user.domain.model.Mascota
import com.example.patologiasuns.feature_user.domain.repository.MascotaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/*
El viewmodel es el elemento que maneja la comunicacion entre la vista y el modelo o la base de datos.
Tambien en el, escribimos todos los eventos que realizan cambios en la interfaz de usuario.
*/

@HiltViewModel
class MascotasViewModel @Inject constructor(
    private val repo : MascotaRepository
): ViewModel() {
    var openDialog by mutableStateOf(false)
    val mascotas = repo.getMascotasFromRoom()

    fun addMascota(mascota : Mascota) = viewModelScope.launch(Dispatchers.IO){
        repo.addMascotasToRoom(mascota)
    }

    fun openDialog(){
        openDialog = true
    }

    fun closeDialog(){
        openDialog = false
    }

    fun cant_mascotas(){

    }
}