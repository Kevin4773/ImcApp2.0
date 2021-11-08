package com.example.imc_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DashBoardActivity : AppCompatActivity() {

    lateinit var nome: TextView
    lateinit var profissao: TextView
    lateinit var altura: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)

        nome = findViewById<TextView>(R.id.nome_dash)
        profissao = findViewById<TextView>(R.id.profissao_dash)
        altura = findViewById<TextView>(R.id.altura_dash)

        preencherDashboard()

        supportActionBar!!.hide()
    }

    private fun preencherDashboard() {
        val arquivo = getSharedPreferences("usuario", MODE_PRIVATE)
        nome.text = arquivo.getString("nome", "")
        profissao.text = arquivo.getString("profissao", "")
        altura.text = arquivo.getFloat("altura", 0.0f).toString()
    }
}