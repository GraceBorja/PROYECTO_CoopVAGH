package com.borjagrace.proyecto_coopvagh

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_ubicanos.*

class Ubicanos : AppCompatActivity() , OnMapReadyCallback {
    private lateinit var mMap: GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ubicanos)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

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

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val coopvagh = LatLng(-0.22010777407389526, -78.51126256354084)
        mMap.addMarker(MarkerOptions().position(coopvagh).title("Coop. VAGH"))
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coopvagh, 17F))
    }
}