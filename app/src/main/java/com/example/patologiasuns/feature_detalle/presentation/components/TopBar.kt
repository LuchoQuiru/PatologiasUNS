package com.example.patologiasuns.feature_detalle.presentation.components

import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.patologiasuns.feature_detalle.DetalleViewModel
import com.example.patologiasuns.feature_detalle.bluetooth.BluetoothViewModel
import com.example.patologiasuns.ui.theme.PeopleAppTheme
import com.example.patologiasuns.utils.Utils
import com.example.peopleapp.R
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

/*@Preview
@Composable
fun t() {
    PeopleAppTheme{
        TopBar(nombre_patologia = "PATOLOGIA TEST", { } )
    }
}*/

@Composable
fun TopBar(
    nombre_patologia: String,
    fn_boton_bluetooth : () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxHeight()
                .padding(start = 10.dp)
        ){
            Text(
                text = nombre_patologia,
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.surface
            )
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxHeight()
                .padding(end = 10.dp)
        ) {
            Image(
                modifier = Modifier
                    .clickable {
                        fn_boton_bluetooth()
                    }
                    .size(25.dp, 25.dp)
                    .clip(RoundedCornerShape(6.dp)),
                painter = painterResource(bluetoothIcon()),
                alignment = Alignment.BottomEnd,
                contentDescription = "",
                contentScale = ContentScale.Crop,
            )
        }
    }
}

@Composable
fun bluetoothIcon(
    bluetoothViewModel: BluetoothViewModel = hiltViewModel()
): Int {
    val context = LocalContext.current
    val bluetoothConnection by bluetoothViewModel.connection
    Log.e("TAG","BUENAS TARDES!")
    if(bluetoothConnection)
        return Utils.getBluetoothConnected(context)
    return Utils.getBluetoothDisconnected(context)

}
