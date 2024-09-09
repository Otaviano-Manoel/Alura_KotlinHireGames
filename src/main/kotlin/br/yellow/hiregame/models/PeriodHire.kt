package br.yellow.hiregame.models

import java.time.LocalDate
import java.time.Month
import java.time.Period

import javax.persistence.Embeddable

// Informa que esta classe esta sendo incorporada no HireEntity
@Embeddable
// Data Class para guardar o periodo do aluguel.
data class PeriodHire(val dateInitial: LocalDate = LocalDate.now(), val dateEnd: LocalDate = LocalDate.now().plusDays(7)){
    // Calcula o periodo do aluguel em dias.
    var inDays =Period.between(dateInitial, dateEnd).days

    // Retorna o mes que o aluguel começou.
    fun month(): Month {
        return dateInitial.month
    }
}
