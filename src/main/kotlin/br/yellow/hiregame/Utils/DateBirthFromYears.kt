package br.yellow.hiregame.Utils

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter
import javax.swing.text.DateFormatter

// Pega a data de nascimento e retorna quantos anos o jogador possui.
fun String.ConvertDateBirthFromYears(): Int{
    // define o padrão que eu quero.
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    // converte para o formato que pedi, e retornar um LocalDate
    val dateBirth = LocalDate.parse(this, formatter)
    // Pega o dia atual.
    val now = LocalDate.now()
    // Calcula a diferenca de hoje para o dia em que o jogador nasceu.
    val years = Period.between(dateBirth, now).years
    // retorna os anos que o jogador possui.
    return years
}