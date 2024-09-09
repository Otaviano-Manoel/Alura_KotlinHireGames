package br.yellow.hiregame.models

import java.math.BigDecimal

// Classe que representa um plano normal.
// Ele herda da class Plan.
class SinglePlan(type: String, id: Int = 0): Plan(type, id) {

    // Calcula o valor do jogo referente ao calculo deste tipo de plano
    override fun getValue(hireGame: HireGame): BigDecimal {
        // pega o valor inteiro do jogo
        var valueInitial = super.getValue(hireGame)

        // se tiver uma recomendação acima de 8 ele faz um desconto de 10%
        if(hireGame.gamer.average >= 8){
            // entrega o desconto.
            valueInitial -= valueInitial.multiply(BigDecimal("0.1"))
        }
        // retorna o valor apos o desconto, ou o valor inteiro caso não atenda ao requisitos de desconto.
        return  valueInitial
    }
}