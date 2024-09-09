package br.yellow.hiregame.models

// Data classe para pegar as informaões dos jogos da API SHARK
data class InfoGame(val info: List<Game>){
    override fun toString(): String {
        return info.toString()
    }
}
