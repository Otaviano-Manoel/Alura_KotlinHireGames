package br.yellow.hiregame.data

import br.yellow.hiregame.models.Game
import javax.persistence.EntityManager

abstract class DAO <TEntity, TModel> (protected val manager: EntityManager, protected  val entityType: Class<TEntity>) {

    abstract fun ToEntity(model: TModel): TEntity

    abstract fun ToModel(entity: TEntity): TModel

    fun GetList(): List<TModel>{
        val query = manager.createQuery("FROM ${entityType.simpleName}", entityType)
        return query.resultList.map { ToModel(it) }
    }

    fun Add(model: TModel){
        val entity = ToEntity(model)
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }

    fun RecoverById(id: Int): TModel{
        val query = manager.createQuery("FROM ${entityType.simpleName} WHERE id=:id", entityType)
        query.setParameter("id", id)
        val entity = query.singleResult
        return ToModel(entity)
    }

    fun Delete(id: Int){
        val query = manager.createQuery("FROM ${entityType.simpleName} WHERE id=:id", entityType)
        query.setParameter("id", id)
        val entity = query.singleResult
        manager.transaction.begin()
        manager.remove(entity)
        manager.transaction.commit()
    }
}