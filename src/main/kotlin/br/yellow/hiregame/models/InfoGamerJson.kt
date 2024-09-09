package br.yellow.hiregame.models

// Data Classe para receber as informações do jogador que estão no json
data class InfoGamerJson(val nome: String,val email: String, val dataNascimento: String, val usuario: String){
    // Sobrescreve o metodo ToString() para melhorar a visualização da classe.
    override fun toString(): String {
        return "InfoGamerJson(nome='$nome', email='$email', dataNascimento='$dataNascimento', usuario='$usuario')"
    }
}
