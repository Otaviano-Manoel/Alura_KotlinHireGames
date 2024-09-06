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

class ConsumerApi {
    private fun RequestDate(url: String): String{
        val client = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder().uri(URI.create(url)).build()
        val response = client.send(request, BodyHandlers.ofString())
        return response.body()
    }

    fun SearchGameJson(): List<Game> {
        val uri = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"
        val json = RequestDate(uri)

        val gson =  Gson()
        val typeListInfoGame = object: TypeToken<List<InfoGameJson>>(){}.type
        var data = gson.fromJson<List<InfoGameJson>>(json, typeListInfoGame)

        val dataConvertToListGame = data.map { game -> game.ConvertToGame() }

        return  dataConvertToListGame
    }

    fun SearchGamerJson(): List<Gamer> {
        val uri = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"
        val json = RequestDate(uri)

        val gson =  Gson()
        val typeListGamer = object : TypeToken<List<InfoGamerJson>>(){}.type
        val data: List<InfoGamerJson> = gson.fromJson(json, typeListGamer)

        val dataConvertToGamer = data.map { gamer ->  gamer.ConverterToGamer() }

        return  dataConvertToGamer
    }
}