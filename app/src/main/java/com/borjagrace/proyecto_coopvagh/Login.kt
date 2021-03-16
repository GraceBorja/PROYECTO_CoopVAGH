package com.borjagrace.proyecto_coopvagh

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login.*
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

class Login : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    var login : String? = null
    var password : String?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = Firebase.auth
        //TEmporal ejemplo escritura de datos archivo interno
        EscribirDatosEnArchivoInterno4()
        LeerDatosDeArchivoInterno4()
        EscribirDatosEnArchivoExterno()
        LeerDatosDeArchivoExterno()

        //Inicialisacion de llave
        val masterKeyAlias: String = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
        val sharedPreferences = EncryptedSharedPreferences.create(
            "secret_shared_prefs",//filename
            masterKeyAlias,
            this,//context
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM)
        //Lectura de valores de archivos de preferencias en caso que existan
        login = sharedPreferences.getString(LOGIN_KEY,"")
        password = sharedPreferences.getString(PASSWORD_KEY,"")
        editTextUsuario.setText (login )
        editTextTextContraseña.setText (password)
        buttonIngresar.setOnClickListener {
            if(!ValidarDatos())
                return@setOnClickListener

            if(checkBoxRrecuerdame.isChecked){
                sharedPreferences.edit()
                    .putString(LOGIN_KEY,editTextUsuario.text.toString())
                    .putString(PASSWORD_KEY,editTextTextContraseña.text.toString())
                    .apply()
            }
            else{
                val editor = sharedPreferences.edit()
                editor.putString(LOGIN_KEY,"")
                editor.putString(PASSWORD_KEY,"")
                editor.commit()
            }
            AutenticarUsuario(editTextUsuario.text.toString(),editTextTextContraseña.text.toString())

        }

        buttonSalir.setOnClickListener {
            this.finish()
        }
        buttonRegistrarse.setOnClickListener {
            var intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }


    }

    fun AutenticarUsuario(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    var intent = Intent(this, Principal::class.java)
                    intent.putExtra(LOGIN_KEY,auth.currentUser!!.email)
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        baseContext, task.exception!!.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }
    fun ValidarDatos(): Boolean {
        fun CharSequence?.isValidEmail() =
            !isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()
        if (editTextUsuario.text.isNullOrEmpty()) {
            editTextUsuario.setError(getString(R.string.editTextTextEmailAddress_hint))
            editTextUsuario.requestFocus()
            return false
        }
        if (!editTextUsuario.text.isValidEmail()) {
            editTextUsuario.setError(getString(R.string.email_NoValido))
            editTextUsuario.requestFocus()
            return false
        }
        if (editTextTextContraseña.text.isNullOrEmpty()) {
            editTextTextContraseña.setError(getString(R.string.editTextPassword_hint))
            editTextTextContraseña.requestFocus()
            return false
        }
        if (editTextTextContraseña.text.length < MIN_PASSWORD_LENGTH) {
            editTextTextContraseña.setError(getString(R.string.password_longitudNoValida))
            editTextTextContraseña.requestFocus()
            return false
        }
        return true
    }
    fun EscribirDatosEnArchivoInterno4(){
        val texto = "texto" + System.lineSeparator() + "almacenado"
        openFileOutput("fichero.txt", Context.MODE_PRIVATE).bufferedWriter().use { fos ->
            fos.write(texto)
        }
    }
    fun LeerDatosDeArchivoInterno4() {
        openFileInput("fichero.txt").bufferedReader().use {
            val datoLeido = it.readText()
            val textArray = datoLeido.split("\n")
            val texto1 = textArray[0]
            val texto2 = textArray[1]
        }
    }

    fun EscribirDatosEnArchivoExterno(){
        if (isExternalStorageWritable()) {
            FileOutputStream(File(getExternalFilesDir(null),CONTACTS_FILENAME)).bufferedWriter().use { outputStream ->
                outputStream.write("dato1")
                outputStream.write(System.lineSeparator())
                outputStream.write("dato2")
            }
        }
    }
    fun LeerDatosDeArchivoExterno(){
        if (isExternalStorageReadable()) {
            FileInputStream(File(getExternalFilesDir(null),CONTACTS_FILENAME)).bufferedReader().use {
                val datoLeido = it.readText()
                val textArray = datoLeido.split(System.lineSeparator())
                val texto1 = textArray[0]
                val texto2 = textArray[1]
            }
        }
    }
    fun isExternalStorageWritable(): Boolean {
        return Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED
    }

    fun isExternalStorageReadable(): Boolean {
        return Environment.getExternalStorageState() in
                setOf(Environment.MEDIA_MOUNTED, Environment.MEDIA_MOUNTED_READ_ONLY)
    }

}