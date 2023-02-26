package com.example.patologiasuns.feature_user.presentation.patologias.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.patologiasuns.feature_detalle.domain.repository.Steps
import com.example.patologiasuns.feature_user.PatologiasViewModel
import com.example.patologiasuns.feature_user.domain.model.Patologia
import com.example.patologiasuns.utils.Utils
import com.example.peopleapp.R

/*@Preview
@Composable
fun test() {
    val patologia = Patologia(1, "Patologia de prueba", "Only a test")
    PatologiasCard(
        patologia = patologia,
        onItemClicked = { })
}*/

@Composable
fun PatologiasCard(
    patologia: Patologia,
    onItemClicked: (patologia: Patologia) -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .padding(
                start = 8.dp,
                end = 8.dp,
                top = 4.dp,
                bottom = 4.dp
            )
            .fillMaxWidth()
            .clickable(
                onClick = {
                    onItemClicked(patologia)
                }),
        elevation = 3.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(20.dp)
            ){
                val context = LocalContext.current
                val image = painterResource(id = Utils.getVirusImageWithAzar(context))
                Image(
                    modifier = Modifier
                        .size(60.dp, 60.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    painter = image,
                    alignment = Alignment.CenterStart,
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = patologia.id.toString())
                Text(
                    text = patologia.nombre,
                    style = MaterialTheme.typography.h5,
                )
                Text(text = patologia.detalles)
            }
        }
    }
}

