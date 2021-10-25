package com.example.imc_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.RadioButton

class NovoUsuarioActivity : AppCompatActivity() {

    lateinit var editNome: EditText
    lateinit var editEmail: EditText
    lateinit var editSenha: EditText
    lateinit var editProfissao: EditText
    lateinit var editAltura: EditText
    lateinit var editPeso: EditText
    lateinit var editDataNascimento: EditText
    lateinit var radioMasculino: RadioButton
    lateinit var radioFeminino: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novo_usuario)

        editNome = findViewById(R.id.nome_login)
        editEmail = findViewById(R.id.email_login)
        editSenha = findViewById(R.id.senha_login)
        editProfissao = findViewById(R.id.profissao_login)
        editAltura = findViewById(R.id.altura_login)
        editPeso = findViewById(R.id.peso_login)
        editDataNascimento = findViewById(R.id.data_nascimento_login)
        radioMasculino = findViewById(R.id.sexo_m_login)
        radioFeminino = findViewById(R.id.sexo_f_login)

        supportActionBar!!.title = "Nova Conta"
    }

    // Método para criar o menu mandando ele aparecer na tela
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (validarCampos()) {
            // gravar os dados
            
        } else {
            // gravo nada!!
        }

        return true
    }

    private fun validarCampos() : Boolean {
        var valido = true

        if(editEmail.text.isEmpty()) {
            editEmail.error = "E-mail é obrigatório!"
            valido = false
        }

        if(editSenha.text.isEmpty()) {
            editSenha.error = "Senha é obrigatório"
            valido = false
        }

        return valido
    }
}