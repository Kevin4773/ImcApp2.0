package com.example.imc_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.imc_app.utilts.calcularIdade
import org.w3c.dom.Text

class DashBoardActivity : AppCompatActivity() {

    lateinit var nome: TextView
    lateinit var profissao: TextView
    lateinit var altura: TextView
    lateinit var idade: TextView
    lateinit var pesarAgora: RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)
        supportActionBar!!.hide()

        nome = findViewById<TextView>(R.id.nome_dash)
        profissao = findViewById<TextView>(R.id.profissao_dash)
        altura = findViewById<TextView>(R.id.altura_dash)
        idade = findViewById<TextView>(R.id.idade_dash)
        pesarAgora = findViewById(R.id.pesar_agora)

        pesarAgora.setOnClickListener {
            val abrirPessagem = Intent(this, PessagemActivity::class.java)
            startActivity(abrirPessagem)
        }

        preencherDashboard()

    }

    private fun preencherDashboard() {
        val arquivo = getSharedPreferences("usuario", MODE_PRIVATE)
        val nascimento = arquivo.getString("Nascimento", "").toString()

        nome.text = arquivo.getString("nome", "")
        profissao.text = arquivo.getString("profissao", "")
        idade.text = calcularIdade(nascimento).toString()
        altura.text = arquivo.getFloat("altura", 0.0f).toString()

    }
}