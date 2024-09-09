package br.yellow.hiregame.data

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.persistence.ManyToOne


// Indica que a classe é uma entitdade do BD
@Entity
// Seta o nome da tabela a qual a classe pertence
@Table(name = "gamers")
// Classe da Entidade que sera salvo no BD
// Nenhuma de suas variaveis podem ser nulas.
class GamerEntity (
    val name: String = "Name of the gamer",
    val email: String = "Email of the gamer",
    val dateBirth: String = "Datebirth",
    val user: String = "user",
    // Id indica a chave primaria
    // GenerateValue = faz o auto incremento no ID para não repetir.
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    // Indica que varios gamers podem ter um unico plano
    @ManyToOne
    val plan: PlanEntity = SinglePlanEntity()
) {
}