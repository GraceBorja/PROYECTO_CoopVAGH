package com.borjagrace.proyecto_coopvagh

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val intento = Intent(this,Principal::class.java)


        buttonIngresar.setOnClickListener {
            startActivity(intento)
        }

        buttonSalir.setOnClickListener {
            this.finish()

        }


    }


}