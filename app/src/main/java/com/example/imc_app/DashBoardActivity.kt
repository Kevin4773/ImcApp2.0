package com.example.imc_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.imc_app.utilts.calcularIdade
import org.w3c.dom.Text

class DashBoardActivity : AppCompatActivity() {

    lateinit var nome: TextView
    lateinit var profissao: TextView
    lateinit var altura: TextView
    lateinit var txt_idade: TextView
    lateinit var pesarAgora: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)
        supportActionBar!!.hide()

        nome = findViewById<TextView>(R.id.nome_dash)
        profissao = findViewById<TextView>(R.id.profissao_dash)
        altura = findViewById<TextView>(R.id.altura_dash)
        txt_idade = findViewById(R.id.idade_dash)
        pesarAgora = findViewById(R.id.pesar_agora)

        pesarAgora.setOnClickListener {
            val abrirPessagem = Intent(this, activity_pessagem2::class.java)
            startActivity(abrirPessagem)
        }

        preencherDashboard()

    }

    private fun preencherDashboard() {
        val arquivo = getSharedPreferences("usuario", MODE_PRIVATE)
        val nascimento = arquivo.getString("nascimento", "").toString()
        val idade = calcularIdade(nascimento).toString().toInt()

        nome.text = arquivo.getString("nome", "")
        txt_idade.text = idade.toString()
        profissao.text = arquivo.getString("profissao", "")
        altura.text = arquivo.getFloat("altura", 0.0f).toString()

    }
}