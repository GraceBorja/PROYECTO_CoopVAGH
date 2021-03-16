package com.borjagrace.proyecto_coopvagh

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore


class Principal : AppCompatActivity() {

    lateinit var textUsuario : TextView
//    lateinit var textIdUsuario : TextView
    lateinit var textNombreCuenta : TextView
    lateinit var textNumCuenta : TextView
    lateinit var textSaldo : TextView
    lateinit var db : FirebaseFirestore


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

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
        textNombreCuenta = findViewById(R.id.textViewNombreCuenta)
        textNumCuenta = findViewById(R.id.textViewNumCuenta)
        textSaldo = findViewById(R.id.textViewSaldo)


        val username = intent.getStringExtra(LOGIN_KEY) ?: "" // Get the support action bar
        textUsuario.append(username.substringBefore("@"))

//        leer()


        botonMov.setOnClickListener {
            startActivity(intento1)
            intento1.putExtra(LOGIN_KEY,username)
        }
        botonSolicitar.setOnClickListener {
            startActivity(intento2)
            intento2.putExtra(LOGIN_KEY,username)
        }
        botonPagar.setOnClickListener {
            startActivity(intento3)
            intento3.putExtra(LOGIN_KEY,username)
        }
        botonPerfi.setOnClickListener {
            startActivity(intento5)
            intento5.putExtra(LOGIN_KEY,username)
        }
        botonUbica.setOnClickListener {
            startActivity(intento6)
            intento6.putExtra(LOGIN_KEY,username)
        }
        botonSal.setOnClickListener {
            startActivity(intento61)
            intento61.putExtra(LOGIN_KEY,username)
        }


    }

//    private fun leer(){

//        db.collection("DatosUsuario").document("grace.borja@epn.edu.ec")
//            .get()
//            .addOnSuccessListener { document ->
//                if(document !=null){
//                    Log.d("exist", "DocumentSnapshot data: ${document.data}")
////                    textNombreCuenta.text = document.getString("nombreCuenta")
////                    textNumCuenta.text = document.getString("numCuenta")
////                    textSaldo.text = document.getString("saldo")
//
//                    textNombreCuenta.append(document.getString("nombreCuenta"))
//                    textNumCuenta.append(document.getString("numCuenta"))
//                    textSaldo.append(document.getString("saldo"))
//
//                }else{
//                    Log.d("noexist","No such document")
//                }
//            }
//            .addOnFailureListener { exception ->
//                Log.d("errordv", "Error getting documents.", exception)
//            }
//
//
//
//
//
////            .addOnSuccessListener { result ->
////                for (document in result) {
////                    textIdUsuario.text = document.getString("idUsuario")
////                    if(textIdUsuario.text == usuario){
////                        textNombreCuenta.text = document.getString("nombreCuenta")
////                        textNumCuenta.text = document.getString("numCuenta")
////                        textSaldo.text = document.getString("saldo")
////                    }
////
////                }
////
////            }
////            .addOnFailureListener { e ->
////                Toast.makeText(this, "Error al obtener datos de contactos:-> {$e.message}", Toast.LENGTH_LONG).show()
////            }
//    }


}