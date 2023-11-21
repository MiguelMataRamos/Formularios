package com.example.formularios

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.text.isDigitsOnly
import com.example.formularios.databinding.ActivityEjercicio3Binding
import com.google.android.material.datepicker.MaterialDatePicker

class Ejercicio3 : AppCompatActivity() {
    private lateinit var bind: ActivityEjercicio3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityEjercicio3Binding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.fecha.setOnClickListener {
            val builder = MaterialDatePicker.Builder.datePicker()
            val picker = builder.build()

            picker.addOnPositiveButtonClickListener {
                bind.fecha.setText(picker.headerText)
            }

            picker.show(supportFragmentManager,"tag")

        }

    }



    fun pasar(view: View) {
        var bmail = true
        var bpass = true
        var bcp = true
        var bdate = true

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

        if (bind.fecha.text.toString() != ""){
            var fecha = bind.fecha?.text?.split(" ")
            if (fecha!=null && fecha[2].toInt() > 2005){
                bdate = false
                bind.lfecha.error = "Debes ser mayor de edad"
            }else{
                bind.lfecha.error = null
            }
        }else{
            bind.lfecha.error = "Debe introducir una fecha de nacimiento"
        }




        if (bmail && bpass && bcp && bdate) {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }


}