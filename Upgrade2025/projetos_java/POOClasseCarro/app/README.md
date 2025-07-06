# POOClasseCarro - Demonstração de Polimorfismo e Herança

## 📚 Sobre o Projeto

Este projeto foi desenvolvido pelo **Professor Marco Maddo** como parte do curso de Desenvolvimento Android, demonstrando conceitos fundamentais de **Programação Orientada a Objetos (POO)**, especificamente **Polimorfismo** e **Herança** através de um exemplo prático de diferentes tipos de transporte.

## 🎯 Objetivos Educacionais

- Demonstrar o conceito de **Herança** em Java
- Explicar **Polimorfismo** através de sobreposição de métodos
- Mostrar como diferentes classes podem implementar o mesmo método de forma específica
- Integrar conceitos de POO com desenvolvimento Android
- Utilizar logs para visualizar o comportamento polimórfico

## 🏗️ Estrutura do Projeto

### Classes Principais

#### 1. **Transporte.java** - Classe Base
```java
public class Transporte {
    public void tipo() {
        Log.v("Polimorfismo", "Todo TRANSPORTE tem um tipo para transportar algo!");
    }
}
```
- **Classe pai/abstrata** que define o comportamento base
- Método `tipo()` que será sobrescrito pelas classes filhas
- Demonstra o conceito de **herança**

#### 2. **Classes Filhas** - Herança Específica

**Carro.java:**
```java
public class Carro extends Transporte {
    public void tipo() {
        Log.i("Polimorfismo", "Todo CARRO transporta rodando pelas estradas!");
    }
}
```

**Aviao.java:**
```java
public class Aviao extends Transporte {
    public void tipo() {
        Log.i("Polimorfismo", "Todo AVIÃO transporta voando pelos ares!");
    }
}
```

**Navio.java:**
```java
public class Navio extends Transporte {
    public void tipo() {
        Log.i("Polimorfismo", "Todo NAVIO transporta navegando por RIOS ou MARES!");
    }
}
```

**Trem.java:**
```java
public class Trem extends Transporte {
    public void tipo() {
        Log.i("Polimorfismo", "Todo TREM transporta pelos tilhos!");
    }
}
```

#### 3. **IniciarTransporte.java** - Demonstração de Polimorfismo
```java
public class IniciarTransporte {
    public void criarUmTransporte(Transporte transporte) {
        transporte.tipo();
    }
}
```
- **Classe utilitária** que demonstra polimorfismo
- Método `criarUmTransporte()` aceita qualquer objeto do tipo `Transporte`
- O comportamento específico é determinado em tempo de execução

#### 4. **MainActivity.java** - Interface do Usuário
```java
private void transportarAlgo() {
    IniciarTransporte obj = new IniciarTransporte();
    
    obj.criarUmTransporte(new Transporte());
    obj.criarUmTransporte(new Aviao());
    obj.criarUmTransporte(new Navio());
    obj.criarUmTransporte(new Carro());
    obj.criarUmTransporte(new Trem());
}
```

## 🎨 Interface do Usuário

### Layout Principal (`activity_main.xml`)

```xml
<androidx.constraintlayout.widget.ConstraintLayout>
    <TextView
        android:text="POO\nPolimorfismo\nSubtipos"
        android:textSize="35sp" />
    
    <Button
        android:id="@+id/btnIniciar"
        android:text="Iniciar um Transporte" />
        
    <TextView
        android:text="V12-2021"
        android:textStyle="bold" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

### Componentes da UI:
- **TextView principal**: Exibe o título do projeto
- **Button**: Aciona a demonstração de polimorfismo
- **TextView de versão**: Mostra a versão do projeto

## 🔍 Conceitos de POO Demonstrados

### 1. **Herança (Inheritance)**
- Todas as classes de transporte herdam de `Transporte`
- Sintaxe: `public class Carro extends Transporte`
- Permite reutilização de código e estabelece hierarquia

### 2. **Polimorfismo (Polymorphism)**
- **Sobreposição de métodos**: Cada classe filha sobrescreve o método `tipo()`
- **Polimorfismo de inclusão**: O mesmo método se comporta diferentemente baseado no tipo do objeto
- **Ligação dinâmica**: O comportamento é determinado em tempo de execução

### 3. **Encapsulamento**
- Métodos públicos para acesso controlado
- Estrutura organizada em classes bem definidas

## 📱 Funcionalidades do App

### 1. **Demonstração Interativa**
- Clique no botão "Iniciar um Transporte"
- Executa todos os tipos de transporte
- Mostra logs no Logcat para cada tipo

### 2. **Logs Educacionais**
- **TAG "Polimorfismo"**: Para logs das classes de transporte
- **TAG "marcomaddo"**: Para logs de debug e warning
- **TAG "marcomaddoerro"**: Para logs de erro

### 3. **Saída Esperada no Logcat**
```
D/marcomaddo: Teste de LOG para DEBUG....
E/marcomaddo: Teste de LOG para INFO Click...
V/Polimorfismo: Todo TRANSPORTE tem um tipo para transportar algo!
I/Polimorfismo: Todo AVIÃO transporta voando pelos ares!
I/Polimorfismo: Todo NAVIO transporta navegando por RIOS ou MARES!
I/Polimorfismo: Todo CARRO transporta rodando pelas estradas!
I/Polimorfismo: Todo TREM transporta pelos tilhos!
W/marcomaddo: Teste de LOG para Warning no Método
```

## 🛠️ Configuração Técnica

### Versões e Dependências
- **compileSdk**: 36
- **minSdk**: 24
- **targetSdk**: 36
- **Java Version**: 11
- **Dependências principais**:
  - androidx.appcompat
  - androidx.constraintlayout
  - com.google.android.material

### Estrutura de Pacotes
```
foo.maddo.pooclassecarro/
├── MainActivity.java
├── Transporte.java
├── IniciarTransporte.java
├── Carro.java
├── Aviao.java
├── Navio.java
└── Trem.java
```

## 🎓 Aprendizados do Projeto

### 1. **Conceitos de POO**
- **Herança**: Relacionamento "é-um" entre classes
- **Polimorfismo**: Mesma interface, comportamentos diferentes
- **Encapsulamento**: Organização e proteção de dados

### 2. **Desenvolvimento Android**
- Integração de POO com Android
- Uso de logs para debugging
- Estruturação de projetos Android

### 3. **Boas Práticas**
- Código organizado e bem estruturado
- Nomes descritivos para classes e métodos
- Comentários explicativos quando necessário

## 🚀 Como Executar

1. **Clone o projeto** ou abra no Android Studio
2. **Sincronize** as dependências do Gradle
3. **Execute** o projeto em um emulador ou dispositivo
4. **Clique** no botão "Iniciar um Transporte"
5. **Abra o Logcat** para ver os logs de polimorfismo

## 📋 Permissões

Este projeto **não requer permissões especiais** do Android, pois:
- Não acessa recursos do sistema
- Não utiliza sensores ou hardware específico
- Foca apenas na demonstração de conceitos de POO

## 🔒 Considerações de Segurança

- **Sem permissões sensíveis**: Projeto educacional sem acesso a dados pessoais
- **Logs seguros**: Apenas informações educacionais são logadas
- **Código limpo**: Sem vulnerabilidades de segurança

## 🎯 Casos de Uso

### 1. **Educacional**
- Aprendizado de POO em Android
- Demonstração de polimorfismo
- Exemplo prático de herança

### 2. **Desenvolvimento**
- Template para projetos com POO
- Base para sistemas de transporte
- Estrutura para hierarquias de classes

## 🔄 Extensões Possíveis

### 1. **Funcionalidades Adicionais**
- Adicionar mais tipos de transporte
- Implementar interfaces
- Criar métodos com parâmetros

### 2. **Melhorias de UI**
- Mostrar resultados na tela
- Adicionar animações
- Criar listas de transportes

### 3. **Conceitos Avançados**
- Implementar interfaces
- Usar classes abstratas
- Adicionar construtores personalizados

## 📞 Suporte

Para dúvidas sobre este projeto ou conceitos de POO:
- **Professor**: Marco Maddo
- **Curso**: Desenvolvimento Android
- **Foco**: Programação Orientada a Objetos

---

**Desenvolvido com ❤️ pelo Professor Marco Maddo para o ensino de POO em Android** 