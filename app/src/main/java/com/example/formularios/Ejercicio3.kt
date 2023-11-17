package com.example.formularios

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.text.isDigitsOnly
import com.example.formularios.databinding.ActivityEjercicio3Binding

class Ejercicio3 : AppCompatActivity() {
    private lateinit var bind: ActivityEjercicio3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityEjercicio3Binding.inflate(layoutInflater)
        setContentView(bind.root)
    }

    fun pasar(view: View) {
        var bmail = true
        var bpass = true
        var bcp = true

        if (bind.mail.text.isNullOrBlank()) {
            bind.lmail.error = "EMAIL necesario"
            bmail = false
        } else if (!bind.mail.text!!.contains("@") && !bind.mail.text!!.contains(".")) {
            bmail = false
            bind.lmail.error = "No es un formato de EMAIL"
        }else{
            bind.lmail.helperText = null
            bind.lmail.error = null
        }

        var contra = bind.pass.text
        if (bind.pass.text.isNullOrBlank()) {
            bind.lpass.error = "La contraseña es obligatoria"
            bpass = false
        } else if (bind.pass.text!!.length <= 7) {
            bind.lpass.error = "La contraseña debe tener mas de 7 caracteres"
            bpass = false
        } else if (contra?.matches(Regex(".*[a-z].*[A-Z].*\\d.*")) == false) {
            bind.lpass.error = "Debe contener mayusculas, minusculas y algun numero"
            bpass = false
        }else{
            bind.lpass.helperText = null
            bind.lpass.error = null
        }


        if (bind.cp.text?.isDigitsOnly() == false) {
            bcp = false
            bind.lcp.error = "Debe ser numerico"
        }else{
            bind.lpass.helperText = null
            bind.lcp.error = null
        }

        if (bmail && bpass && bcp) {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }


}