package br.yellow.hiregame.data

import br.yellow.hiregame.models.PeriodHire
import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.persistence.Embedded
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

// Indica que a classe é uma entitdade do BD
@Entity
// Seta o nome da tabela a qual a classe pertence
@Table (name = "hire")
// Classe da Entidade que sera salvo no BD
// Nenhuma de suas variaveis podem ser nulas.
class HireEntity(
    // Indica que varios alugueis podem ter um unico jogador
    @ManyToOne
    val gamer: GamerEntity = GamerEntity(),
    // Indica que varios alugueis podem ter um jogo
    @ManyToOne
    val game: GameEntity = GameEntity(),

    // Incorpora o PeriodHire como parte da entitdade
    @Embedded
    val period: PeriodHire = PeriodHire()){

    var hireValue = 0.0

    // Id indica a chave primaria
    // GenerateValue = faz o auto incremento no ID para não repetir.
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = 0

}