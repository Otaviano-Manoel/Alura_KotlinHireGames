package br.yellow.hiregame.data

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "games")
class GameEntity ( val title: String = "Title of the Game",
                   val thumb: String = "Thumb of the Game",
                   var description: String? = null,
                   var price: Double = 0.0,
                   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
                   var id: Int = 0) {
}