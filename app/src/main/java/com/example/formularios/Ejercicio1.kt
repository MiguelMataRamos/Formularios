package com.example.formularios

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class Ejercicio1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio1)
    }

    fun enviar(view:View){
        var valido = true
        var layoutnombre = findViewById<TextInputLayout>(R.id.lnombre)
        var nombre = findViewById<TextInputEditText>(R.id.nombre)
        var edad = findViewById<TextInputEditText>(R.id.edad)

        if (nombre.text.isNullOrBlank()){
            valido = false
            layoutnombre.error = "El campo de nombre no puede estar vacio"
        }else if (nombre.length() < 2){
            valido = false
            layoutnombre.error = "El campo de nombre debe tener minimo 2 caracteres"
        }

        if (valido){
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }
}