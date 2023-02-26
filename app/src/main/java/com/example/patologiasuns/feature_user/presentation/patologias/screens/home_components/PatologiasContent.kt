package com.example.patologiasuns.feature_user.presentation.patologias.components

import android.content.Intent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import com.example.patologiasuns.feature_detalle.DetalleActivity
import com.example.patologiasuns.feature_user.domain.repository.PatologiasWithSteps


@Composable
fun PatologiasContent(
    padding: PaddingValues,
    patologiasWithSteps: PatologiasWithSteps,
    navController: NavController
) {
    val context = LocalContext.current
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ) {
        items(patologiasWithSteps) { patologiaWithStep ->
            patologiaWithStep.patologia?.let {
                patologiaWithStep.steps?.let { it1 ->
                    PatologiasCard(
                        patologia = it,
                        onItemClicked = { p ->
                            //navController.navigate("detalles/${p.id}/${p.nombre}")
                            val myIntent = Intent(context, DetalleActivity::class.java)
                            myIntent.putExtra("id",1) //Optional parameters
                            context.startActivity(myIntent)
                        })
                }
            }
        }
        item {
            Spacer(modifier = Modifier.padding(50.dp))
        }
    }
}