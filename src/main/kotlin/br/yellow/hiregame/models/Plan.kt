package br.yellow.hiregame.models

import java.math.BigDecimal

abstract class Plan(val type: String, var id: Int = 0) {
    open fun getValue(hireGame: HireGame): BigDecimal {
        return hireGame.game.price?.times(hireGame.period.inDays())!!.toBigDecimal()    }
}