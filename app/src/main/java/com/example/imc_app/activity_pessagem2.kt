package com.example.imc_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.imc_app.utilts.converteDataParaPortuguesBrasil
import java.time.LocalDate

class activity_pessagem2 : AppCompatActivity() {

    lateinit var  tvDataPessagem: TextView
    lateinit var  buttonRegistarPeso: Button
    lateinit var  editNovoPeso: EditText
    lateinit var  spinnerAtividades: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pessagem2)

        tvDataPessagem = findViewById(R.id.tv_data_pessagem)

        tvDataPessagem.text = converteDataParaPortuguesBrasil(LocalDate.now())

        buttonRegistarPeso = findViewById(R.id.button_registar_peso)

        editNovoPeso = findViewById(R.id.peso_pessagem)

        spinnerAtividades = findViewById(R.id.spinner_pessagem)

        buttonRegistarPeso.setOnClickListener {

            gravarPeso()

        }


    }

    private fun gravarPeso() {

        val arquivo = getSharedPreferences("usuario", MODE_PRIVATE)
        val editor = arquivo.edit()

        val peso = arquivo.getString("peso", "")
        val dataPessagem = arquivo.getString("data_pesagem", "")

        editor.putString("data_pesagem", "$dataPessagem;${LocalDate.now()}")
        editor.putString("peso", "${peso};${editNovoPeso.text.toString()}")
        editor.putInt("nivel_atividade", spinnerAtividades.selectedItemPosition)

        editor.commit()

    }
}