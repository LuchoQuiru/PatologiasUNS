package com.example.patologiasuns.feature_detalle

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.bluetooth.BluetoothSocket
import android.content.Intent
import android.net.wifi.p2p.WifiP2pManager.ActionListener
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.patologiasuns.feature_detalle.bluetooth.BluetoothViewModel
import com.example.patologiasuns.ui.theme.PeopleAppTheme
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class DetalleActivity : ComponentActivity() {
    val NOT_SUPPORTED = "Bluetooth no esta soportado en este dispositivo"
    val SUPPORTED = "Bluetooth is soportado correctamente!"
    val BLUETOOTH_ON = "Bluetooth esta encendido!"
    val BLUETOOTH_OFF = "Bluetooth esta apagado"
    lateinit var takePermission: ActivityResultLauncher<String>
    lateinit var takeResultLauncher: ActivityResultLauncher<Intent>
    private val bluetoothViewModel by viewModels<BluetoothViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        iniciarPermisosParaConectarBluetooth()
        setContent {
            PeopleAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    DetalleScreen(id = 1, fn_boton_bluetooth = {conectarODesconectarBluetooth()})
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if(bluetoothViewModel.connection.value)
            desconectarBluetooth()
    }

    private fun conectarODesconectarBluetooth(){
        if(bluetoothViewModel.connection.value)
            desconectarBluetooth()
        else
            conectarBluetoothYEmpezarTransmisionDeDatos()
    }

    private fun desconectarBluetooth() {
        bluetoothViewModel.desconectarBluetooth()
    }

    fun conectarBluetoothYEmpezarTransmisionDeDatos(){
        bluetoothViewModel.initConnection()
        bluetoothViewModel.conectarConArduino()
    }

    private fun iniciarPermisosParaConectarBluetooth(){
        takePermission()
        takePermission.launch(android.Manifest.permission.BLUETOOTH_CONNECT)
    }

    fun takePermission(){
        takePermission = registerForActivityResult(ActivityResultContracts.RequestPermission()){
            if(it) {
                val intent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
                takeResultLauncher.launch(intent)
            }
            else
                Toast.makeText(this,NOT_SUPPORTED,Toast.LENGTH_LONG).show()
        }
        takeResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK)
                Toast.makeText(this, BLUETOOTH_ON, Toast.LENGTH_LONG).show()
            else
                Toast.makeText(this, BLUETOOTH_OFF, Toast.LENGTH_LONG).show()
        }
    }




}






