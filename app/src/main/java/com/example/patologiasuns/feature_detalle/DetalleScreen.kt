package com.example.patologiasuns.feature_detalle


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.patologiasuns.feature_detalle.domain.model.Step
import com.example.patologiasuns.feature_detalle.presentation.components.*
import com.example.patologiasuns.feature_user.domain.model.Patologia

@Composable
fun DetalleScreen(id : Int , nombre:  String){
    val pasos = listOf<Step>(
        Step(1,"Recostar al paciente","0"),
        Step(2,"Medir la centimetra","0"),
        Step(3,"Hacer toser","0"),
        Step(4,"Revisar craculinguis","0"),
    )

    LazyColumn {
        item {
            TopBar()
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.padding(start = 15.dp, end = 15.dp)
            ){
                BotonReproduccion()
            }
            Spacer(modifier = Modifier.height(8.dp))
        }

        items(pasos) {
            pasos.forEach {
                StepCard(it)
            }
        }

        item{
            Spacer(modifier = Modifier.padding(bottom = 300.dp))
        }
    }
}





