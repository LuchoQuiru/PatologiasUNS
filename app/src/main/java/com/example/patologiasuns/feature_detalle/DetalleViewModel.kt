package com.example.patologiasuns.feature_detalle

import android.bluetooth.BluetoothAdapter
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import androidx.compose.runtime.mutableStateOf
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.patologiasuns.feature_sounds.SoundManager
import com.example.patologiasuns.feature_user.domain.model.PatologiaWithStep
import com.example.patologiasuns.feature_user.domain.repository.PatologiaRepository
import com.example.patologiasuns.feature_user.domain.repository.PatologiasWithSteps
import com.example.patologiasuns.utils.Utils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope.coroutineContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class DetalleViewModel @Inject constructor(
    private val repo: PatologiaRepository,
    private val soundManager: SoundManager
) : ViewModel() {

    //var patologiaWithSteps = repo.patologiaWithStepsById(1)

    var patologiaWithSteps: Flow<PatologiaWithStep> = repo.patologiaWithStepsById(1)

    fun reproducirSonido(context: Context, patologia_id: Int) {
        val id = Utils.resIdByName(
            context,
            //soundManager.getNameSound(patologia_id),
            "cheques",
            "raw"
        )
        val mp = MediaPlayer.create(
            context,
            id
        )
        mp.start()
    }

    ////////////////////////////////////////////


}

