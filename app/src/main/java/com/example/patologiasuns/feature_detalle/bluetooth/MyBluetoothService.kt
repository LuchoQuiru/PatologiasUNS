package com.example.patologiasuns.feature_detalle.bluetooth

import android.bluetooth.BluetoothSocket
import android.content.ContentValues
import android.util.Log
import androidx.activity.viewModels
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.example.patologiasuns.feature_detalle.DetalleViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.internal.lifecycle.HiltViewModelFactory
import dagger.hilt.android.lifecycle.HiltViewModel
import java.io.IOException
import java.io.InputStream
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MyBluetoothService @Inject constructor(
    //private val mmSocket: BluetoothSocket,
    //caracterRecibido : MutableState<String>?,
    //val detalleViewModel: DetalleViewModel
) : Thread() {

    private lateinit var mmSocket: BluetoothSocket
    private lateinit var mmInStream: InputStream
    private val mmBuffer: ByteArray = ByteArray(1024) // mmBuffer store for the stream

    val char = MutableLiveData("z")

    override fun run() {
        var numBytes: Int // bytes returned from read()
        while (true) {
            // Read from the InputStream.
            numBytes = try {
                mmInStream.read(mmBuffer)
            } catch (e: IOException) {
                Log.d(ContentValues.TAG, "Input stream was disconnected", e)
                break
            }
            char.postValue(String(mmBuffer, 0, numBytes))
            /*Log.d("Datos recibidos", numBytes.toString()    )
            caracterRecibido?.value = numBytes.toString()*/
        }
    }

    // Call this method from the main activity to shut down the connection.
    fun cancel() {
        try {
            mmSocket?.close()
        } catch (e: IOException) {
            Log.e(ContentValues.TAG, "Could not close the connect socket", e)
        }
    }

    fun setSocket(socket: BluetoothSocket){
        this.mmSocket = socket
    }

    fun setInputStream(){
        mmInStream = mmSocket.inputStream
    }

}