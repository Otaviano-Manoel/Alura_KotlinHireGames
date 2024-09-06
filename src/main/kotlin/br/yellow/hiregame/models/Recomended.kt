package br.yellow.hiregame.models

interface Recommended {
    val average: Double

    fun recommend(value: Int)
}