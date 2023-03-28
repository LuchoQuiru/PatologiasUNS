package com.example.patologiasuns.feature_detalle.bluetooth

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import kotlinx.coroutines.*
import java.util.*
import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothManager
import android.bluetooth.BluetoothSocket
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResultLauncher
import androidx.compose.runtime.mutableStateOf
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.patologiasuns.feature_detalle.DetalleViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException
import java.io.InputStream
import java.lang.Thread.sleep
import javax.inject.Inject

@HiltViewModel
class BluetoothViewModel @Inject constructor(
    @ApplicationContext private val mContext : Context,
    private val myBluetoothService: MyBluetoothService
) : ViewModel() {
    val NOT_SUPPORTED = "Bluetooth no esta soportado en este dispositivo"
    val SUPPORTED = "Bluetooth is soportado correctamente!"
    val BLUETOOTH_ON = "Bluetooth esta encendido!"
    val BLUETOOTH_OFF = "Bluetooth esta apagado"
    lateinit var bluetoothAdapter: BluetoothAdapter
    lateinit var bluetoothManager: BluetoothManager
    lateinit var m_bluetoothSocket: BluetoothSocket
    lateinit var takePermission: ActivityResultLauncher<String>
    lateinit var takeResultLauncher: ActivityResultLauncher<Intent>

    private var macAddressArduino: String = "98:D3:32:70:8B:76"
    private var m_uuid: UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB")

    val loading = mutableStateOf(true)
    val connection = mutableStateOf(false)
    var conectadoConArduino = false



    //private val myBluetoothService: MyBluetoothService = MyBluetoothService()

    fun initConnection() {
        getBluetoothAdapter()
        connection.value = true
    }

    private fun setupBluetoothService(){
        myBluetoothService.setSocket(m_bluetoothSocket)
        myBluetoothService.setInputStream()
        myBluetoothService.run()
    }

    fun conectarConArduino() {
        if (!conectadoConArduino) {
            viewModelScope.launch {
                withContext(Dispatchers.IO) {
                    sleep(2000L)
                    ConectarConArduino(macAddressArduino)
                    transmitir_datos()
                    loading.value = false
                }
            }
        }
    }

    private fun transmitir_datos(){
        if(conectadoConArduino){
            setupBluetoothService()
            myBluetoothService.run()
        }
    }

    fun getBluetoothAdapter() {
        bluetoothManager = mContext.getSystemService(ComponentActivity.BLUETOOTH_SERVICE) as BluetoothManager
        bluetoothAdapter = bluetoothManager.adapter
    }

    @SuppressLint("MissingPermission")
    private fun ConectarConArduino(macAddressArduino: String){
        try {
            var device: BluetoothDevice = bluetoothAdapter.getRemoteDevice(macAddressArduino)
            var m_uuid: UUID = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb")
            m_bluetoothSocket = device.createInsecureRfcommSocketToServiceRecord(m_uuid)
            m_bluetoothSocket.connect()
            conectadoConArduino = true
            loading.value = false
            //Toast.makeText(this, "Conexion con el estetoscopio", Toast.LENGTH_SHORT).show()
        } catch (e: IOException) {
            e.printStackTrace()
            //Toast.makeText(this, "No se pudo conectar con el estetoscopio", Toast.LENGTH_SHORT).show()
            Log.e("Tag", e.toString())
        }
    }

    fun desconectarBluetooth() {
        //MyBluetoothService(m_bluetoothSocket, null).cancel()\
        myBluetoothService.cancel()
        connection.value = false
    }



}