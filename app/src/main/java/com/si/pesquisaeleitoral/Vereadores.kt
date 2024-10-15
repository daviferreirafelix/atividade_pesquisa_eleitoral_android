package com.si.pesquisaeleitoral

class Vereadores {
    private val vereadoresGoias = arrayOf("VereadorGO1", "VereadorGO2", "VereadorGO3", "VereadorGO4")
    private val vereadoresMinas = arrayOf("VereadorMG1", "VereadorMG2", "VereadorMG3", "VereadorMG4")
    private val vereadoresSaoPaulo = arrayOf("VereadorSP1", "VereadorSP2", "VereadorSP3", "VereadorSP4")

    fun getVereadoresGoias() : Array<String>{
        return this.vereadoresGoias
    }

    fun getVereadoresMinas() : Array<String>{
        return this.vereadoresMinas
    }

    fun getVereadoresSaoPaulo() : Array<String>{
        return this.vereadoresSaoPaulo
    }
}