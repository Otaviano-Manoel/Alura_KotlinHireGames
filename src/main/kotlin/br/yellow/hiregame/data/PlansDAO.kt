package br.yellow.hiregame.data

import ToEntity
import ToModel
import br.yellow.hiregame.models.Plan
import javax.persistence.EntityManager

// Classe para a manipulação da tabela "plans".
// Herda do DAO que possui os metodos de manipulação
// manager = A Instancia da conexão com o DB.
class PlansDAO(manager: EntityManager): DAO<PlanEntity, Plan>(manager, PlanEntity::class.java) {
    // Converte o modelo que é utilizado no codigo para a entidade do banco de dados
    override fun ToEntity(model: Plan): PlanEntity {
        // Extensão da classe Plan responsavel pela conversão
        return model.ToEntity()
    }
    // Converte a entidade do banco de dados para o modelo utilizado no codigo.
    override fun ToModel(entity: PlanEntity): Plan {
        // Extensão da classe PlanEntity responsavel pela conversão
        return entity.ToModel()
    }
}