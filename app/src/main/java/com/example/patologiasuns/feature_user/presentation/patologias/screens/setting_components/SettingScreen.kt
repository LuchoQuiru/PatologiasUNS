package com.example.patologiasuns.feature_user.presentation.patologias

import android.content.Context
import android.media.MediaPlayer
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import androidx.hilt.navigation.compose.hiltViewModel
import com.example.patologiasuns.feature_sounds.SoundManager
import com.example.patologiasuns.feature_sounds.domain.model.Sound
import com.example.patologiasuns.feature_user.PatologiasViewModel

import com.example.patologiasuns.feature_user.presentation.patologias.components.AddMascotaAlertDialog
import com.example.patologiasuns.feature_user.presentation.patologias.components.AddMascotaFloatingActionButton
@Composable
fun SettingScreen(
    viewModel: PatologiasViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Botonera()
    }
}
@Preview
@Composable
fun Botonera() {
    Column(
        modifier = Modifier.width(300.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            OutlinedButton(
                onClick = { },
                modifier = Modifier
                    .width(200.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color(0xFFAB47BC)
                )
            ) {
                Text("TURN ON")
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            OutlinedButton(
                onClick = { },
                modifier = Modifier
                    .width(200.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color(0xFFAB47BC)
                )
            ) {
                Text("TURN OFF")
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            OutlinedButton(
                onClick = { },
                modifier = Modifier
                    .width(200.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color(0xFFAB47BC)
                )
            ) {
                Text("DISCOVERABLE")
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            OutlinedButton(
                onClick = { },
                modifier = Modifier
                    .width(200.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color(0xFFAB47BC)
                )
            ) {
                Text("GET PAIRED DEVICES")
            }
        }

    }
}


/*AddMascotaFloatingActionButton(
openDialog = {
    viewModel.openDialog()
})

AddMascotaAlertDialog(
openDialog = viewModel.openDialog,
closeDialog = { viewModel.closeDialog() },
addPatologia = { patologia ->
    viewModel.addPatologia(patologia)
}
)*/



