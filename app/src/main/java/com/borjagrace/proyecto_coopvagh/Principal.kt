package com.borjagrace.proyecto_coopvagh

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity


class Principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        val intento1 = Intent(this, Movimientos::class.java)
        val intento2 = Intent(this, SolicitarCredito::class.java)
        val intento3 = Intent(this, AbonarCredito::class.java)
        val intento4 = Intent(this, Principal::class.java)
        val intento5 = Intent(this, MiPerfil::class.java)
        val intento6 = Intent(this, Ubicanos::class.java)
        val intento61 = Intent(this, Login::class.java)

        val botonMov = findViewById<Button>(R.id.buttonVerMovimientos)
        val botonSolicitar = findViewById<Button>(R.id.buttonSolicitar)
        val botonPagar = findViewById<Button>(R.id.buttonAbonar)
        val botonPerfi = findViewById<ImageButton>(R.id.buttonProfile)
        val botonUbica = findViewById<ImageButton>(R.id.buttonLocation)
        val botonSal = findViewById<ImageButton>(R.id.buttonExit1)


        botonMov.setOnClickListener {
            startActivity(intento1)
        }
        botonSolicitar.setOnClickListener {
            startActivity(intento2)
        }
        botonPagar.setOnClickListener {
            startActivity(intento3)
        }
        botonPerfi.setOnClickListener {
            startActivity(intento5)
        }
        botonUbica.setOnClickListener {
            startActivity(intento6)
        }
        botonSal.setOnClickListener {
            startActivity(intento61)
        }


    }


}