package com.borjagrace.proyecto_coopvagh

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore


class Principal : AppCompatActivity() {

    lateinit var textUsuario : TextView
    lateinit var nombreCuenta: TextView
    lateinit var numCuenta : TextView
    lateinit var saldo : TextView
    lateinit var db : FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)
        nombreCuenta = findViewById<TextView>(R.id.nombreCuenta)
        numCuenta = findViewById<TextView>(R.id.numCuenta)
        saldo = findViewById<TextView>(R.id.saldo)
        db = FirebaseFirestore.getInstance()

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

        textUsuario = findViewById(R.id.textViewUsuarioPrincipal)


        val username = intent.getStringExtra(LOGIN_KEY) ?: "" // Get the support action bar
        textUsuario.append(username.substringBefore("@"))

        intento1.putExtra(LOGIN_KEY,username)
        intento2.putExtra(LOGIN_KEY,username)
        intento3.putExtra(LOGIN_KEY,username)
        intento4.putExtra(LOGIN_KEY,username)
        intento5.putExtra(LOGIN_KEY,username)
        intento6.putExtra(LOGIN_KEY,username)
        intento61.putExtra(LOGIN_KEY,username)
        leerDatos()
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
    private fun leerDatos(){
        db.collection("PaginaPrincipal").document("marco.guacanes@epn.edu.ec")
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
}