package br.yellow.hiregame.data

import br.yellow.hiregame.models.Game
import javax.persistence.EntityManager

// Classe abstrata DAO para manipulação de entidades do banco de dados.
// TEntity representa a entidade persistida no banco de dados.
// TModel representa o modelo de domínio usado no código.
abstract class DAO<TEntity, TModel>(
    // O EntityManager é utilizado para interagir com o banco de dados.
    protected val manager: EntityManager,
    // O entityType armazena o tipo da entidade correspondente à classe TEntity.
    protected val entityType: Class<TEntity>
) {

    // Método abstrato que converte um modelo (TModel) para uma entidade (TEntity).
    abstract fun ToEntity(model: TModel): TEntity

    // Método abstrato que converte uma entidade (TEntity) para um modelo (TModel).
    abstract fun ToModel(entity: TEntity): TModel

    // Método que retorna uma lista de modelos (TModel) correspondentes a todas as entidades do tipo TEntity no banco.
    fun GetList(): List<TModel> {
        // Cria uma consulta JPQL para obter todas as entidades do tipo especificado (entityType).
        val query = manager.createQuery("FROM ${entityType.simpleName}", entityType)
        // Mapeia as entidades retornadas para seus respectivos modelos e retorna a lista.
        return query.resultList.map { ToModel(it) }
    }

    // Método para adicionar uma nova entidade no banco de dados a partir de um modelo (TModel).
    fun Add(model: TModel) {
        // Converte o modelo em uma entidade.
        val entity = ToEntity(model)
        // Inicia uma transação para persistir a entidade no banco de dados.
        manager.transaction.begin()
        manager.persist(entity)
        // Finaliza a transação, confirmando as alterações.
        manager.transaction.commit()
    }

    // Método que recupera uma entidade do banco de dados pelo seu ID e a converte para um modelo (TModel).
    fun RecoverById(id: Int): TModel {
        // Cria uma consulta JPQL para buscar a entidade com o ID especificado.
        val query = manager.createQuery("FROM ${entityType.simpleName} WHERE id=:id", entityType)
        query.setParameter("id", id)
        // Obtém a entidade e a converte para um modelo.
        val entity = query.singleResult
        return ToModel(entity)
    }

    // Método que remove uma entidade do banco de dados pelo seu ID.
    fun Delete(id: Int) {
        // Cria uma consulta JPQL para buscar a entidade com o ID especificado.
        val query = manager.createQuery("FROM ${entityType.simpleName} WHERE id=:id", entityType)
        query.setParameter("id", id)
        // Obtém a entidade a ser removida.
        val entity = query.singleResult
        // Inicia uma transação para remover a entidade.
        manager.transaction.begin()
        manager.remove(entity)
        // Finaliza a transação, confirmando a remoção.
        manager.transaction.commit()
    }
}