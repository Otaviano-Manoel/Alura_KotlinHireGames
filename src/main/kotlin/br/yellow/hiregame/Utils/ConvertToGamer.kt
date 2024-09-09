package br.yellow.hiregame.Utils

import br.yellow.hiregame.models.Gamer
import br.yellow.hiregame.models.InfoGamerJson

// Converto do tipo InfoGamerJson para o tipo Gamer
fun InfoGamerJson.ConverterToGamer(): Gamer{
    return Gamer(this.nome, this.email, this.dataNascimento, this.usuario)
}