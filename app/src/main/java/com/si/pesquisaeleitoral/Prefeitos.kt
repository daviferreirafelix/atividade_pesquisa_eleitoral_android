package com.si.pesquisaeleitoral

class Prefeitos {
    private val prefeitosGoias = arrayOf("PrefeitoGO1", "PrefeitoGO2", "PrefeitoGO3", "PrefeitoGO4")
    private val prefeitosMinas = arrayOf("PrefeitoMG1", "PrefeitoMG2", "PrefeitoMG3", "PrefeitoMG4")
    private val prefeitosSaoPaulo = arrayOf("PrefeitoSP1", "PrefeitoSP2", "PrefeitoSP3", "PrefeitoSP4")

    fun getPrefeitosGoias() : Array<String>{
        return this.prefeitosGoias
    }

    fun getPrefeitosMinas() : Array<String>{
        return this.prefeitosMinas
    }

    fun getPrefeitosSaoPaulo() : Array<String>{
        return this.prefeitosSaoPaulo
    }
}