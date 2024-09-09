package br.yellow.hiregame.models

import java.math.BigDecimal

// Abstrata Classe que guarda o plano do jogador.
abstract class Plan(val type: String, var id: Int = 0) {
    // retornar o valor do plano.
    open fun getValue(hireGame: HireGame): BigDecimal {
        // calculo padrão, que multiplica o valor do jogo pelos dias alugados.
        return hireGame.game.price?.times(hireGame.period.inDays)!!.toBigDecimal()    }
}