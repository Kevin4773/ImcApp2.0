package com.example.imc_app.utilts

import android.util.Log
import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder

fun calcularIdade(dataNascimento: String): Int {

    val hoje = LocalDate.now()
    val data = dataNascimento.split("/")

    /*Log.i("xpto", data.get(0))
    Log.i("xpto", data.get(1))
    Log.i("xpto", data.get(2))*/

    // Obter a data atual


    // Convertar a dataNascimento que é string em LocalDate
    val nascimento = LocalDate.of(data.get(2).toInt(), data.get(1).toInt(), data.get(0).toInt())

    // Calculo do periodo entre datas
    val idade = Period.between(nascimento, hoje).years

    return idade

    // Log.i("xpto", dataNascimento.toString())

    //Log.i("xpto", idade.toString())

}

fun converteDataParaPortuguesBrasil(data: LocalDate): String {

    // ** Esse é o formato que queremos para a data
    val formatoBrasil = DateTimeFormatter.ofPattern("dd/MM/yyyy")

    val dataBrasil = data.format(formatoBrasil)

    return  dataBrasil.toString()

}