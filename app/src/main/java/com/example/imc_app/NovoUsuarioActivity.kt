package com.example.imc_app

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import java.util.*

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

        // Criar um calendário
        // *** Obter a data atual (hoje)

        // Classe responsável por gerenciar o calendario
        val calendario = Calendar.getInstance()
        val dia = calendario.get(Calendar.DAY_OF_MONTH)
        val mes = calendario.get(Calendar.MONTH)
        val ano = calendario.get(Calendar.YEAR)

        // Colocar um Listner de click no editText data de nascimento
        // Para abrir o calendário (DataPicker)

        editDataNascimento.setOnClickListener {

            val datePicker = DatePickerDialog(this, DatePickerDialog.OnDateSetListener{ view, _ano, _mes, _dia ->

                var mesReal = _mes + 1

                var diaString = "$_dia"
                var mesString = "$mesReal"

                if (mesReal < 10) {
                    mesString = "0$mesReal"
                }

                if (_dia < 10) {
                    diaString = "0$_dia"
                }

                Log.i("xxxx", "$diaString/$mesString/$_ano")
                editDataNascimento.setText("$diaString/$mesString/$_ano")

            }, ano, mes, dia)

            datePicker.show()

        }

    }

    // Método para criar o menu mandando ele aparecer na tela
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (validarCampos()) {
            // gravar os dados no sharedPreferences
            val arquivo = getSharedPreferences("usuario", MODE_PRIVATE)
            val editor = arquivo.edit()

            editor.putString("email", editEmail.text.toString())
            editor.putString("senha", editSenha.text.toString())
            editor.putString("nome", editNome.text.toString())
            editor.putString("profissao", editProfissao.text.toString())
            editor.putFloat("altura", editAltura.text.toString().toFloat())
            editor.putString("nascimento", editDataNascimento.text.toString())
            editor.putString("sexo", if (radioMasculino.isChecked) "M" else "F")
            editor.apply()

            Toast.makeText(this, "Usuário cadastrado com sucesso", Toast.LENGTH_SHORT).show()
            finish()
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

        if(editNome.text.isEmpty()) {
            editNome.error = "Nome é obrigatório"
            valido = false
        }

        if (editAltura.text.isEmpty()) {
            editAltura.error = "Altura é obrigatório"
            valido = false
        }

        if (editPeso.text.isEmpty()) {
            editPeso.error = "Peso é obrigatório"
        }

        if (editDataNascimento.text.isEmpty()) {
            editDataNascimento.error = "Data de nascimento é obrigatório"
        }

        if (!radioFeminino.isChecked && !radioMasculino.isChecked) {
            radioMasculino.error = "Gênero é obrigatório"
            valido = false
        }

        return valido
    }
}