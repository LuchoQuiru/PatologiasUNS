package com.example.patologiasuns.feature_detalle

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.example.patologiasuns.feature_detalle.bluetooth.BluetoothClient
import com.example.patologiasuns.feature_detalle.bluetooth.BluetoothServer
import com.example.patologiasuns.feature_detalle.bluetooth.BluetoothServerController
import com.example.patologiasuns.ui.theme.PeopleAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetalleActivity : ComponentActivity() {
    public lateinit var bluetoothAdapter: BluetoothAdapter
    lateinit var bluetoothManager: BluetoothManager
    lateinit var takePermission: ActivityResultLauncher<String>
    lateinit var takeResultLauncher: ActivityResultLauncher<Intent>

    val NOT_SUPPORTED = "Bluetooth no esta soportado en este dispositivo"
    val SUPPORTED = "Bluetooth is soportado correctamente!"
    val BLUETOOTH_ON = "Bluetooth esta encendido!"
    val BLUETOOTH_OFF = "Bluetooth esta apagado"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBluetooth()
        //val bluetoothServer = BluetoothServerController(this).start()
        //val bluetoothCleint = BluetoothClient()
        setContent {
            PeopleAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    DetalleScreen(id = 1, takePermission = takePermission)
                    //DetalleScreen(id = 1)
                }
            }
        }
    }

    fun initBluetooth(){
        getBluetoothAdapter()
        takePermission()
        //checkIfBluetoothIsSupported()
        if (bluetoothAdapter?.isEnabled == false) {

        }
    }

    fun getBluetoothAdapter(){
        bluetoothManager = getSystemService(BLUETOOTH_SERVICE) as BluetoothManager
        bluetoothAdapter = bluetoothManager.adapter
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

    fun checkIfBluetoothIsSupported(){
        if(bluetoothAdapter == null)
            Toast.makeText(this,NOT_SUPPORTED,Toast.LENGTH_LONG).show()
        else
            Toast.makeText(this,SUPPORTED,Toast.LENGTH_LONG).show()
    }


}






