import br.yellow.hiregame.data.GamerEntity
import br.yellow.hiregame.models.Gamer

// Transforma o Gamer no tipo GamerEntity que é utilizado no BD.
fun  Gamer.ToEntity(): GamerEntity{
    return GamerEntity(this.name, this.email, this.dateBirth!!, this.user!!, this.id, this.plan.ToEntity())
}

// Transforma o GamerEntity no tipo Gamer que é utilizado no codigo.
fun  GamerEntity.ToModel(): Gamer{
    val gamer = Gamer(this.name, this.email, this.dateBirth, this.user, this.id)
    gamer.plan = this.plan.ToModel()
    return gamer
}