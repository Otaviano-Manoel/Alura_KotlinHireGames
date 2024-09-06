package br.yellow.hiregame.Utils

import java.util.Scanner

fun AskGamerString(read: Scanner, message: String): String{
    println(message)
        val answer = read.nextLine()
        return  answer
}

fun AskGamerInt(read: Scanner, message: String): Int{
    println(message)
    val answer = read.nextInt()
    return  answer
}
