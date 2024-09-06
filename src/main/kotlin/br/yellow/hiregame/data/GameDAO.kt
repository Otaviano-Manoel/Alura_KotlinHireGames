package br.yellow.hiregame.data

import br.yellow.hiregame.Utils.ToEntity
import br.yellow.hiregame.Utils.ToModel
import br.yellow.hiregame.models.Game
import javax.persistence.EntityManager

class GameDAO (manager: EntityManager): DAO<GameEntity, Game>(manager, GameEntity::class.java){
    override fun ToEntity(model: Game): GameEntity {
        return model.ToEntity()
    }

    override fun ToModel(entity: GameEntity): Game {
        return entity.ToModel()
    }
}