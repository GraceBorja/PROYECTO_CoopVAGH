package com.borjagrace.proyecto_coopvagh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_registro.*

class RegistroActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        auth = Firebase.auth
        buttonRegistrar.setOnClickListener {
            if(!ValidarDatos()) {
                return@setOnClickListener
            }else{
                val email = editTextUsuarion.text.toString()
                val password = editTextContraseña.text.toString()
                SignUpNewUser(email,password)
                limpiarCamposEditables()
                var intent = Intent(this,Long::class.java)
                startActivity(intent)
            }
        }
    }
    fun SignUpNewUser(email:String, password:String){
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    Toast.makeText(baseContext, "New user saved.",
                        Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(baseContext, task.exception!!.message,
                        Toast.LENGTH_SHORT).show()
                }

                // ...
            }
    }

    fun ValidarDatos(): Boolean {
        fun CharSequence?.isValidEmail() =
            !isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()
        if (editTextUsuarion.text.isNullOrEmpty()) {
            editTextUsuarion.setError(getString(R.string.editTextTextEmailAddress_hint))
            editTextUsuarion.requestFocus()
            return false
        }
        if (!editTextUsuarion.text.isValidEmail()) {
            editTextUsuarion.setError(getString(R.string.email_NoValido))
            editTextUsuarion.requestFocus()
            return false
        }
        if (editTextContraseña.text.isNullOrEmpty()) {
            editTextContraseña.setError(getString(R.string.editTextPassword_hint))
            editTextContraseña.requestFocus()
            return false
        }
        if (editTextContraseña.text.length < MIN_PASSWORD_LENGTH) {
            editTextContraseña.setError(getString(R.string.password_longitudNoValida))
            editTextContraseña.requestFocus()
            return false
        }
        if (editTextContraseña.text.toString() != editTextContraseña2.text.toString()) {
            editTextContraseña.setError(getString(R.string.password_noidenty))
            editTextContraseña.requestFocus()
            return false
        }
        return true
    }
    private fun limpiarCamposEditables() {
        editTextUsuarion.setText("")
        editTextContraseña.setText("")
        editTextContraseña2.setText("")
    }
}