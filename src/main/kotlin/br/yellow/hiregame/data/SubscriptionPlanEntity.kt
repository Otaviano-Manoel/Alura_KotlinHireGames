package br.yellow.hiregame.data

import br.yellow.hiregame.models.EnumPlan
import java.math.BigDecimal
import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

// Indica que a classe é uma entitdade do BD
@Entity
// O nome da classe que sera colocada na coluna descriminada na superclasse.
@DiscriminatorValue("Subscription")
class SubscriptionPlanEntity(
    type: String = EnumPlan.Subscription.toString(),
    id: Int = 0,
    val monthPayment: Double = 0.0,
    val gamesInclude: Int = 0,
    val percentageDiscount: BigDecimal = BigDecimal.ZERO
) : PlanEntity(type, id) {
}