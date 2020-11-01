package com.example.kotlin_fun

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView

    var count = 0

    fun reset(view: View) {
        count = 0
        textView.text = count.toString()
    }

    fun plusOne(view: View) {
        count += 1
        textView.text = count.toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
    }
}