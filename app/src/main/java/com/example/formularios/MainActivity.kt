package com.example.formularios

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun click(view:View){
        when(view.id){
            R.id.ej1 -> {
                var intent = Intent(this,Ejercicio1::class.java)
                startActivity(intent)
            }
            R.id.ej2 -> {
                var intent = Intent(this,Ejercicio2::class.java)
                startActivity(intent)
            }


        }
    }

}