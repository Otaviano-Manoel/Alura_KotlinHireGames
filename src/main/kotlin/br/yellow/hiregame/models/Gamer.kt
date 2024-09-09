package br.yellow.hiregame.models

import br.yellow.hiregame.Utils.AskGamerString
import br.yellow.hiregame.Utils.ToTwoDecimalPlaces
import com.google.gson.GsonBuilder
import java.io.File
import java.time.Month
import java.util.Scanner
import kotlin.random.Random

// Classe que representa o Gamer
data class Gamer(val name: String, val email: String): Recommended{


    var dateBirth: String? = null
        // Ao setar a data de nascimento ele valida o formato padrão.
        set(value) {
            // Guarda o novo valor da data de nascimento
            field = value
            // formato padrão (dd/mm/aaaa)
            val regex = """^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\d{4}$""".toRegex()
            // valida a formatação para saber se os dados estão corretos.
            if(dateBirth?.let { regex.matches(it) } == false){
                // caso não esteja correto ele retorna uma exceção de argumento ilegal.
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

    val recommendedGames = mutableListOf<Game>()

    // Calcula a media das recomendações.
    override val average: Double
        // formata para duas casas apos a virgula.
        get() = recommendations.average().ToTwoDecimalPlaces()

    // Contruto da classe incluindo as variaves (dateBirth, user)
    constructor(name: String, email: String, dateBirth: String, user: String): this(name, email)
    {
        this.dateBirth = dateBirth
        this.user = user
    }

    // Contruto da classe incluindo o (id)
    constructor(name: String, email: String, dateBirth: String, user: String, id: Int): this(name, email, dateBirth, user)
    {
        this.id = id;
    }

    // Na inicialização da classe ele valida o email e o nome do usuario.
    init {
        if(name.isBlank()){
             throw IllegalArgumentException("Name is blank or null")
        }

        val regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$".toRegex()
        if(!regex.matches(email)){
            throw  IllegalArgumentException("Email invalid")
        }
    }

    // Organiza em ordem alfabetica os jogos.
    fun SortedByTitlesGames(): MutableList<Game?>{
        games.sortBy { it?.title }
        return games
    }

    // Remove o jogo da lista de jogos.
    fun RemoveGame(position: Int): MutableList<Game?>{
        games.removeAt(position)
        return  games
    }

    // Filtra um objeto do tipo Game pelo titulo do jogo
    fun FilterTitleGame(filter: String): List<Game?> {
        return  games.filter { it?.title?.contains(filter, true)?: false }
    }

    // Retorna o aluguel de um jogo e quanto vai custar
    fun HireGame(game: Game, periodHire: PeriodHire): HireGame{
        val hireGame = HireGame(this, game, periodHire)
        hireGames.add(hireGame)
        return hireGame
    }

    // Filtra os jogos que foram alugados neste mes
    // month = Mes para a filtragem.
    fun HireGameinMonth(month: Month): List<HireGame> {
        val hireGamesinMonth = hireGames.filter { it.period.month() == month}
        return hireGamesinMonth
    }

    // Sobrescreve o ToString() para uma melhor visualização da classe.
    override fun toString(): String {
        return "Gamer(name='$name', email='$email', dateBirth=$dateBirth, user=$user, Average=$average, Id=$id"
    }

    //  Adiciona uma recomendação a lista de recomenção do jogador
    override fun recommend(value: Int) {
        // valida ser a nota esta entre 0 - 10
        if(value > 10 || value < 0){
            println("The value entered must be between 0 and 10")
            return
        }
        recommendations.add(value)
    }

    // Adiciona uma nota na lista de recomendação do jogo.
    fun recommendGame(game: Game, value: Int){
        game.recommend(value)
        recommendedGames.add(game)
    }

    // Do segundo curso
    // Ele faz o compartilhamento do jogo para um arquivo json.
    fun ShareGame(){
        val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
        val serialize = gson.toJson(recommendedGames)
        val file = File("Recommendation-$name.json")
        file.writeText(serialize)
        println(file.absoluteFile)
    }

    // Objetos que não precisão da instancia da classe.
    companion object{
        // Cria uma instancia do Gamer para registrar um novo jogador.
        fun CreateGamer(read: Scanner): Gamer{
            // pergunta o nome do jogador.
            val name = AskGamerString(read, "Digit your name:")
            // pergunta o email do jogador.
            val email = AskGamerString(read, "Digit your email")
            // pergunta se o jogador quer dar mais informações sobre ele.
            val option = AskGamerString(read, "Do you want to fill in date of birth and user? Y/N")

            // se digitou "y" ele faz as outras perguntas.
            if(option.equals("y", true)){
                // pergunta a data de nascimento do jogador.
                val date = AskGamerString(read, "Digit your birth date (dd/mm/yyyy):")
                // pergunta o nome de usuario na plataforma do jogador.
                val user = AskGamerString(read, "Digit you username:")
                // retorna a instancia com todas as infomações.
                return  Gamer(name, email, date, user)
            }
            // retorna a instancia com o nome e email.
            return Gamer(name, email)
        }
    }
}
