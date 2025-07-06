# 🚗 AppClasseCarro02 - Projeto POO em Kotlin

> **Parte do Curso Desenvolvimento Android Java e Kotlin**  
> **Professor: Marco Maddo** 🎓

## 📱 Sobre o Projeto

Este projeto Android demonstra o uso fundamental de **Programação Orientada a Objetos (POO)** em Kotlin, especificamente com uma `data class Carro` e uma `MainActivity` que a utiliza. O projeto serve como exemplo prático dos conceitos modernos de POO aplicados no desenvolvimento Android com Kotlin, mostrando as vantagens e sintaxe concisa da linguagem.

## 🏗️ Estrutura do Projeto

O projeto consiste principalmente em duas classes Kotlin:

*   **`Carro.kt`** 🚙: Representa um objeto carro usando `data class` com seus atributos e comportamentos.
*   **`MainActivity.kt`** 📱: A tela principal da aplicação, onde um objeto `Carro` é instanciado e seus dados são exibidos no Logcat.

## 📋 Classes e Funcionalidades

### 🚙 `Carro.kt`

Esta `data class` define a estrutura de um objeto Carro, demonstrando os princípios modernos de POO em Kotlin.

**Atributos (Data Class Properties):**

*   `fabricante` (String): O fabricante do carro (ex: "VW").
*   `modelo` (String): O modelo do carro (ex: "Fusca").
*   `ano` (String): O ano de fabricação do carro (ex: "1965").
*   `cor` (String): A cor do carro (ex: "Vermelho").

**Funcionalidades Automáticas da Data Class:**

*   **Getters e Setters**: Gerados automaticamente para todas as propriedades.
*   **toString()**: Implementação automática que exibe todos os atributos.
*   **equals() e hashCode()**: Comparação e hash automáticos.
*   **copy()**: Método para criar cópias do objeto com modificações.
*   **componentN()**: Funções para destructuring.

**Bloco `init`:**

```kotlin
init {
    Log.i("Carro", "Carro criado: $this")
}
```

### 📱 `MainActivity.kt`

Esta é a Activity principal da aplicação. Ela é responsável por:

1.  **Inicializar a interface do usuário**: Configura o layout da tela (definido em `activity_main.xml`).
2.  **Instanciar um objeto `Carro`**: No método `onCreate()`, um novo objeto da `data class Carro` é criado.
3.  **Demonstrar o uso das propriedades**: As propriedades são acessadas diretamente usando a sintaxe Kotlin.
4.  **Logging**: Utiliza `Log.i()` para exibir informações no Logcat com string templates.

## 🎯 Boas Práticas de POO Implementadas

### 1. 🏷️ **Data Classes (Classes de Dados)**
- **Sintaxe Conciso**: A `data class` elimina a necessidade de escrever getters, setters, toString(), equals() e hashCode() manualmente.
- **Imutabilidade**: Facilita a criação de objetos imutáveis (usando `val` em vez de `var`).
- **Destructuring**: Permite extrair propriedades facilmente.

```kotlin
data class Carro(
    var fabricante: String = "",
    var modelo: String = "",
    var ano: String = "",
    var cor: String = ""
)
```

### 2. 🎯 **Construtores Primários**
- **Parâmetros no Construtor**: As propriedades são declaradas diretamente no construtor primário.
- **Valores Padrão**: Cada propriedade tem um valor padrão, permitindo criação flexível de objetos.
- **Inicialização Direta**: Não é necessário um construtor separado.

```kotlin
novoCarro = Carro(
    fabricante = "VW",
    modelo = "Fusca",
    ano = "1965",
    cor = "Vermelho"
)
```

### 3. 🔧 **Bloco `init`**
- **Inicialização Personalizada**: Permite executar código durante a criação do objeto.
- **Logging Automático**: Demonstra como adicionar comportamento durante a instanciação.
- **Acesso a Propriedades**: Pode acessar todas as propriedades da classe.

```kotlin
init {
    Log.i("Carro", "Carro criado: $this")
}
```

### 4. 🚀 **Lateinit**
- **Inicialização Posterior**: A propriedade `novoCarro` é declarada como `lateinit` para inicialização posterior.
- **Verificação de Segurança**: Kotlin garante que a propriedade seja inicializada antes do uso.
- **Flexibilidade**: Permite inicialização em momentos específicos do ciclo de vida.

```kotlin
private lateinit var novoCarro: Carro
```

### 5. 📝 **String Templates**
- **Interpolação de Strings**: Uso de `$` para inserir valores de variáveis em strings.
- **Expressões Complexas**: Suporte a expressões dentro de `${}`.
- **Sintaxe Limpa**: Mais legível que concatenação tradicional.

```kotlin
Log.i("Carro_Kotlin", "Fabricante: ${novoCarro.fabricante}")
Log.i("Carro_Kotlin", "Detalhes do Carro: $novoCarro")
```

### 6. 🎨 **Sintaxe Kotlin Moderna**
- **Funções Lambda**: Uso de lambdas para callbacks (como no `setOnApplyWindowInsetsListener`).
- **Expressões Únicas**: Funções que retornam uma única expressão.
- **Inferência de Tipo**: Kotlin infere tipos automaticamente quando possível.

```kotlin
ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
    val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
    insets
}
```

### 7. 🔒 **Encapsulamento Moderno**
- **Propriedades**: Em Kotlin, campos são propriedades com getters/setters automáticos.
- **Visibilidade**: Controle de acesso através de modificadores (`private`, `public`, etc.).
- **Imutabilidade**: Uso de `val` para propriedades imutáveis quando apropriado.

## 🆚 Diferenças Kotlin vs Java

| Aspecto | Java | Kotlin |
|---------|------|--------|
| **Classe** | `class Carro { private String fabricante; }` | `data class Carro(var fabricante: String)` |
| **Getters/Setters** | Manuais ou Lombok | Automáticos |
| **Construtor** | Separado | Primário integrado |
| **toString()** | Manual ou IDE | Automático |
| **String Interpolation** | `"Fabricante: " + fabricante` | `"Fabricante: $fabricante"` |
| **Null Safety** | `@Nullable` | `String?` |
| **Inicialização** | `Carro carro = new Carro()` | `val carro = Carro()` |

## 🛠️ Tecnologias Utilizadas

- **Kotlin**: Linguagem de programação principal
- **Android SDK**: Framework de desenvolvimento Android
- **AndroidX**: Bibliotecas de suporte modernas
- **ConstraintLayout**: Layout responsivo para a interface
- **Logcat**: Sistema de logging para debug
- **Kotlin Android Extensions**: Recursos específicos do Kotlin para Android

## 🚀 Como Executar

1. Clone o repositório
2. Abra o projeto no Android Studio (Arctic Fox ou mais recente)
3. Sincronize o Gradle
4. Execute o aplicativo em um emulador ou dispositivo físico
5. Abra o Logcat no Android Studio (View > Tool Windows > Logcat)
6. Filtre as mensagens pela tag `Carro_Kotlin` para ver as informações do carro

## 📊 Saída Esperada

No Logcat, você verá:
```
I/Carro: Carro criado: Carro(fabricante=, modelo=, ano=, cor=)
I/Carro_Kotlin: Fabricante: VW
I/Carro_Kotlin: Modelo: Fusca
I/Carro_Kotlin: Ano: 1965
I/Carro_Kotlin: Cor: Vermelho
I/Carro_Kotlin: Detalhes do Carro: Carro(fabricante=VW, modelo=Fusca, ano=1965, cor=Vermelho)
```

## 🎓 Objetivos de Aprendizado

Este projeto demonstra:
- ✅ Criação de `data classes` em Kotlin
- ✅ Construtores primários com parâmetros
- ✅ Blocos `init` para inicialização
- ✅ Propriedades automáticas (getters/setters)
- ✅ String templates e interpolação
- ✅ Uso de `lateinit` para inicialização posterior
- ✅ Sintaxe moderna do Kotlin
- ✅ Integração com Android
- ✅ Logging e debug

## 🌟 Vantagens do Kotlin

- **Menos Código**: Sintaxe mais concisa que Java
- **Null Safety**: Prevenção de NullPointerException em tempo de compilação
- **Interoperabilidade**: Compatível 100% com Java
- **Coroutines**: Suporte nativo para programação assíncrona
- **Expressividade**: Código mais legível e expressivo
- **Produtividade**: Menos boilerplate, mais funcionalidade

---

**Desenvolvido com ❤️ para o Curso de Desenvolvimento Android Java e Kotlin**  
**Professor Marco Maddo** 🎓
