package br.yellow.hiregame.models

data class InfoGame(val info: List<Game>){
    override fun toString(): String {
        return info.toString()
    }
}
