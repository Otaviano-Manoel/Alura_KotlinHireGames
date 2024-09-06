package br.yellow.hiregame.models

import java.time.LocalDate
import java.time.Month
import java.time.Period

data class PeriodHire(val dateInitial: LocalDate, val dateEnd: LocalDate){
    fun inDays(): Int{
        return Period.between(dateInitial, dateEnd).days
    }

    fun month(): Month {
        return dateInitial.month
    }
}
