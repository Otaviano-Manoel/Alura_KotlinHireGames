package br.yellow.hiregame.Utils

import java.text.DecimalFormat

fun Double.ToTwoDecimalPlaces(): Double{
    val decimalFormat = DecimalFormat("#.##")
    return decimalFormat.format(this).toDouble()
}