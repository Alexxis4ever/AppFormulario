package com.jackson.form

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var campoUsuario:EditText?=null
    var campoPass:EditText?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        iniciarComponentes()
    }

    private fun iniciarComponentes() {

        var btnGuardar:Button=findViewById(R.id.btnGuardar)
        btnGuardar.setOnClickListener{ guardarDatos() }

        campoUsuario=findViewById(R.id.campoUser)
        campoPass=findViewById(R.id.campoPass)

    }

    private fun guardarDatos() {

        var preferences:SharedPreferences=getSharedPreferences("credenciales",Context.MODE_PRIVATE)

        var usuario= campoUsuario?.text.toString()
        var pass= campoPass?.text.toString()

        var editor:SharedPreferences.Editor=preferences.edit()

        if (usuario.isEmpty()){
            campoUsuario?.setError("El nombre es requerido")
        } else if (pass.isEmpty()){
            campoPass?.setError("La contraseña es requerida")
        } else {
            editor.putString("user",usuario)
            editor.putString("pass",pass)

            editor.commit()

            val miIntent = Intent(this, ProcesosActvity::class.java)
            startActivity(miIntent)

            Toast.makeText(this,"Se han registrado los datos",Toast.LENGTH_SHORT).show()

            campoUsuario!!.setText("")
            campoPass!!.setText("")
        }
    }
}