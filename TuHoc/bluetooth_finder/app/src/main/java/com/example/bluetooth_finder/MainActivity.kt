package com.example.bluetooth_finder

import android.app.Activity
import android.bluetooth.BluetoothAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.annotation.IdRes

class MainActivity : AppCompatActivity() {

    private val searchButton by bind<Button>(R.id.searchButton)
    private val listView by bind<ListView>(R.id.listView)
    private val statusTextView by bind<TextView>(R.id.statusTextView)
    private var bluetoothAdapter: BluetoothAdapter? = null

    private fun <T : View> Activity.bind(@IdRes res : Int) : Lazy<T> {
        @Suppress("UNCHECKED_CAST")
        return lazy(LazyThreadSafetyMode.NONE){ findViewById<T>(res) }
    }

    private fun init() {
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
    }

    fun searchClicked(view: View) {
        statusTextView.text = "Searching..."
        searchButton.isEnabled = false
        // bluetoothAdapter!!.startDiscovery()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }
}