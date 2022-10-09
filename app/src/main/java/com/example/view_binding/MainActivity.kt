package com.example.view_binding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.view_binding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // activity_main.xml => ActivityMainBinding
    private lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        // Forma por defecto de obtener vistas:
        // setContentView(R.layout.activity_main) // Comentamos ya que vamos a utilizar binding

        setContentView(view)

        val name = "Francisco Javier"
        Log.i("MainActivity", "Ejecutando on create")

        val textView = findViewById<TextView>(R.id.textView)
        Log.i("MainActivity", textView.text.toString())

        val textViewBinding = binding.textView
        Log.i("MainActivity", textViewBinding.text.toString())

        val btSend = binding.btSend
        btSend.setOnClickListener {
            // This will "occur" when click on button
            Log.i("MainActivity", "He enviado la información")
            binding.sendResult.text = "Información enviada :)"
            btSend.isEnabled = false
        }
    }
}