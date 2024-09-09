package br.yellow.hiregame.models

import br.yellow.hiregame.Utils.ToTwoDecimalPlaces
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

// Classe que representa o jogo
data class Game(
    // Expose inclui o "title" na serialização, isto foi feito no segundo curso.
    // SerializedName define o nome da variavel apos a serialização.
    @Expose @SerializedName("titulo") val title: String,
    // Expose inclui o "title" na serialização, isto foi feito no segundo curso.
    // SerializedName define o nome da variavel apos a serialização.
    @Expose @SerializedName("capa") val thumb: String): Recommended{
    var description: String? = null
    var price: Double? = null
    var id: Int = 0

    private var recommendations = mutableListOf<Int>()

    // Calcula a media das recomendações
    override val average: Double
        // formata para duas casas apos a virgula.
        get() = recommendations.average().ToTwoDecimalPlaces()

    // Adiciona uma nova recomendação a lista de recomendações.
    override fun recommend(value: Int) {
        recommendations.add(value)
    }

    // Contrutor da classe incluindo as variaveis (description, price)
    constructor(title: String,thumb: String,description: String, price: Double): this(title, thumb){
        this.description = description
        this.price = price
    }

    // Contrutor da classe incluindo o (id)
    constructor(title: String,thumb: String,description: String, price: Double, id: Int): this(title, thumb, description, price){
        this.id = id
    }

    // Sobrescreve o ToString() para uma melhor visualização da classe.
    override fun toString(): String {
        return "Game(id='$id' title='$title', thumb='$thumb', description=$description, price=$price)"
    }

}
