package com.example.patologiasuns.feature_detalle.bluetooth

import android.bluetooth.BluetoothSocket
import android.util.Log
import com.example.patologiasuns.feature_detalle.DetalleActivity

class BluetoothServer(private val activity: DetalleActivity, private val socket: BluetoothSocket): Thread() {
    private val inputStream = this.socket.inputStream
    private val outputStream = this.socket.outputStream

    override fun run() {
        Log.i("--------->", "Run() de bluetooth_server")
        try {
            val available = inputStream.available()
            val bytes = ByteArray(available)
            Log.i("server", "Reading")
            inputStream.read(bytes, 0, available)
            val text = String(bytes)
            Log.i("server", "Message received")
            Log.i("server", text)
            //activity.appendText(text)
        } catch (e: Exception) {
            Log.e("client", "Cannot read data", e)
        } finally {
            inputStream.close()
            outputStream.close()
            socket.close()
        }
    }
}