package br.yellow.hiregame.models

import java.math.BigDecimal

class SinglePlan(type: String, id: Int = 0): Plan(type, id) {
    override fun getValue(hireGame: HireGame): BigDecimal {
        var valueInitial = super.getValue(hireGame)
        if(hireGame.gamer.average >= 8){
            valueInitial -= valueInitial.multiply(BigDecimal("0.1"))
        }
        return  valueInitial
    }
}