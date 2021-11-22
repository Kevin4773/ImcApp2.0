package com.example.imc_app.utilts

import android.util.Log
import java.time.LocalDate
import java.time.Period

fun calcularIdade(dataNascimento: String): Int {

    val data = dataNascimento.split("/")

    Log.i("xpto", data.get(0))
    Log.i("xpto", data.get(1))
    Log.i("xpto", data.get(2))

    // Obter a data atual
    val hoje = LocalDate.now()

    // Convertar a dataNascimento que é string em LocalDate
    val nascimento = LocalDate.of(
            data.get(0).toInt(),
            data.get(1).toInt(),
            data.get(2).toInt())

    // Calculo do periodo entre datas
    val idade = Period.between(nascimento, hoje).years.toString()

    Log.i("xpto", idade)

    return 0

}