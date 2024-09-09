package br.yellow.hiregame.data

import br.yellow.hiregame.models.EnumPlan
import javax.persistence.Entity
import javax.persistence.DiscriminatorValue

// Indica que a classe é uma entitdade do BD
@Entity
// O nome da classe que sera colocada na coluna descriminada na superclasse.
@DiscriminatorValue("Single")
class SinglePlanEntity(type: String = EnumPlan.Single.toString(), id: Int = 0): PlanEntity(type, id) {
}