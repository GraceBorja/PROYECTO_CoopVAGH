package com.borjagrace.proyecto_coopvagh

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_ubicanos.*

class Ubicanos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ubicanos)

        rvContactanos.layoutManager = LinearLayoutManager(this)
        rvContactanos.adapter = UbicanosAdapter(cargarContacto(),this)

        val intento23 = Intent(this,Principal::class.java)
        val intento24 = Intent(this,MiPerfil::class.java)
        val intento25 = Intent(this,Ubicanos::class.java)

        val botonAntes6 = findViewById<ImageButton>(R.id.buttonPrevious7)
        val botonPerfi6 = findViewById<ImageButton>(R.id.buttonProfile7)
        val botonUbica6 = findViewById<ImageButton>(R.id.buttonLocation7)
        val botonSal6 = findViewById<ImageButton>(R.id.buttonExit7)
        val botonCasa6 = findViewById<ImageButton>(R.id.buttonHome7)

        botonAntes6.setOnClickListener {
            startActivity(intento23)
        }
        botonCasa6.setOnClickListener {
            startActivity(intento23)
        }
        botonPerfi6.setOnClickListener {
            startActivity(intento24)
        }
        botonUbica6.setOnClickListener {
            startActivity(intento25)
        }
        botonSal6.setOnClickListener {
            startActivity(intento23)
        }
        botonSal6.setOnClickListener {
            startActivity(intento23)
        }
    }

    private fun cargarContacto() : ArrayList<Contacto>{
        var lista = ArrayList<Contacto>()
        lista.add(Contacto(R.drawable.smartphone,"Teléfono","0985412546"))
        lista.add(Contacto(R.drawable.mail,"Correo Electrónico","coop.vagh@gmail.com"))
        return lista
    }
}