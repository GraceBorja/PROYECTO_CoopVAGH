package com.borjagrace.proyecto_coopvagh

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_mi_perfil.*

class MiPerfil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mi_perfil)

        rvMiPerfil.layoutManager = LinearLayoutManager(this)
        rvMiPerfil.adapter = PerfilAdapter(cargarPerfil(),this)

        val intento20 = Intent(this,Principal::class.java)
        val intento21 = Intent(this,MiPerfil::class.java)
        val intento22 = Intent(this,Ubicanos::class.java)

        val botonAntes5 = findViewById<ImageButton>(R.id.buttonPrevious6)
        val botonPerfi5 = findViewById<ImageButton>(R.id.buttonProfile6)
        val botonUbica5 = findViewById<ImageButton>(R.id.buttonLocation6)
        val botonSal5 = findViewById<ImageButton>(R.id.buttonExit6)
        val botonCasa5 = findViewById<ImageButton>(R.id.buttonHome6)

        botonAntes5.setOnClickListener {
            startActivity(intento20)
        }
        botonCasa5.setOnClickListener {
            startActivity(intento20)
        }
        botonPerfi5.setOnClickListener {
            startActivity(intento21)
        }
        botonUbica5.setOnClickListener {
            startActivity(intento22)
        }
        botonSal5.setOnClickListener {
            startActivity(intento20)
        }
    }

    private fun cargarPerfil() : ArrayList<Perfil>{
        var lista = ArrayList<Perfil>()
        lista.add(Perfil(R.drawable.telefono,"Mis Teléfonos",R.drawable.next))
        lista.add(Perfil(R.drawable.apartamento,"Mis Oficinas",R.drawable.next))
        lista.add(Perfil(R.drawable.informacionpersonal,"Datos Personales",R.drawable.next))
        lista.add(Perfil(R.drawable.money,"Créditos - Historial",R.drawable.next))
        return lista
    }
}