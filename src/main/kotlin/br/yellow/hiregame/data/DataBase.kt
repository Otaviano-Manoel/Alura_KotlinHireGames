package br.yellow.hiregame.data

import java.sql.Connection
import javax.persistence.EntityManager
import javax.persistence.Persistence

object DataBase {

    fun GetManager(): EntityManager {
        val factory = Persistence.createEntityManagerFactory("hire_games")
        return factory.createEntityManager()
    }
}