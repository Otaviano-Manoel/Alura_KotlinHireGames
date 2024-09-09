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

// Indica que a classe é uma entitdade do BD
@Entity
// Seta o nome da tabela a qual a classe pertence
@Table (name = "plans")
// Define a estrategia utilizada para as heranças
// Todas as heranças seram colocadas em uma unica tabela.
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
// Define o nome da coluna onde os nomes das classes estaram descriminadas.
@DiscriminatorColumn(name = "TypePlan", discriminatorType = DiscriminatorType.STRING)
// Classe da Entidade que sera salvo no BD
// Nenhuma de suas variaveis podem ser nulas.
sealed class PlanEntity(val type: String,
                        // Id indica a chave primaria
                        // GenerateValue = faz o auto incremento no ID para não repetir.
                        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
                        var id: Int = 0)