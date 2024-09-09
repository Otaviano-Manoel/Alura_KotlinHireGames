package br.yellow.hiregame.services

import br.yellow.hiregame.Utils.ConvertToGame
import br.yellow.hiregame.Utils.ConverterToGamer
import br.yellow.hiregame.models.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

// Classe para manipulação do json
class ConsumerApi {
    // faz uma requisição para pegar o json
    // o parametro é uma url onde esta o json
    private fun RequestDate(url: String): String{
        // cria o client.
        val client = HttpClient.newHttpClient()
        // faz a conexão para o site.
        val request = HttpRequest.newBuilder().uri(URI.create(url)).build()
        // faz a requisição do client para retorna o site como string.
        val response = client.send(request, BodyHandlers.ofString())
        // retorna apenas o corpo do site que seria o json.
        return response.body()
    }

    // procura todos os jogos no json.
    fun SearchGameJson(): List<Game> {
        // site onde esta o json.
        val uri = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"
        // guarda o json que estava nesta (uri).
        val json = RequestDate(uri)

        // utilizamos o Gson para manipulação do json
        val gson =  Gson()
        // o tipo do token que o Gson vai ter que cria apos carregar o json.
        val typeListInfoGame = object: TypeToken<List<InfoGameJson>>(){}.type
        // retornar todos os jogos e converte no tipo do token mencionado acima.
        var data = gson.fromJson<List<InfoGameJson>>(json, typeListInfoGame)

        // faz a conversão do tipo InfoGameJson para o tipo Game.
        val dataConvertToListGame = data.map { game -> game.ConvertToGame() }

        // Retorna a lista com todos os jogos daquele json.
        return  dataConvertToListGame
    }

    // Procura todos o jogadores no json.
    fun SearchGamerJson(): List<Gamer> {
        // site onde esta o json.
        val uri = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"
        // guarda o json que estava nesta (uri).
        val json = RequestDate(uri)

        // utilizamos o Gson para manipulação do json
        val gson =  Gson()
        // o tipo do token que o Gson vai ter que cria apos carregar o json.
        val typeListGamer = object : TypeToken<List<InfoGamerJson>>(){}.type
        // retornar todos os jogos e converte no tipo do token mencionado acima.
        val data: List<InfoGamerJson> = gson.fromJson(json, typeListGamer)

        // faz a conversão do tipo InfoGamerJson para o tipo Gamer.
        val dataConvertToGamer = data.map { gamer ->  gamer.ConverterToGamer() }

        // Retorna a lista com todos os jogadores daquele json.
        return  dataConvertToGamer
    }
}