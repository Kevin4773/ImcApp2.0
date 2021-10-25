package com.example.imc_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu

class NovoUsuarioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novo_usuario)

        supportActionBar!!.title = "Nova Conta"
    }

    // Método para criar o menu mandando ele aparecer na tela
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        return true
    }
}