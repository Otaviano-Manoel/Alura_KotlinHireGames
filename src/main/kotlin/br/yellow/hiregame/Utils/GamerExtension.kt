import br.yellow.hiregame.data.GamerEntity
import br.yellow.hiregame.models.Gamer

fun  Gamer.ToEntity(): GamerEntity{
    return GamerEntity(this.name, this.email, this.dateBirth!!, this.user!!, this.id, this.plan.ToEntity())
}

fun  GamerEntity.ToModel(): Gamer{
    val gamer = Gamer(this.name, this.email, this.dateBirth, this.user, this.id)
    gamer.plan = this.plan.ToModel()
    return gamer
}