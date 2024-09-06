package br.yellow.hiregame.data

import br.yellow.hiregame.models.EnumPlan
import javax.persistence.Entity
import javax.persistence.DiscriminatorValue

@Entity
@DiscriminatorValue("Single")
class SinglePlanEntity(type: String = EnumPlan.Single.toString(), id: Int = 0): PlanEntity(type, id) {
}