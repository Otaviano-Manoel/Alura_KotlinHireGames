package br.yellow.hiregame.Utils

import br.yellow.hiregame.data.GameEntity
import br.yellow.hiregame.models.Game

fun Game.ToEntity(): GameEntity{
    return GameEntity(this.title, this.thumb, this.description, this.price!!, this.id)
}

fun GameEntity.ToModel():Game{
    return Game(this.title, this.thumb, this.description!!, this.price, this.id)
}