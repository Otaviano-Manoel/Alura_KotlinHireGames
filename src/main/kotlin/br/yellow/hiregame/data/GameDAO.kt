package br.yellow.hiregame.data

import br.yellow.hiregame.Utils.ToEntity
import br.yellow.hiregame.Utils.ToModel
import br.yellow.hiregame.models.Game
import javax.persistence.EntityManager

// Classe para a manipulação da tabela "games".
// Herda do DAO que possui os metodos de manipulação
// manager = A Instancia da conexão com o DB.
class GameDAO (manager: EntityManager): DAO<GameEntity, Game>(manager, GameEntity::class.java){

    // Converte o modelo que é utilizado no codigo para a entidade do banco de dados
    override fun ToEntity(model: Game): GameEntity {
        // Extensão da classe Game responsavel pela conversão
        return model.ToEntity()
    }
    // Converte a entidade do banco de dados para o modelo utilizado no codigo.
    override fun ToModel(entity: GameEntity): Game {
        // Extensão da classe GameEntity responsavel pela conversão
        return entity.ToModel()
    }
}