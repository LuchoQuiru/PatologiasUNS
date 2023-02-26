package com.example.patologiasuns.feature_detalle.presentation.components

import androidx.activity.result.ActivityResultLauncher
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.patologiasuns.feature_detalle.domain.repository.Steps
import com.example.patologiasuns.feature_user.domain.model.PatologiaWithStep
import com.example.patologiasuns.feature_user.domain.model.Step

@Composable
fun DetallesContent(
    patologiaWithStep: PatologiaWithStep,
    takePermission: ActivityResultLauncher<String>
) {
    LazyColumn {
        item {
            patologiaWithStep.patologia?.let { TopBar(it.nombre, takePermission) }
            //patologiaWithStep.patologia?.let { TopBar(it.nombre) }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                //horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, end = 15.dp)
            ){
                Column(
                    horizontalAlignment = Alignment.Start
                ) {
                    BotonReproduccion()
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(end = 10.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    Text(text = "Nombre del sonido",)
                    Spacer(modifier = Modifier.padding(top = 5.dp))
                    Text(text = "Bluetooth RFID detected")
                }
            }
            Spacer(modifier = Modifier.height(25.dp))
        }

        items(patologiaWithStep.steps!!) { step ->
                StepCard(step)
        }

        item{
            Spacer(modifier = Modifier.padding(bottom = 300.dp))
        }
    }
}
