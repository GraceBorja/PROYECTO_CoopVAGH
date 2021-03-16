package com.borjagrace.proyecto_coopvagh

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_solicitar_credito.*

class SolicitarCredito : AppCompatActivity() {

    lateinit var nombreCuenta: TextView
    lateinit var numCuenta : TextView
    lateinit var saldo : TextView
    lateinit var db : FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_solicitar_credito)
        nombreCuenta = findViewById<TextView>(R.id.nombreCuenta)
        numCuenta = findViewById<TextView>(R.id.numCuenta)
        saldo = findViewById<TextView>(R.id.saldo)
        db = FirebaseFirestore.getInstance()
        leer()
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

    private fun leer(){
        db.collection("Datos").document("Solicitar")
            .get()
            .addOnSuccessListener { document ->
                if(document !=null){
                    Log.d("exist", "DocumentSnapshot data: ${document.data}")
                    nombreCuenta.text = document.getString("nombreCuenta")
                    numCuenta.text = document.getString("numCuenta")
                    saldo.text = document.getString("saldo")
                }else{
                    Log.d("noexist","No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d("errordv", "Error getting documents.", exception)
            }
    }

    private fun generarDatosCredito() : ArrayList<Credito>{
        var lista = ArrayList<Credito>()
        lista.add(Credito("Capital","$ 100.00"))
        lista.add(Credito("Interés Mensual","$ 6.00"))
        lista.add(Credito("Valor de Cuota","$ 39.95"))
        lista.add(Credito("Número de Cuotas","4"))
        return lista
    }
}