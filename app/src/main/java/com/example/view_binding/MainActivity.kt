package com.example.view_binding

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.view_binding.databinding.ActivityMainBinding
import java.sql.Time
import java.sql.Timestamp
import java.time.Instant.now

class MainActivity : AppCompatActivity() {

    // activity_main.xml => ActivityMainBinding
    private lateinit var binding: ActivityMainBinding;

    @SuppressLint("SetTextI18n")
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

        val msgInput = binding.msg

        val btSend = binding.btSend
        btSend.setOnClickListener {
            // This will "occur" when click on button

            Log.i("MainActivity", "He enviado la información")

            val sendHistory = binding.sendResult.text.toString()
            val sendMsg = now().toString() + " - "+ msgInput.text.toString()

            binding.sendResult.text = "$sendMsg\n$sendHistory"

            msgInput.setText("")
            btSend.isEnabled = false
        }

        binding.reload.setOnClickListener{
            btSend.isEnabled = true
        }
        binding.cookie.setOnClickListener{
            msgInput.setText("Give me cookies!!")
        }
    }
}