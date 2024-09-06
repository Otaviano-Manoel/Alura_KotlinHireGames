package br.yellow.hiregame.models

import br.yellow.hiregame.Utils.ToTwoDecimalPlaces
import java.math.RoundingMode

data class HireGame(val gamer: Gamer, val game: Game, val period: PeriodHire) {
    val price = gamer.plan.getValue(this).setScale(2, RoundingMode.HALF_EVEN)
    override fun toString(): String {
        return "Aluguel do jogo ${game.title} por ${gamer.name} pelo valor R$$price"
    }

}