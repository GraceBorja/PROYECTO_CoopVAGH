package com.borjagrace.proyecto_coopvagh

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.maps.GoogleMap
import com.google.firebase.firestore.FirebaseFirestore

import kotlinx.android.synthetic.main.activity_mi_perfil.*

class MiPerfil : AppCompatActivity() {

     lateinit var nombres : TextView
    lateinit var apellidos : TextView
    lateinit var correo : TextView
    lateinit var contraseña : TextView
    lateinit var saveButton : Button
    lateinit var lastName : EditText
    lateinit var firstName : EditText
    lateinit var db : FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mi_perfil)
        nombres = findViewById<TextView>(R.id.nombres)
        apellidos = findViewById<TextView>(R.id.textView11)
        correo = findViewById<TextView>(R.id.textView14)
        contraseña = findViewById<TextView>(R.id.textView16)
        saveButton = findViewById<Button>(R.id.btnModificar)

        db = FirebaseFirestore.getInstance()

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
        val lastName = findViewById<EditText>(R.id.nombres1)
       // val firstName = findViewById<EditText>(R.id.)
        leer()
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

    private fun leer(){
    db.collection("Nombres").document("Nombres")
        .get()
        .addOnSuccessListener { document ->
            if(document !=null){
                Log.d("exist", "DocumentSnapshot data: ${document.data}")
                nombres.text = document.getString("nombres")
                apellidos.text = document.getString("apellidos")
                correo.text = document.getString("correo")
                contraseña.text = document.getString("contraseña")

            }else{
                Log.d("noexist","No such document")
            }
        }
        .addOnFailureListener { exception ->
            Log.d("errordv", "Error getting documents.", exception)
        }
    }
   /*private fun guardar(){
       val db = FirebaseFirestore.getInstance()
       val user: MutableMap<String, Any> = HashMap()
       user["firstName"] = firstname
       user["lastName"] = lastname

       db.collection("nombres")
           .add(user)
           .addOnSuccessListener {
               Toast.makeText(this@MainActivity, "record added successfully ", Toast.LENGTH_SHORT ).show()
           }
           .addOnFailureListener{
               Toast.makeText(this@MainActivity, "record Failed to add ", Toast.LENGTH_SHORT ).show()
           }
       readFireStoreData()
   }
   }*/
    private fun cargarPerfil() : ArrayList<Perfil>{
        var lista = ArrayList<Perfil>()
        lista.add(Perfil(R.drawable.telefono,"Mis Teléfonos",R.drawable.next))
        lista.add(Perfil(R.drawable.apartamento,"Mis Oficinas",R.drawable.next))
        lista.add(Perfil(R.drawable.informacionpersonal,"Datos Personales",R.drawable.next))
        lista.add(Perfil(R.drawable.money,"Créditos - Historial",R.drawable.next))
        return lista
    }
}