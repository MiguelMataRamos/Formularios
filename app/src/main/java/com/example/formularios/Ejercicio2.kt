package com.example.formularios

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.formularios.databinding.ActivityEjercicio2Binding

class Ejercicio2 : AppCompatActivity() {
    private lateinit var bind:ActivityEjercicio2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio2)
        bind = ActivityEjercicio2Binding.inflate(layoutInflater)
    }

    fun registrar(view:View){
        var Nvalido = true
        var Pvalido = true
        var Evalido = true

        if (bind.nombre.text.isNullOrBlank()){
            bind.lnombre.error="Debes ingresar un nombre. ¡CATETO!"
            Nvalido = false
        }

        if(bind.pass.text?.length!! < 9){
            bind.lpass.error = "La contraseña debe tener minimo 9 caracteres"
            Pvalido = false
        }

        if (!bind.correo.text?.contains("@")!! && !bind.correo.text?.contains(".")!!){
            bind.lcorreo.error = "Debes introducir un correo electronico"
            Evalido = false
        }

        if (Nvalido && Pvalido && Evalido){
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }
}