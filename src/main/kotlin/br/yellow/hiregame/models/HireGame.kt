package br.yellow.hiregame.models

import br.yellow.hiregame.Utils.ToTwoDecimalPlaces
import java.math.RoundingMode

//Data classe que guarda um alugel e o preço
data class HireGame(val gamer: Gamer, val game: Game, val period: PeriodHire) {
    var id = 0;
    // Ele calcula o preço do jogo referente a seu plano e arredonda para duas casas apos a virgula.
    val price = gamer.plan.getValue(this).setScale(2, RoundingMode.HALF_EVEN)

    // Sobrescreve o ToString() para melhorar a visualização da classe.
    override fun toString(): String {
        return "Aluguel do jogo ${game.title} por ${gamer.name} pelo valor R$$price"
    }
}