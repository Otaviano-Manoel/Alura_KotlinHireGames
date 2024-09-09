package br.yellow.hiregame.data

import java.sql.Connection
import javax.persistence.EntityManager
import javax.persistence.Persistence

// Objeto para conexão com o banco de dados.
object DataBase {

    // Retorna a conexão com o banco de dados.
    fun GetManager(): EntityManager {
        // Cria o factory para o esquema "hire_games" e guarda ela.
        val factory = Persistence.createEntityManagerFactory("hire_games")
        // Cria o entityManager que sera utilizado na manipulação do BD.
        return factory.createEntityManager()
    }
}