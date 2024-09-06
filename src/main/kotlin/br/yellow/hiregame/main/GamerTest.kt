package br.yellow.hiregame.main

import br.yellow.hiregame.data.DataBase
import br.yellow.hiregame.data.GameDAO
import br.yellow.hiregame.data.GamerDAO
import br.yellow.hiregame.data.PlansDAO
import br.yellow.hiregame.models.*
import br.yellow.hiregame.services.ConsumerApi
import sun.security.util.Debug
import java.io.Console
import java.math.BigDecimal
import java.time.LocalDate
import java.time.Month

fun main(){
    val api = ConsumerApi()
    val gamers = api.SearchGamerJson()
    val games = api.SearchGameJson()

    val manager = DataBase.GetManager()
    val plansDAO = PlansDAO(manager)
    val gamerDAO = GamerDAO(manager)

    gamers[0].plan = plansDAO.RecoverById(2)

    gamerDAO.Add(gamers[0])


    println(gamerDAO.GetList().count())
    manager.close()
}