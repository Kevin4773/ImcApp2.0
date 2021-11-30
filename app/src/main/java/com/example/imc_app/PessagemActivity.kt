package com.example.imc_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class PessagemActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pessagem)
        supportActionBar!! .hide()

    }
}