package br.yellow.hiregame.models

import java.math.BigDecimal

class SubscriptionPlan(type: String, id: Int, val monthPayment: Double, val gamesInclude: Int, val percentageDiscount: BigDecimal): Plan(type, id) {
    override fun getValue(hireGame: HireGame): BigDecimal {
        val countGames = hireGame.gamer.HireGameinMonth(hireGame.period.month()).size+1
        return if(gamesInclude >= countGames){
            BigDecimal("0.0")
        }else {
            var valueInitial = super.getValue(hireGame)
            if(hireGame.gamer.average >= 8){
                valueInitial -= valueInitial.multiply(percentageDiscount)
            }
            return  valueInitial
        }
    }
}