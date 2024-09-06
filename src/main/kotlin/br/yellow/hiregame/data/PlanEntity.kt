package br.yellow.hiregame.data

import br.yellow.hiregame.models.EnumPlan
import javax.persistence.DiscriminatorColumn
import javax.persistence.DiscriminatorType
import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.Inheritance
import javax.persistence.InheritanceType
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

@Entity
@Table (name = "plans")
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TypePlan", discriminatorType = DiscriminatorType.STRING)
sealed class PlanEntity(val type: String,
                        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
                        var id: Int = 0)