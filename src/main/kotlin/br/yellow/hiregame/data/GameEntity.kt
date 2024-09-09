package br.yellow.hiregame.data

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

// Indica que a classe é uma entitdade do BD
@Entity
// Seta o nome da tabela a qual a classe pertence
@Table(name = "games")
// Classe da Entidade que sera salvo no BD
// Nenhuma de suas variaveis podem ser nulas.
class GameEntity ( val title: String = "Title of the Game",
                   val thumb: String = "Thumb of the Game",
                   var description: String? = null,
                   var price: Double = 0.0,
                   // Id indica a chave primaria
                   // GenerateValue = faz o auto incremento no ID para não repetir.
                   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
                   var id: Int = 0) {
}