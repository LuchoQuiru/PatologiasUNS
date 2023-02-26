package com.example.patologiasuns.feature_detalle.bluetooth

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.bluetooth.BluetoothServerSocket
import android.bluetooth.BluetoothSocket
import android.content.ContentValues.TAG
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.core.content.ContextCompat.getSystemService
import com.example.patologiasuns.feature_detalle.DetalleActivity
import java.util.*
import java.io.IOException

val uuid: UUID = UUID.fromString("8989063a-c9af-463a-b3f1-f21d9b2b827b")

class BluetoothServerController(activity: DetalleActivity) : Thread() {
    private var cancelled: Boolean
    private val serverSocket: BluetoothServerSocket?
    private val activity = activity

    init {
        //val btAdapter = BluetoothAdapter.getDefaultAdapter()
        val btAdapter = activity.bluetoothAdapter
        if (btAdapter != null) {
            Log.i("TAG", "1 - listenUsingRfcommWithServiceRecord")
            this.serverSocket = btAdapter.listenUsingRfcommWithServiceRecord("test", uuid) // 1
            this.cancelled = false
        } else {
            this.serverSocket = null
            this.cancelled = true
        }
    }

    override fun run() {
        // Keep listening until exception occurs or a socket is returned.
        var shouldLoop = true
        while (shouldLoop) {
            Log.e(TAG, "Entre a run")
            try {
                Log.e(TAG, "entre a try!")
                serverSocket?.accept()
                Log.e(TAG, "salgo de try!")
            } catch (e: IOException) {
                Log.e(TAG, "Socket's accept() method failed", e)
                shouldLoop = false
                null
            }
            Log.e(TAG, "Aca tampoco estoy!")
            serverSocket?.also {
                Log.e(TAG, "EXCELENTISIMO1")
                serverSocket?.close()
                shouldLoop = false
            }
        }
    }

    fun cancel() {
        this.cancelled = true
        this.serverSocket!!.close()
    }

}