package com.borjagrace.proyecto_coopvagh

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class MovimientosFecha : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movimientos_fecha)


        val intento10 = Intent(this,Principal::class.java)
        val intento11 = Intent(this,Movimientos::class.java)
        val intento12 = Intent(this,MiPerfil::class.java)
        val intento13 = Intent(this,Ubicanos::class.java)

        val botonAntes2 = findViewById<ImageButton>(R.id.buttonPrevious3)
        val botonPerfi2 = findViewById<ImageButton>(R.id.buttonProfile3)
        val botonUbica2 = findViewById<ImageButton>(R.id.buttonLocation3)
        val botonSal2 = findViewById<ImageButton>(R.id.buttonExit3)
        val botonCasa2 = findViewById<ImageButton>(R.id.buttonHome3)

        botonAntes2.setOnClickListener {
            startActivity(intento11)
        }
        botonCasa2.setOnClickListener {
            startActivity(intento10)
        }
        botonPerfi2.setOnClickListener {
            startActivity(intento12)
        }
        botonUbica2.setOnClickListener {
            startActivity(intento13)
        }
        botonSal2.setOnClickListener {
            startActivity(intento10)
        }





    }



}