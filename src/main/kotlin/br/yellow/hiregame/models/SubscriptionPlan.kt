package br.yellow.hiregame.models

import java.math.BigDecimal

// Classe que representa um plano mensal.
// Ele herda da class Plan
class SubscriptionPlan(type: String, id: Int, val monthPayment: Double, val gamesInclude: Int, val percentageDiscount: BigDecimal): Plan(type, id) {
    // Ele calcula o valor do jogo referente ao tipo de plano mensal.
    override fun getValue(hireGame: HireGame): BigDecimal {
        // Guarda o quantia de jogos alugados.
        val countGames = hireGame.gamer.HireGameinMonth(hireGame.period.month()).size+1
        // Se a quantia de jogos alugados forem menor do que a quantia que o plano cobre.
        // ele retorna 0 porque o valor a ser pago é do proprio plano e não do jogo.
        return if(gamesInclude >= countGames){
            BigDecimal("0.0")
        }
        // Se a quantia de jogos forem maior do que quantia de jogos permitido pelo plano
        else {
            // ele calcula o valor do jogo.
            var valueInitial = super.getValue(hireGame)
            // se a recomendação for maior que 8 ele aplica um desconto de 10%
            if(hireGame.gamer.average >= 8){
                // ele aplica o desconto de 10%
                valueInitial -= valueInitial.multiply(percentageDiscount)
            }
            // retornar o valor do jogo que passar da quantia de jogos permitido pelo plano.
            // o valor pode ser o inteiro ou com 10% de desconto.
            return  valueInitial
        }
    }
}