package com.borjagrace.proyecto_coopvagh

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_abonar_credito.*

class AbonarCredito : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_abonar_credito)
        rvAbonar.layoutManager = LinearLayoutManager(this)
        rvAbonar.adapter = CreditosAdapter(generarDatosCredito(),this)
        val intento17 = Intent(this,Principal::class.java)
        val intento18 = Intent(this,MiPerfil::class.java)
        val intento19 = Intent(this,Ubicanos::class.java)

        val botonAntes4 = findViewById<ImageButton>(R.id.buttonPrevious5)
        val botonAbonar4 = findViewById<Button>(R.id.buttonAbonar)
        val botonPerfi4 = findViewById<ImageButton>(R.id.buttonProfile5)
        val botonUbica4 = findViewById<ImageButton>(R.id.buttonLocation5)
        val botonSal4 = findViewById<ImageButton>(R.id.buttonExit5)
        val botonCasa4 = findViewById<ImageButton>(R.id.buttonHome5)

        botonAntes4.setOnClickListener {
            startActivity(intento17)
        }
        botonAbonar4.setOnClickListener {
            startActivity(intento17)
        }
        botonCasa4.setOnClickListener {
            startActivity(intento17)
        }
        botonPerfi4.setOnClickListener {
            startActivity(intento18)
        }
        botonUbica4.setOnClickListener {
            startActivity(intento19)
        }
        botonSal4.setOnClickListener {
            startActivity(intento17)
        }
    }

    private fun generarDatosCredito() : ArrayList<Credito>{
        var lista = ArrayList<Credito>()
        lista.add(Credito("Capital","$ 100.00"))
        lista.add(Credito("Interés Mensual","$ 6.00"))
        lista.add(Credito("Valor de Cuota","$ 39.95"))
        lista.add(Credito("Cuotas Pagadas","1"))
        lista.add(Credito("Saldo","$ 78.70"))

        return lista
    }
}