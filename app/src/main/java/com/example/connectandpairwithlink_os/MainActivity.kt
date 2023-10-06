package com.example.connectandpairwithlink_os

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zebra.sdk.btleComm.BluetoothLeConnection
import com.zebra.sdk.comm.Connection
import com.zebra.sdk.comm.ConnectionException


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val theBtMacAddress = "00:07:4D:E8:B5:83"
        val context = applicationContext
        sendZplOverBluetoothLe(theBtMacAddress, context)
    }

    private fun sendZplOverBluetoothLe(theBtMacAddress: String, context: Context) {
        Thread {
            var thePrinterConn: Connection? = null
            try {
                // Instantiate connection for given Bluetooth&reg; MAC Address.
                thePrinterConn = BluetoothLeConnection(theBtMacAddress, context)

                // Open the connection - physical connection is established here.
                thePrinterConn.open()

                // This example prints "This is a ZPL test." near the top of the label.
                val zplData = "^XA^FO20,20^A0N,25,25^FDHello, Polina! ;D^FS^XZ"

                // Send the data to printer as a byte array.
                thePrinterConn.write(zplData.toByteArray())

                // Make sure the data got to the printer before closing the connection
                Thread.sleep(500)
            } catch (e: Exception) {
                // Handle communications error here.
                e.printStackTrace()
            } finally {
                // Close the connection to release resources.
                if (null != thePrinterConn) {
                    try {
                        thePrinterConn.close()
                    } catch (e: ConnectionException) {
                        e.printStackTrace()
                    }
                }
            }
        }.start()
    }
}
