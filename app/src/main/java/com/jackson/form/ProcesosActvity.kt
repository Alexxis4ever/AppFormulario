package com.jackson.form

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class ProcesosActvity : AppCompatActivity() {

    var txtUsuario: TextView?=null
    var txtPass: TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_procesos_actvity)

        txtUsuario=findViewById(R.id.txtUser)
        txtPass=findViewById(R.id.txtPass)

        var btnCargar:Button=findViewById(R.id.btnCargar)
        btnCargar.setOnClickListener { cargarDatos() }

        var btnRegresar: Button=findViewById(R.id.btnVolver)
        btnRegresar.setOnClickListener { regresar() }
    }

    private fun cargarDatos() {
        var preferences:SharedPreferences=getSharedPreferences("credenciales",Context.MODE_PRIVATE)

        var user: String? =preferences.getString("user", "No existe la informacion")
        var pass: String? =preferences.getString("pass", "No existe la informacion")

        txtUsuario?.text=user
        txtPass?.text=pass
    }

    private fun regresar() {
        finish()
    }
}