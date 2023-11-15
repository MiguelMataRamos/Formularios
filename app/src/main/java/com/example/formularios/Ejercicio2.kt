package com.example.formularios

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
        if (bind.nombre.text.isNullOrBlank()){

        }

    }
}