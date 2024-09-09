package br.yellow.hiregame.Utils

import br.yellow.hiregame.data.GameEntity
import br.yellow.hiregame.models.Game

// Transforma o Game no tipo GameEntity que é utilizado no BD.
fun Game.ToEntity(): GameEntity{
    return GameEntity(this.title, this.thumb, this.description, this.price!!, this.id)
}

// Transforma o GameEntity no tipo Game que é utilizado no codigo.
fun GameEntity.ToModel():Game{
    return Game(this.title, this.thumb, this.description!!, this.price, this.id)
}