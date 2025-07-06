package foo.maddo.kotlin.fontesaula01poo

/**
 * Created by marcomaddo on 24/10/2017
 * Updated at 06/07/2025
 * Kotlin Version
 */

// O nome de uma classe deve sempre iniciar
// com uma letra maiúscula

class Contato { // nome da classe

    // propriedades

    // Os nomes das propriedades da classe devem seguir a regra
    // CamelCase.
    // https://pt.wikipedia.org/wiki/CamelCase

    var primeiroNome: String = ""
    var segundoNome: String = ""
    var telefone: String = ""
    var email: String = ""

    // ações ou métodos que os objetos da classe sabem executar

    // Para dar nomes aos métodos, use verbos
    fun salvar() {
        // Implementação do método salvar
    }
    
    fun limpar() {
        // Implementação do método limpar
        primeiroNome = ""
        segundoNome = ""
        telefone = ""
        email = ""
    }
} 