package com.example.patologiasuns.feature_detalle.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.patologiasuns.feature_detalle.domain.model.Step
import com.example.patologiasuns.feature_user.domain.model.Patologia
import com.example.patologiasuns.feature_user.presentation.patologias.components.PatologiasCard

@Preview
@Composable
fun test() {
    val step = Step(1, "Patologia de prueba","1")
    StepCard(
        step)
}

@Composable
fun StepCard(step: Step) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp)),
        elevation = 0.dp,
        backgroundColor = Color(0xFFF5F5F5)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            val image: Painter =
                painterResource(id = com.example.peopleapp.R.drawable.estetoscopio)
            Image(
                modifier = Modifier
                    .size(80.dp, 80.dp)
                    .clip(RoundedCornerShape(6.dp)),
                painter = image,
                alignment = Alignment.CenterStart,
                contentDescription = "",
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                Text(
                    text = step.detalle,
                    modifier = Modifier.padding(12.dp, 0.dp, 12.dp, 0.dp),
                    color = Color(0xFF282828),
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.subtitle1
                )
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = step.detalle,
                    modifier = Modifier.padding(16.dp, 0.dp, 12.dp, 0.dp),
                    color = Color(0xFF282828),
                    style = MaterialTheme.typography.caption
                )
            }
        }
    }
}