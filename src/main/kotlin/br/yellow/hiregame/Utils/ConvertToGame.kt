package br.yellow.hiregame.Utils

import br.yellow.hiregame.models.Game
import br.yellow.hiregame.models.InfoGame
import br.yellow.hiregame.models.InfoGameJson

// Converto do tipo InfoGameJson para o tipo Game
fun InfoGameJson.ConvertToGame(): Game{
    return Game(this.titulo, this.capa,this.descricao, this.preco)
}