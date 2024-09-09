package br.yellow.hiregame.Utils

import java.text.DecimalFormat

// Formata o Double para duas casas apos a virgula.
fun Double.ToTwoDecimalPlaces(): Double{
    // Defini o formato que eu quero.
    val decimalFormat = DecimalFormat("#.##")
    // aplica o formato.
    return decimalFormat.format(this).toDouble()
}