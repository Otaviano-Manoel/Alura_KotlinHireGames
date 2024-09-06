package br.yellow.hiregame.models

import br.yellow.hiregame.Utils.ToTwoDecimalPlaces
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Game(
    @Expose @SerializedName("titulo") val title: String,
    @Expose @SerializedName("capa") val thumb: String): Recommended{
    var description: String? = null
    var price: Double? = null
    var id: Int = 0

    private var recommendations = mutableListOf<Int>()

    override val average: Double
        get() = recommendations.average().ToTwoDecimalPlaces()

    override fun recommend(value: Int) {
        recommendations.add(value)
    }

    constructor(title: String,thumb: String,description: String, price: Double): this(title, thumb){
        this.description = description
        this.price = price
    }

    constructor(title: String,thumb: String,description: String, price: Double, id: Int): this(title, thumb, description, price){
        this.id = id
    }

    override fun toString(): String {
        return "Game(id='$id' title='$title', thumb='$thumb', description=$description, price=$price)"
    }

}
