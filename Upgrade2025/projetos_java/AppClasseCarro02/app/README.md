# AppClasseCarro02

Este projeto Android demonstra o uso básico de classes e objetos em Java, especificamente com uma classe `Carro` e uma `MainActivity` que a utiliza.

## Estrutura do Projeto

O projeto consiste principalmente em duas classes Java:

*   **`Carro.java`**: Representa um objeto carro com seus atributos e comportamentos.
*   **`MainActivity.java`**: A tela principal da aplicação, onde um objeto `Carro` é instanciado e seus dados são exibidos no Logcat.

## Classes

### `Carro.java`

Esta classe define a estrutura de um objeto Carro.

**Atributos:**

*   `modelo` (String): O modelo do carro (ex: "Fusca").
*   `fabricante` (String): O fabricante do carro (ex: "VW").
*   `ano` (String): O ano de fabricação do carro (ex: "1965").
*   `cor` (String): A cor do carro (ex: "Vermelho").

**Métodos:**

*   `getModelo()`: Retorna o modelo do carro.
*   `setModelo(String modelo)`: Define o modelo do carro.
*   `getFabricante()`: Retorna o fabricante do carro.
*   `setFabricante(String fabricante)`: Define o fabricante do carro.
*   `getAno()`: Retorna o ano de fabricação do carro.
*   `setAno(String ano)`: Define o ano de fabricação do carro.
*   `getCor()`: Retorna a cor do carro.
*   `setCor(String cor)`: Define a cor do carro.
*   `toString()`: Retorna uma representação em String do objeto `Carro`, exibindo todos os seus atributos.

### `MainActivity.java`

Esta é a Activity principal da aplicação. Ela é responsável por:

1.  **Inicializar a interface do usuário**: Configura o layout da tela (definido em `activity_main.xml`).
2.  **Instanciar um objeto `Carro`**: No método `onCreate()`, um novo objeto da classe `Carro` é criado.
    