package com.example.patologiasuns.feature_detalle

import android.content.Context
import android.media.MediaPlayer
import androidx.lifecycle.ViewModel
import com.example.patologiasuns.feature_detalle.domain.repository.StepRepository
import com.example.patologiasuns.feature_sounds.SoundManager
import com.example.patologiasuns.feature_user.domain.repository.PatologiaRepository
import com.example.patologiasuns.utils.Utils
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetalleViewModel @Inject constructor(
    private val repo: StepRepository,
    private val soundManager: SoundManager
) : ViewModel() {

    val steps = repo.getStepsFromRoom()

    fun reproducirSonido(context: Context, patologia_id: Int) {
        val id = Utils.resIdByName(
            context,
            soundManager.getNameSound(patologia_id),
            "raw"
        )
        val mp = MediaPlayer.create(
            context,
            id
        )
        mp.start()
    }
}
