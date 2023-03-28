package com.example.patologiasuns.feature_detalle

import android.app.Application
import android.content.Context
import android.media.MediaPlayer
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.patologiasuns.feature_detalle.bluetooth.BluetoothViewModel
import com.example.patologiasuns.feature_detalle.bluetooth.MyBluetoothService
import com.example.patologiasuns.feature_sounds.SoundManager
import com.example.patologiasuns.feature_sounds.domain.repository.Sounds
import com.example.patologiasuns.feature_user.domain.model.PatologiaWithStep
import com.example.patologiasuns.feature_user.domain.repository.PatologiaRepository
import com.example.patologiasuns.utils.Utils
import dagger.hilt.android.internal.Contexts.getApplication
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class DetalleViewModel @Inject constructor(
    private val repo: PatologiaRepository,
    private val soundManager: SoundManager,
    private val myBluetoothService: MyBluetoothService
) : ViewModel() {

    var patologiaWithSteps: Flow<PatologiaWithStep> = repo.patologiaWithStepsById(1)
    var sonidos: Flow<Sounds> = soundManager.getAllSounds()
    var mp: MediaPlayer? = null
    var sonidoReproduciendoseActualmente = mutableStateOf(false)

    val charRecibido = myBluetoothService.char

    init{
        myBluetoothService.char.observeForever {
            Log.e("TAGS", "Recibi un dato: " + charRecibido.value)
        }
    }

    fun reproducirSonido(context: Context, patologia_id: Int) {
        val id = Utils.resIdByName(
            context,
            //soundManager.getNameSound(patologia_id),
            "cheques",
            "raw"
        )
        mp?.let {
            if (mp!!.isPlaying())
                mp!!.stop()
        }
        mp = MediaPlayer.create(context, id)
        sonidoReproduciendoseActualmente.value = true
        mp!!.start()
        mp?.setOnCompletionListener {
            sonidoReproduciendoseActualmente.value = false
        }
    }

    fun escribirPorConsola() {
        Log.e("Debugeando!", "llegue hasta aca : " + charRecibido)
    }



}

