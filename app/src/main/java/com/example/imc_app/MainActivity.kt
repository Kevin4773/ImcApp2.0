package com.example.imc_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

        val buttonEntrar = findViewById<Button>(R.id.button_entrar)
        val editEmail = findViewById<TextView>(R.id.email_login)
        val editSenha = findViewById<TextView>(R.id.senha_login)
        val buttonNovoUsuario = findViewById<Button>(R.id.button_nova_conta)

        buttonEntrar.setOnClickListener {

            val arquivo = getSharedPreferences("usuario", MODE_PRIVATE)
            val email = arquivo.getString("email", "")
            val senha = arquivo.getString("senha", "")

            if (email == editEmail.text.toString() && senha == editSenha.text.toString()) {
                val entrar = Intent(this, DashBoardActivity::class.java)
                startActivity(entrar)
            }else {
                Toast.makeText(this, "Senha ou usuário incorretos", Toast.LENGTH_SHORT).show()
            }

        }

        buttonNovoUsuario.setOnClickListener {
            val abrirNovaConta = Intent(this, NovoUsuarioActivity::class.java)
            startActivity(abrirNovaConta)
        }

    }
}