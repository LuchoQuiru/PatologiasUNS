package com.example.patologiasuns.feature_detalle.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.patologiasuns.feature_detalle.DetalleViewModel
import androidx.compose.foundation.clickable
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color

@Composable
fun DetallesContent(
    viewModel: DetalleViewModel = hiltViewModel(),
    fn_boton_bluetooth : () -> Unit
) {
    val patologiaWithStep by viewModel.patologiaWithSteps.collectAsState(null)
    LazyColumn {
        item {
            patologiaWithStep?.patologia?.let { TopBar(it.nombre, fn_boton_bluetooth) }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(start = 15.dp, end = 15.dp)
            ){
                //barDropDownYPlay()
                PlayButton()
            }
            Spacer(modifier = Modifier.height(25.dp))
        }

        patologiaWithStep?.let{
            items(patologiaWithStep?.steps!!) { step ->
                StepCard(step)
            }
        }


        item{
            Spacer(modifier = Modifier.padding(bottom = 300.dp))
        }
    }
}

@Preview
@Composable
fun barDropDownYPlay() {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .padding(5.dp)
            .background(Color.Red),
    ) {
        EnabledButton()
    }
    Column(
        modifier = Modifier
            .padding(end = 10.dp)
            .background(Color.Green),
        horizontalAlignment = Alignment.End
    ) {
        /*Text(text = "Nombre del sonido",)
        Spacer(modifier = Modifier.padding(top = 5.dp))
        Text(text = "Bluetooth RFID detected")*/
        dropDownConSonidos()
    }
}
@Composable
fun dropDownConSonidos(

){
    //val sonidos by viewModel.sonidos.collectAsState(null)
    val list = listOf<String>("Kotlin","JAVA" , "Phyton")
    var mExpanded by remember { mutableStateOf(false) }
    var mSelectedText by remember { mutableStateOf("") }
    var mTextFieldSize by remember { mutableStateOf(Size.Zero)}

    // Up Icon when expanded and down icon when collapsed
    val icon = if (mExpanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    Row(

    ){
        OutlinedTextField(
            value = mSelectedText,
            onValueChange = { mSelectedText = it },
            /*modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    // This value is used to assign to
                    // the DropDown the same width
                    mTextFieldSize = Size
                },*/
            label = {Text("Label")},
            trailingIcon = {
                Icon(icon,"contentDescription",
                    Modifier.clickable { mExpanded = !mExpanded })
            }
        )

        // Create a drop-down menu with list of cities,
        // when clicked, set the Text Field text as the city selected
        DropdownMenu(
            expanded = mExpanded,
            onDismissRequest = { mExpanded = false },
            modifier = Modifier
                .width(100.dp)
        ) {
            list.forEach { item ->
                DropdownMenuItem(onClick = {
                    mSelectedText = item
                    mExpanded = false
                }) {
                    Text(text = item)
                }
            }
        }
    }
}

