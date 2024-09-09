package br.yellow.hiregame.Utils

import java.util.Scanner

// Faz uma pergunta no console.
// Retorna a resposta.
fun AskGamerString(read: Scanner, message: String): String{
    println(message)
        val answer = read.nextLine()
        return  answer
}
