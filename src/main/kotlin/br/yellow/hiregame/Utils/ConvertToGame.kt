package br.yellow.hiregame.Utils

import br.yellow.hiregame.models.Game
import br.yellow.hiregame.models.InfoGame
import br.yellow.hiregame.models.InfoGameJson

fun InfoGameJson.ConvertToGame(): Game{
    return Game(this.titulo, this.capa,this.descricao, this.preco)
}