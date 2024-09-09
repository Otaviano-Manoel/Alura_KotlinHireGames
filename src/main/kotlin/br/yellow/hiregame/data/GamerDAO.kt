package br.yellow.hiregame.data

import ToEntity
import ToModel
import br.yellow.hiregame.models.Gamer
import javax.persistence.EntityManager

// Classe para a manipulação da tabela "gamer".
// Herda do DAO que possui os metodos de manipulação
// manager = A Instancia da conexão com o DB.
class GamerDAO (manager: EntityManager): DAO<GamerEntity, Gamer>(manager, GamerEntity::class.java) {
    // Converte o modelo que é utilizado no codigo para a entidade do banco de dados
    override fun ToEntity(model: Gamer): GamerEntity {
        // Extensão da classe Gamer responsavel pela conversão
        return model.ToEntity()
    }

    // Converte a entidade do banco de dados para o modelo utilizado no codigo.
    override fun ToModel(entity: GamerEntity): Gamer {
        // Extensão da classe GamerEntity responsavel pela conversão
        return entity.ToModel()
    }
}