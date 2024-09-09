package br.yellow.hiregame.data

import ToEntity
import ToModel
import br.yellow.hiregame.Utils.ToEntity
import br.yellow.hiregame.Utils.ToModel
import br.yellow.hiregame.models.HireGame
import javax.persistence.EntityManager

// Classe para a manipulação da tabela "hire".
// Herda do DAO que possui os metodos de manipulação
// manager = A Instancia da conexão com o DB.
class HireDAO(manager: EntityManager): DAO<HireEntity, HireGame>(manager, HireEntity::class.java) {

    // Converte o modelo que é utilizado no codigo para a entidade do banco de dados
    override fun ToEntity(model: HireGame): HireEntity {
        // Faz a conversão e retorna o HireEntity, o apply é para as variaveis que não estão no construtor
        return HireEntity(model.gamer.ToEntity(), model.game.ToEntity(), model.period).apply {
            hireValue = model.price.toDouble()
            id = model.id
        }
    }
    // Converte a entidade do banco de dados para o modelo utilizado no codigo.
    override fun ToModel(entity: HireEntity): HireGame {
        // Faz a conversão e retorna o HireGame, o apply é para as variaveis que não estão no construtor
        return HireGame(entity.gamer.ToModel(), entity.game.ToModel(), entity.period).apply {
            id = entity.id
        }
    }
}