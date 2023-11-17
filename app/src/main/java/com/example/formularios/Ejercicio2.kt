package com.example.formularios

import android.content.Intent
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.EditText
import com.example.formularios.databinding.ActivityEjercicio2Binding
import com.google.android.material.textfield.TextInputLayout

class Ejercicio2 : AppCompatActivity() {
    private lateinit var bind:ActivityEjercicio2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityEjercicio2Binding.inflate(layoutInflater)
        setContentView(bind.root)
        
    }

    fun registrar(view:View){
        var nvalido = true
        var pvalido = true
        var evalido = true

        if (bind.nombre.text.isNullOrBlank()){
            bind.lnombre.error="Debes ingresar un nombre. ¡CATETO!"
            nvalido = false
        }else{
            bind.lnombre.helperText = null
            bind.lnombre.boxStrokeColor = getColor(R.color.verde)
            bind.lnombre.defaultHintTextColor = getColorStateList(R.color.verde)
            bind.lnombre.hintTextColor = getColorStateList(R.color.verde)

            bind.lnombre.error =null
        }

        if(bind.pass.text?.length!! < 9){
            bind.lpass.error = "La contraseña debe tener minimo 9 caracteres"

            pvalido = false
        }else{
            bind.lpass.error = null
            bind.lpass.helperText = null
            bind.lpass.boxStrokeColor = getColor(R.color.verde)
            bind.lpass.defaultHintTextColor = getColorStateList(R.color.verde)
            bind.lpass.hintTextColor = ColorStateList.valueOf(getColor(R.color.black))

        }

        if (!bind.correo.text?.contains("@")!! && !bind.correo.text?.contains(".")!!){
            bind.lcorreo.error = "Debes introducir un correo electronico"
            evalido = false
        }else{
            bind.lcorreo.boxStrokeColor = getColor(R.color.verde)
            bind.lcorreo.boxStrokeColor = getColor(R.color.verde)
            bind.lcorreo.defaultHintTextColor = getColorStateList(R.color.verde)
            bind.lcorreo.hintTextColor = getColorStateList(R.color.verde)
            bind.lcorreo.helperText = null
            bind.lcorreo.error = null
        }

        if (nvalido && pvalido && evalido){
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }
}