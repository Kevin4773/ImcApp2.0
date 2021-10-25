package com.example.imc_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

        val buttonEntrar = findViewById<Button>(R.id.button_entrar)
        val buttonNovoUsuario = findViewById<Button>(R.id.button_nova_conta)

        buttonEntrar.setOnClickListener {
            val abrirDashBoard = Intent(this, DashBoardActivity::class.java)
            startActivity(abrirDashBoard)
        }

        buttonNovoUsuario.setOnClickListener {
            val abrirNovaConta = Intent(this, NovoUsuarioActivity::class.java)
            startActivity(abrirNovaConta)
        }

    }
}