package br.yellow.hiregame.data

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.persistence.ManyToOne


@Entity
@Table(name = "gamers")
class GamerEntity (
    val name: String = "Name of the gamer",
    val email: String = "Email of the gamer",
    val dateBirth: String = "Datebirth",
    val user: String = "user",
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    @ManyToOne
    val plan: PlanEntity = SinglePlanEntity()
) {
}