package com.borjagrace.proyecto_coopvagh

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_movimientos.*

class Movimientos : AppCompatActivity() {


    lateinit var db : FirebaseFirestore


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movimientos)

        db = FirebaseFirestore.getInstance()

        rvDatosCredito.layoutManager = LinearLayoutManager(this)
        rvDatosCredito.adapter = MovimientosAdapter(generarMovimientos(),this)

        val intento62 = Intent(this,Principal::class.java)
        val intento7 = Intent(this,MovimientosFecha::class.java)
        val intento8 = Intent(this,MiPerfil::class.java)
        val intento9 = Intent(this,Ubicanos::class.java)

        val botonAntes1 = findViewById<ImageButton>(R.id.buttonPrevious2)
        val botonBuscar = findViewById<ImageButton>(R.id.buttonSearch)
        val botonPerfi1 = findViewById<ImageButton>(R.id.buttonProfile2)
        val botonUbica1 = findViewById<ImageButton>(R.id.buttonLocation2)
        val botonSal1 = findViewById<ImageButton>(R.id.buttonExit)
        val botonCasa1 = findViewById<ImageButton>(R.id.buttonHome2)


        val username = intent.getStringExtra(LOGIN_KEY) ?: "" // Get the support action bar



        botonAntes1.setOnClickListener {
            startActivity(intento62)
            intento62.putExtra(LOGIN_KEY,username)
        }
        botonBuscar.setOnClickListener {
            startActivity(intento7)
            intento7.putExtra(LOGIN_KEY,username)
        }
        botonCasa1.setOnClickListener {
            startActivity(intento62)
            intento62.putExtra(LOGIN_KEY,username)
        }
        botonPerfi1.setOnClickListener {
            startActivity(intento8)
            intento8.putExtra(LOGIN_KEY,username)
        }
        botonUbica1.setOnClickListener {
            startActivity(intento9)
            intento9.putExtra(LOGIN_KEY,username)
        }
        botonSal1.setOnClickListener {
            startActivity(intento62)
            intento62.putExtra(LOGIN_KEY,username)
        }

    }

    private fun generarMovimientos() : ArrayList<Movimiento>{
        var lista = ArrayList<Movimiento>()
        lista.add(Movimiento("01 enero 2021","Detalle 1",5.00,5.00))
        lista.add(Movimiento("01 enero 2021","Detalle 2",10.00,15.00))
        lista.add(Movimiento("01 enero 2021","Detalle 3",3.00,18.00))
        lista.add(Movimiento("01 enero 2021","Detalle 4",5.00,23.00))
        lista.add(Movimiento("01 enero 2021","Detalle 5",5.00,28.00))
        lista.add(Movimiento("01 enero 2021","Detalle 6",4.00,32.00))

        return lista
    }

//    fun consultarMovimientos(){
//
//        val username1 = intent.getStringExtra(LOGIN_KEY) ?: "" // Get the support action bar
//        db.collection("Movimiento")
//            .get()
//            .addOnSuccessListener { result ->
//                movimientos.clear()
//                movimientosIdDocumentos.clear()
//                for (document in result) {
//                    val movimiento = document.toObject(Movimiento::class.java)
//                    if (movimiento.idUsuario == username1){
//                        movimientos.add(movimiento)
//                        movimientosIdDocumentos.add(document.id)
//                    }
//                }
//                //Poblar en ListView información usando mi adaptador
//                val movimientoAdaptador = MovimientosAdapter(this, movimientos)
//                listViewMovimientos.adapter = movimientoAdaptador
//
//
//            }
//            .addOnFailureListener { e ->
//                Toast.makeText(this, "Error al obtener datos de contactos:-> {$e.message}", Toast.LENGTH_LONG).show()
//            }
//
//
//    }
}