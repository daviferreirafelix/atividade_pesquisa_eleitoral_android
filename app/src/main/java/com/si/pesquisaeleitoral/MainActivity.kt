package com.si.pesquisaeleitoral

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val estados = Estados().getEstados()

    private val prefeitosGO = Prefeitos().getPrefeitosGoias()
    private val prefeitosMG = Prefeitos().getPrefeitosMinas()
    private val prefeitosSP = Prefeitos().getPrefeitosSaoPaulo()

    private val vereadoresGO = Vereadores().getVereadoresGoias()
    private val vereadoresMG = Vereadores().getVereadoresMinas()
    private val vereadoresSP = Vereadores().getVereadoresSaoPaulo()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        * Ao inicar o app, por padrão virão os prefeitos e vereadores do Goiás.
        * */

        val spinnerEstados: Spinner = findViewById(R.id.spinnerEstados)
        spinnerEstados.adapter = ArrayAdapter(this,
                                                     android.R.layout.simple_spinner_dropdown_item,
                                                     estados)

        val spinnerPrefeitos: Spinner = findViewById(R.id.spinnerPrefeitos)
        spinnerPrefeitos.adapter = ArrayAdapter(this,
            android.R.layout.simple_spinner_dropdown_item,
            prefeitosGO)

        val spinnerVereadores: Spinner = findViewById(R.id.spinnerVereadores)
        spinnerVereadores.adapter = ArrayAdapter(this,
            android.R.layout.simple_spinner_dropdown_item,
            vereadoresGO)

        /*
        * Altera dinamicamente os itens de Prefeito e Vereador ao selecionar um Estado diferente de Goiás
        * */

        spinnerEstados.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when (spinnerEstados.selectedItemPosition){
                    0 -> {
                        spinnerPrefeitos.adapter = ArrayAdapter(this@MainActivity,
                            android.R.layout.simple_spinner_dropdown_item,
                            prefeitosGO)

                        spinnerVereadores.adapter = ArrayAdapter(this@MainActivity,
                            android.R.layout.simple_spinner_dropdown_item,
                            vereadoresGO)
                    }

                    1 -> {
                        spinnerPrefeitos.adapter = ArrayAdapter(this@MainActivity,
                            android.R.layout.simple_spinner_dropdown_item,
                            prefeitosMG)

                        spinnerVereadores.adapter = ArrayAdapter(this@MainActivity,
                            android.R.layout.simple_spinner_dropdown_item,
                            vereadoresMG)
                    }

                    2 -> {
                        spinnerPrefeitos.adapter = ArrayAdapter(this@MainActivity,
                            android.R.layout.simple_spinner_dropdown_item,
                            prefeitosSP)

                        spinnerVereadores.adapter = ArrayAdapter(this@MainActivity,
                            android.R.layout.simple_spinner_dropdown_item,
                            vereadoresSP)
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }


    fun btnMostrarDados(view: View){
        val spinnerEstadosToInput: Spinner = findViewById(R.id.spinnerEstados)
        val spinnerPrefeitosToInput: Spinner = findViewById(R.id.spinnerPrefeitos)
        val spinnerVereadoresToInput: Spinner = findViewById(R.id.spinnerVereadores)

        val estadosInput = spinnerEstadosToInput.selectedItemPosition

        val nome: String = findViewById<TextView?>(R.id.campoNome).text.toString()

        val tituloTxt: String = findViewById<TextView?>(R.id.campoTitulo).text.toString()
        val tituloNumber = tituloTxt.toIntOrNull() ?: 0

        val zonaTxt: String = findViewById<TextView?>(R.id.campoZona).text.toString()
        val zonaNumber = zonaTxt.toIntOrNull() ?: 0

        val secaoTxt: String = findViewById<TextView?>(R.id.campoSecao).text.toString()
        val secaoNum = secaoTxt.toIntOrNull() ?: 0


        val bundle = Bundle()

        when (estadosInput) {
            0 -> {
                bundle.putString("Nome", nome)
                bundle.putInt("Título de Eleitor", tituloNumber)
                bundle.putInt("Zona", zonaNumber)
                bundle.putInt("Secao", secaoNum)
                bundle.putString("Estado", estados[0])
                bundle.putString("Prefeito", spinnerPrefeitosToInput.selectedItem.toString())
                bundle.putString("Vereador", spinnerVereadoresToInput.selectedItem.toString())
            }

            1 -> {
                bundle.putString("Nome", nome)
                bundle.putInt("Título de Eleitor", tituloNumber)
                bundle.putInt("Zona", zonaNumber)
                bundle.putInt("Seção", secaoNum)
                bundle.putString("Estado", estados[1])
                bundle.putString("Prefeito", spinnerPrefeitosToInput.selectedItem.toString())
                bundle.putString("Vereador", spinnerVereadoresToInput.selectedItem.toString())
            }

            2 -> {
                bundle.putString("Nome", nome)
                bundle.putInt("Título", tituloNumber)
                bundle.putInt("Zona", zonaNumber)
                bundle.putInt("Secao", secaoNum)
                bundle.putString("Estado", estados[2])
                bundle.putString("Prefeito", spinnerPrefeitosToInput.selectedItem.toString())
                bundle.putString("Vereador", spinnerVereadoresToInput.selectedItem.toString())
            }
        }


        val intent = Intent(this, EleitorActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}