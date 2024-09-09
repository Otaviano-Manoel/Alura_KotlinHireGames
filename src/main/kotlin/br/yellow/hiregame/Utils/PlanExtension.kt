import br.yellow.hiregame.data.PlanEntity
import br.yellow.hiregame.data.SinglePlanEntity
import br.yellow.hiregame.data.SubscriptionPlanEntity
import br.yellow.hiregame.models.Plan
import br.yellow.hiregame.models.SinglePlan
import br.yellow.hiregame.models.SubscriptionPlan

// Transforma o Plan no tipo PlanEntity que é utilizado no BD.
fun Plan.ToEntity(): PlanEntity{
    // verifica qual o tipo do plano antes de fazer a conversão.
    return  if(this is SubscriptionPlan){
        SubscriptionPlanEntity(this.type, this.id, this.monthPayment, this.gamesInclude, this.percentageDiscount)
    }
    else{
        SinglePlanEntity(this.type, this.id)
    }
}

// Transforma o PlanEntity no tipo Plan que é utilizado no codigo.
fun PlanEntity.ToModel(): Plan{
    // verifica qual o tipo do plano antes de fazer a conversão.
    return  if(this is SubscriptionPlanEntity){
        SubscriptionPlan(this.type, this.id, this.monthPayment, this.gamesInclude, this.percentageDiscount)
    }
    else{
        SinglePlan(this.type, this.id)
    }
}