package br.yellow.hiregame.models

import br.yellow.hiregame.Utils.AskGamerString
import br.yellow.hiregame.Utils.ToTwoDecimalPlaces
import com.google.gson.GsonBuilder
import java.io.File
import java.time.Month
import java.util.Scanner
import kotlin.random.Random

data class Gamer(val name: String, val email: String): Recommended{
    var dateBirth: String? = null
        set(value) {
            field = value
            val regex = """^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\d{4}$""".toRegex()
            if(dateBirth?.let { regex.matches(it) } == false){
                throw IllegalArgumentException("Date Birth Invalid, format dd/mm/yyyy")
            }
        }
    var user: String? = null
        set(value) {
            field = value
        }
    var id: Int = 0

    var games = mutableListOf<Game?>()

    var hireGames = mutableListOf<HireGame>()

    var plan: Plan = SinglePlan(EnumPlan.BRONZE.toString())

    private var recommendations = mutableListOf<Int>()

    override val average: Double
        get() = recommendations.average().ToTwoDecimalPlaces()

    val recommendedGames = mutableListOf<Game>()

    constructor(name: String, email: String, dateBirth: String, user: String): this(name, email)
    {
        this.dateBirth = dateBirth
        this.user = user
    }
    constructor(name: String, email: String, dateBirth: String, user: String, id: Int): this(name, email, dateBirth, user)
    {
        this.id = id;
    }
    init {
        if(name.isBlank()){
             throw IllegalArgumentException("Name is blank or null")
        }

        val regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$".toRegex()
        if(!regex.matches(email)){
            throw  IllegalArgumentException("Email invalid")
        }
    }

    fun SortedByTitlesGames(): MutableList<Game?>{
        games.sortBy { it?.title }
        return games
    }
    fun RemoveGame(position: Int): MutableList<Game?>{
        games.removeAt(position)
        return  games
    }
    fun FilterTitleGame(filter: String): List<Game?> {
        return  games.filter { it?.title?.contains(filter, true)?: false }
    }

    fun HireGame(game: Game, periodHire: PeriodHire): HireGame{
        val hireGame = HireGame(this, game, periodHire)
        hireGames.add(hireGame)
        return hireGame
    }
    fun HireGameinMonth(month: Month): List<HireGame> {
        val hireGamesinMonth = hireGames.filter { it.period.month() == month}
        return hireGamesinMonth
    }

    override fun toString(): String {
        return "Gamer(name='$name', email='$email', dateBirth=$dateBirth, user=$user, Average=$average, Id=$id"
    }

    override fun recommend(value: Int) {
        if(value > 10 || value < 0){
            println("The value entered must be between 0 and 10")
            return
        }
        recommendations.add(value)
    }

    fun recommendGame(game: Game, value: Int){
        game.recommend(value)
        recommendedGames.add(game)
    }

    fun ShareGame(){
        val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
        val serialize = gson.toJson(recommendedGames)
        val file = File("Recommendation-$name.json")
        file.writeText(serialize)
        println(file.absoluteFile)
    }

    companion object{
        fun CreateGamer(read: Scanner): Gamer{
            val name = AskGamerString(read, "Digit your name:")
            val email = AskGamerString(read, "Digit your email")
            val option = AskGamerString(read, "Do you want to fill in date of birth and user? Y/N")

            if(option.equals("y", true)){
                val date = AskGamerString(read, "Digit your birth date (dd/mm/yyyy):")
                val user = AskGamerString(read, "Digit you username:")
                return  Gamer(name, email, date, user)
            }

            return Gamer(name, email)
        }
    }
}
