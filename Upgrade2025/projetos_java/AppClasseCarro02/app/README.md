# 🚗 AppClasseCarro02 - Projeto POO em Java

> **Parte do Curso Desenvolvimento Android Java e Kotlin**  
> **Professor: Marco Maddo** 🎓

## 📱 Sobre o Projeto

Este projeto Android demonstra o uso fundamental de **Programação Orientada a Objetos (POO)** em Java, especificamente com uma classe `Carro` e uma `MainActivity` que a utiliza. O projeto serve como exemplo prático dos conceitos básicos de POO aplicados no desenvolvimento Android.

## 🏗️ Estrutura do Projeto

O projeto consiste principalmente em duas classes Java:

*   **`Carro.java`** 🚙: Representa um objeto carro com seus atributos e comportamentos.
*   **`MainActivity.java`** 📱: A tela principal da aplicação, onde um objeto `Carro` é instanciado e seus dados são exibidos no Logcat.

## 📋 Classes e Funcionalidades

### 🚙 `Carro.java`

Esta classe define a estrutura de um objeto Carro, demonstrando os princípios fundamentais de POO.

**Atributos (Encapsulamento):**

*   `modelo` (String): O modelo do carro (ex: "Fusca").
*   `fabricante` (String): O fabricante do carro (ex: "VW").
*   `ano` (String): O ano de fabricação do carro (ex: "1965").
*   `cor` (String): A cor do carro (ex: "Vermelho").

**Métodos (Getters e Setters):**

*   `getModelo()`: Retorna o modelo do carro.
*   `setModelo(String modelo)`: Define o modelo do carro.
*   `getFabricante()`: Retorna o fabricante do carro.
*   `setFabricante(String fabricante)`: Define o fabricante do carro.
*   `getAno()`: Retorna o ano de fabricação do carro.
*   `setAno(String ano)`: Define o ano de fabricação do carro.
*   `getCor()`: Retorna a cor do carro.
*   `setCor(String cor)`: Define a cor do carro.
*   `toString()`: Retorna uma representação em String do objeto `Carro`, exibindo todos os seus atributos.

### 📱 `MainActivity.java`

Esta é a Activity principal da aplicação. Ela é responsável por:

1.  **Inicializar a interface do usuário**: Configura o layout da tela (definido em `activity_main.xml`).
2.  **Instanciar um objeto `Carro`**: No método `onCreate()`, um novo objeto da classe `Carro` é criado.
3.  **Demonstrar o uso dos métodos**: Os getters e setters são utilizados para configurar e exibir os dados do carro.
4.  **Logging**: Utiliza `System.out.println()` e `Log.i()` para exibir informações no console e Logcat.

## 🎯 Boas Práticas de POO Implementadas

### 1. 🔒 **Encapsulamento (Encapsulation)**
- **Atributos Privados**: Todos os atributos da classe `Carro` são declarados como `private`, protegendo o acesso direto aos dados.
- **Getters e Setters**: Fornece métodos públicos para acessar e modificar os atributos privados, controlando como os dados são manipulados.

```java
private String fabricante;  // Atributo privado
public String getFabricante() { return fabricante; }  // Getter público
public void setFabricante(String fabricante) { this.fabricante = fabricante; }  // Setter público
```

### 2. 🏗️ **Construtor (Constructor)**
- **Construtor Padrão**: A classe possui um construtor sem parâmetros que inicializa o objeto.
- **Logging no Construtor**: Demonstra como executar código durante a criação do objeto.

```java
public Carro() {
    Log.i("Carro", "Carro criado");
}
```

### 3. 🔄 **Sobrescrita de Métodos (Method Overriding)**
- **toString()**: Sobrescreve o método `toString()` da classe `Object` para fornecer uma representação personalizada do objeto.

```java
@Override
public String toString() {
    return "Carro{" +
            "fabricante='" + fabricante + '\'' +
            ", modelo='" + modelo + '\'' +
            ", ano='" + ano + '\'' +
            ", cor='" + cor + '\'' +
            '}';
}
```

### 4. 📦 **Instanciação de Objetos**
- **Criação de Instância**: Demonstra como criar objetos a partir de uma classe.
- **Uso de Referências**: Utiliza uma variável de referência para manipular o objeto.

```java
Carro novoCarro = new Carro();
```

### 5. 🎯 **Responsabilidade Única**
- **Separação de Responsabilidades**: A classe `Carro` é responsável apenas pelos dados e comportamentos de um carro.
- **MainActivity Focada**: A MainActivity se concentra na interface e na demonstração do uso da classe.

### 6. 📝 **Nomenclatura Clara**
- **Nomes Descritivos**: Atributos e métodos têm nomes que claramente indicam sua função.
- **Convenções Java**: Segue as convenções de nomenclatura padrão do Java.

## 🛠️ Tecnologias Utilizadas

- **Java 11**: Linguagem de programação principal
- **Android SDK**: Framework de desenvolvimento Android
- **AndroidX**: Bibliotecas de suporte modernas
- **ConstraintLayout**: Layout responsivo para a interface
- **Logcat**: Sistema de logging para debug

## 🚀 Como Executar

1. Clone o repositório
2. Abra o projeto no Android Studio
3. Sincronize o Gradle
4. Execute o aplicativo em um emulador ou dispositivo físico
5. Verifique o Logcat para ver as informações do carro sendo exibidas

## 📊 Saída Esperada

No Logcat, você verá:
```
I/Carro: Carro criado
I/Carro: Fusca
I/Carro: VW
I/Carro: 1965
I/Carro: Vermelho
I/Carro: Carro{fabricante='VW', modelo='Fusca', ano='1965', cor='Vermelho'}
```

## 🎓 Objetivos de Aprendizado

Este projeto demonstra:
- ✅ Criação de classes em Java
- ✅ Encapsulamento com atributos privados
- ✅ Getters e Setters
- ✅ Construtores
- ✅ Sobrescrita de métodos
- ✅ Instanciação de objetos
- ✅ Integração com Android
- ✅ Logging e debug

---

**Desenvolvido com ❤️ para o Curso de Desenvolvimento Android Java e Kotlin**  
**Professor Marco Maddo** 🎓
    