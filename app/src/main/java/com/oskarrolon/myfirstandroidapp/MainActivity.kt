package com.oskarrolon.myfirstandroidapp

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun clickBtn(view: android.view.View) {
        var numeroBase = findViewById<EditText>(R.id.pAge).text
        var nombrePersona = findViewById<EditText>(R.id.pName).text
        var numero= Integer.parseInt(numeroBase.toString())
        var numeroSuerte=0
        var n1 = 0
        var n2 = 0
        var numeroTemp = 0
        if (numero<10){
            numeroTemp = numero*7
            do {
                n1 = numeroTemp/10
                n2 = numeroTemp%10
                numeroTemp = n1 + n2
            }while (numeroTemp>10)
            numeroSuerte=numeroTemp
        }else if(numero>9) {
            numeroTemp = numero
            while (numeroTemp>=10){
                n1 = numeroTemp/10
                n2 = numeroTemp%10
                numeroTemp = n1 + n2
            }
            numeroSuerte=numeroTemp
        }
            val builder: AlertDialog.Builder = AlertDialog.Builder(this)
            builder.setTitle("Hello $nombrePersona, your lucky number is:")
            builder.setMessage("$numeroSuerte")
            builder.setIcon(R.drawable.ic_launcher_background)
            builder.setPositiveButton("Ok", DialogInterface.OnClickListener {dialog, which -> dialog.dismiss()})
            val alertDialog: AlertDialog = builder.create()
            alertDialog.show()
    }
}