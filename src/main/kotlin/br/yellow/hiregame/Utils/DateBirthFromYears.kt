package br.yellow.hiregame.Utils

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter
import javax.swing.text.DateFormatter

fun String.ConvertDateBirthFromYears(): Int{
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val dateBirth = LocalDate.parse(this, formatter)
    val now = LocalDate.now()
    val years = Period.between(dateBirth, now).years
    return years
}