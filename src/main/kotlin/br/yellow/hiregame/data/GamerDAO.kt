package br.yellow.hiregame.data

import ToEntity
import ToModel
import br.yellow.hiregame.models.Gamer
import javax.persistence.EntityManager

class GamerDAO (manager: EntityManager): DAO<GamerEntity, Gamer>(manager, GamerEntity::class.java) {
    override fun ToEntity(model: Gamer): GamerEntity {
        return model.ToEntity()
    }

    override fun ToModel(entity: GamerEntity): Gamer {
        return entity.ToModel()
    }
}