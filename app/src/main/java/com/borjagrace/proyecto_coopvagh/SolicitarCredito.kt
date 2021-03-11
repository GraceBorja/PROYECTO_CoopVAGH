package com.borjagrace.proyecto_coopvagh

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_solicitar_credito.*

class SolicitarCredito : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_solicitar_credito)

        rvDatosNuevo.layoutManager = LinearLayoutManager(this)
        rvDatosNuevo.adapter = CreditosAdapter(generarDatosCredito(),this)

        val intento14 = Intent(this,Principal::class.java)
        val intento15 = Intent(this,MiPerfil::class.java)
        val intento16 = Intent(this,Ubicanos::class.java)

        val botonAntes3 = findViewById<ImageButton>(R.id.buttonPrevious4)
        val botonSolici3 = findViewById<Button>(R.id.buttonSolicitar1)
        val botonPerfi3 = findViewById<ImageButton>(R.id.buttonProfile4)
        val botonUbica3 = findViewById<ImageButton>(R.id.buttonLocation4)
        val botonSal3 = findViewById<ImageButton>(R.id.buttonExit4)
        val botonCasa3 = findViewById<ImageButton>(R.id.buttonHome4)

        botonAntes3.setOnClickListener {
            startActivity(intento14)
        }
        botonSolici3.setOnClickListener {
            startActivity(intento14)
        }
        botonCasa3.setOnClickListener {
            startActivity(intento14)
        }
        botonPerfi3.setOnClickListener {
            startActivity(intento15)
        }
        botonUbica3.setOnClickListener {
            startActivity(intento16)
        }
        botonSal3.setOnClickListener {
            startActivity(intento14)
        }


    }

    private fun generarDatosCredito() : ArrayList<Credito>{
        var lista = ArrayList<Credito>()
        lista.add(Credito("Capital","$ 100.00"))
        lista.add(Credito("Interés Mensual","$ 6.00"))
        lista.add(Credito("Valor de Cuota","$ 39.95"))
        lista.add(Credito("Número de Cuotas","3"))


        return lista
    }
}