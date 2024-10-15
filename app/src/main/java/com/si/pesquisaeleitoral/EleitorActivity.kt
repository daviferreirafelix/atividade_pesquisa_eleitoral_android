package com.si.pesquisaeleitoral

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EleitorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eleitor)


        val nomeView: TextView = findViewById(R.id.nomeViewEleitorActivity)
        val tituloView: TextView = findViewById(R.id.tituloViewEleitorActivity)
        val zonaView: TextView = findViewById(R.id.zonaViewEleitorActivity)
        val secaoView: TextView = findViewById(R.id.secaoViewEleitorActivity)
        val estadoView: TextView = findViewById(R.id.estadoViewEleitorActivity)
        val prefeitoView: TextView = findViewById(R.id.prefeitoViewEleitorActivity)
        val vereadorView: TextView = findViewById(R.id.vereadorViewEleitorActivity)



        val bundle = intent.extras

        val nome = bundle?.getString("Nome")
        val titulo = bundle?.getInt("Titulo")
        val zona = bundle?.getInt("Zona")
        val secao = bundle?.getInt("Secao")
        val estado = bundle?.getString("Estado")
        val prefeito = bundle?.getString("Prefeito")
        val vereador = bundle?.getString("Vereador")


        nomeView.text = nome.toString()
        tituloView.text = titulo.toString()
        zonaView.text = zona.toString()
        secaoView.text = secao.toString()
        estadoView.text = estado.toString()
        prefeitoView.text = prefeito.toString()
        vereadorView.text = vereador.toString()
    }
}