package com.example.patologiasuns.feature_detalle.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.example.patologiasuns.feature_user.domain.model.Step

/*@Preview
@Composable
fun test() {
    val step = Step(
        1,
        1,
        "Paso 1 para hacer"
        //"El ántrax (o carbunco) es una enfermedad infecciosa grave causada por una bacteria grampositiva y baciliforme conocida como Bacillus anthracis."
    )
    StepCard(
        step
    )
}*/

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
            Column(
                modifier = Modifier
                    //.background(Color.Red)
                    .align(Alignment.CenterVertically),
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier
                        .padding(5.dp)
                        .size(80.dp, 80.dp)
                        .clip(RoundedCornerShape(6.dp)),
                    painter = image,
                    alignment = Alignment.CenterStart,
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .width(200.dp)
            ) {
                Text(
                    text = step.detalle,
                    modifier = Modifier.padding(5.dp, 0.dp, 12.dp, 0.dp),
                    color = Color(0xFF282828),
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.subtitle1
                )
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = step.detalle,
                    modifier = Modifier.padding(10.dp, 0.dp, 12.dp, 0.dp),
                    color = Color(0xFF282828),
                    style = MaterialTheme.typography.caption
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.height(100.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center
                ) {
                    val checked = remember { mutableStateOf(false) }
                    Checkbox(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        checked = checked.value,
                        onCheckedChange = { checked.value = it },
                        colors =
                        CheckboxDefaults.colors(
                            checkedColor = Color(0xFF5D6D7E),
                            uncheckedColor = Color(0xFFD6DBDF)
                        )
                    )
                }
            }
        }
    }
}