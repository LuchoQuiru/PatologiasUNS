package com.example.patologiasuns.feature_user.presentation.mascotas

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun SettingScreen() {
    Column(modifier = Modifier.fillMaxSize())
    { Estructura() }
}

@Composable
private fun Estructura() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "Home!")
        val context = LocalContext.current
        FloatingActionButton(
            modifier = Modifier.align(Alignment.End),
            onClick = {
            Toast.makeText(
                context,
                "HI!",
                Toast.LENGTH_SHORT
            ).show()
        }) {
            Text(text = "+")
        }
    }
    Spacer(modifier = Modifier.padding(start = 10.dp))
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {

    }
}

@Composable
private fun BotonAgregar(modifier: Modifier) {

}