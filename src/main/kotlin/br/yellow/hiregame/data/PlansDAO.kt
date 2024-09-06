package br.yellow.hiregame.data

import ToEntity
import ToModel
import br.yellow.hiregame.models.Plan
import javax.persistence.EntityManager

class PlansDAO(manager: EntityManager): DAO<PlanEntity, Plan>(manager, PlanEntity::class.java) {
    override fun ToEntity(model: Plan): PlanEntity {
        return model.ToEntity()
    }

    override fun ToModel(entity: PlanEntity): Plan {
        return entity.ToModel()
    }
}