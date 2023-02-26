package com.example.patologiasuns.feature_detalle.bluetooth

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.util.Log

class BluetoothClient(device: BluetoothDevice): Thread() {
    private val socket = device.createRfcommSocketToServiceRecord(uuid)

    override fun run() {
        Log.i("client", "Connecting")
        this.socket.connect()
        Log.i("client", "Sending")
        val outputStream = this.socket.outputStream
        val inputStream = this.socket.inputStream
        try {
            outputStream.write("Estoy transmitiendo datos".toByteArray())
            outputStream.flush()
            Log.i("client", "Sent")
        } catch(e: Exception) {
            Log.e("client", "Cannot send", e)
        } finally {
            outputStream.close()
            inputStream.close()
            this.socket.close()
        }
    }
}