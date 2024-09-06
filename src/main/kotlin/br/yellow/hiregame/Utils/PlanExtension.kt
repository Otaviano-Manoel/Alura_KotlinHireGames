import br.yellow.hiregame.data.PlanEntity
import br.yellow.hiregame.data.SinglePlanEntity
import br.yellow.hiregame.data.SubscriptionPlanEntity
import br.yellow.hiregame.models.Plan
import br.yellow.hiregame.models.SinglePlan
import br.yellow.hiregame.models.SubscriptionPlan

fun Plan.ToEntity(): PlanEntity{
    return  if(this is SubscriptionPlan){
        SubscriptionPlanEntity(this.type, this.id, this.monthPayment, this.gamesInclude, this.percentageDiscount)
    }
    else{
        SinglePlanEntity(this.type, this.id)
    }
}

fun PlanEntity.ToModel(): Plan{
    return  if(this is SubscriptionPlanEntity){
        SubscriptionPlan(this.type, this.id, this.monthPayment, this.gamesInclude, this.percentageDiscount)
    }
    else{
        SinglePlan(this.type, this.id)
    }
}