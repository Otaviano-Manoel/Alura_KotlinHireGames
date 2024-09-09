package br.yellow.hiregame.models

// Interface para guardar as recomendações
// isto se aplica ao jogo e ao jogador
interface Recommended {
    // a media das recomendações
    val average: Double

    // adiciona uma recomendação a lista de recomendação.
    fun recommend(value: Int)
}