package br.yellow.hiregame.main

import br.yellow.hiregame.Utils.AskGamerInt
import br.yellow.hiregame.Utils.AskGamerString
import br.yellow.hiregame.Utils.ConvertDateBirthFromYears
import br.yellow.hiregame.services.ConsumerApi
import br.yellow.hiregame.models.Game
import br.yellow.hiregame.models.Gamer
import java.util.*


// https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json
// https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json

fun main() {
    /*
    val read = Scanner(System.`in`)
    var gamer: Gamer? = null
    do {
        NewSection()
        val resultCreateGamer = runCatching {
            gamer = Gamer.CreateGamer(read)
        }
        resultCreateGamer.onFailure {
            println(resultCreateGamer.exceptionOrNull())
        }

        resultCreateGamer.onSuccess {
            println(gamer)
            println(gamer?.dateBirth?.ConvertDateBirthFromYears())
        }
    }while (resultCreateGamer.isFailure)



    do {
        NewSection()

        val search = AskGamerString(read, "Insert the code from game for search:")

        val consumeApi = ConsumerApi()
        var game: Game? = null

        val result = runCatching {
            val data = consumeApi.SearchGame(search)
            game = data?.info?.let { Game(it.title, it.thumb) }
        }

        result.onSuccess {
            val option = AskGamerString(read, "Want to insert a custom description? Y/N:")

            if(option.equals("y", true)){
                val descriptionCustomized = AskGamerString(read, "Insert a custom description?")
                game?.description = descriptionCustomized
            } else {
                game?.description = game?.title
            }
            println(game)

            gamer?.games?.add(game)
        }

        result.onFailure {
            println("The game not exist. Insert a other code.")
        }
        val option = AskGamerString(read,"Search a new Game? Y/N")
    }while (option.equals("y", true))

    do {
        NewSection()
        println("\n List of games searched.")
        gamer?.games?.forEach{
            println("Title: ${it?.title}")
        }

        val action = AskGamerString(read, "Select action: 0 - Sorted for title, 1 - filter for name, 2 - delete game")
        var listGames: List<Game?> = mutableListOf<Game?>()
        if(action.equals("0", true)){
            listGames = gamer?.SortedByTitlesGames()!!
        }
        else if(action.equals("1",  true)){
            val filter = AskGamerString(read, "Digit the name game:")
            listGames = gamer?.FilterTitleGame(filter)!!
        }
        else if(action.equals("2", true)){
            gamer?.games?.forEach{
                println("Title: ${it?.title}")
            }
            val delete = AskGamerInt(read, "Digit the name game:")
            val resultRemoveGame = runCatching {
                listGames = gamer?.RemoveGame(delete)!!
            }
            resultRemoveGame.onFailure {
                println("Index not Exists")
            }
        }

        listGames.forEach{
            println("Title: " + it?.title)
        }

        val option = AskGamerString(read, "Continue in actions? Y/N")
    }while (option.equals("y", true))


    println("Search game completed.")
    */
}

fun NewSection() {
    println("************************************************************************** \n")
}