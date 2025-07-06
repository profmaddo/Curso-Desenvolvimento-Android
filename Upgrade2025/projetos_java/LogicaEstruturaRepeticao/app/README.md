# 🔄 LogicaEstruturaRepeticao - Estruturas de Repetição em Java

> **Parte do Curso Desenvolvimento Android Java e Kotlin**  
> **Professor: Marco Maddo** 🎓

## 📋 Sobre o Projeto

O **LogicaEstruturaRepeticao** é um projeto Android que demonstra o uso das **quatro principais estruturas de repetição** em Java. O projeto serve como exemplo prático e educativo de como implementar diferentes tipos de loops para iterar sobre uma lista de linguagens de programação.

## 🎯 Objetivos do Projeto

Este projeto tem como objetivo demonstrar:

1. **🔄 For Loop**: Iteração tradicional com índice
2. **🔄 ForEach Loop**: Iteração simplificada sobre elementos
3. **🔄 While Loop**: Repetição baseada em condição
4. **🔄 Do-While Loop**: Repetição com execução garantida pelo menos uma vez
5. **📊 Logging**: Como exibir informações no Logcat
6. **📝 Collections**: Uso de ArrayList e List em Java

## 🏗️ Arquitetura do Projeto

### 📁 **Estrutura de Arquivos**

```
app/src/main/
├── java/foo/maddo/logicaestruturarepeticao/
│   └── MainActivity.java        # Activity principal com estruturas de repetição
├── res/
│   ├── layout/
│   │   └── activity_main.xml   # Layout simples da interface
│   └── values/
│       ├── strings.xml         # Strings do app
│       ├── colors.xml          # Cores
│       └── themes.xml          # Temas
└── AndroidManifest.xml         # Configuração do app
```

## 📱 Análise da MainActivity.java

### 🚀 **Classe Principal**

A **MainActivity** é responsável por demonstrar todas as estruturas de repetição disponíveis em Java.

#### **Imports Utilizados:**

```java
import java.util.ArrayList;
import java.util.List;
import android.util.Log;
```

#### **Estrutura Principal:**

```java
public class MainActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Inicialização e demonstração das estruturas de repetição
    }
    
    private void popularLista(List<String> linguagens) {
        // Método para preencher a lista com linguagens de programação
    }
}
```

## 🔄 Estruturas de Repetição Demonstradas

### 1. **🔄 For Loop (Loop Tradicional)**

```java
for (int i = 0; i < linguagens.size(); i++) {
    Log.i("CursoAndroid", "For: " + linguagens.get(i).toString());
}
```

**Características:**
- ✅ **Controle de Índice**: Variável `i` controla a iteração
- ✅ **Condição de Parada**: `i < linguagens.size()`
- ✅ **Incremento**: `i++` a cada iteração
- ✅ **Acesso por Índice**: `linguagens.get(i)`
- ✅ **Log Level**: `Log.i()` (Informação)

**Quando usar:**
- Quando você precisa do índice da posição
- Quando precisa iterar em ordem reversa
- Quando precisa pular elementos

### 2. **🔄 ForEach Loop (Enhanced For Loop)**

```java
for (String linguagem : linguagens) {
    Log.w("CursoAndroid", "Foreach: " + linguagem);
}
```

**Características:**
- ✅ **Sintaxe Simplificada**: Não precisa de índice
- ✅ **Iteração Direta**: Acessa cada elemento diretamente
- ✅ **Menos Código**: Sintaxe mais limpa
- ✅ **Log Level**: `Log.w()` (Warning)

**Quando usar:**
- Quando você só precisa dos valores, não dos índices
- Para iterar sobre arrays ou collections
- Código mais legível e menos propenso a erros

### 3. **🔄 While Loop (Repetição com Condição)**

```java
int x = 10;
while (x < linguagens.size()) {
    Log.i("CursoAndroid", "While: " + linguagens.get(x).toString());
    x++;
}
```

**Características:**
- ✅ **Condição de Entrada**: Verifica antes de executar
- ✅ **Controle Manual**: Incremento manual da variável
- ✅ **Flexibilidade**: Pode ter lógica complexa na condição
- ✅ **Log Level**: `Log.i()` (Informação)

**Quando usar:**
- Quando não se sabe quantas iterações serão necessárias
- Quando a condição de parada é complexa
- Quando você precisa de controle total sobre a iteração

### 4. **🔄 Do-While Loop (Repetição com Execução Garantida)**

```java
int y = 0;
do {
    Log.w("CursoAndroid", "do While: " + linguagens.get(y).toString());
    y = 10;
} while (y < linguagens.size());
```

**Características:**
- ✅ **Execução Garantida**: Executa pelo menos uma vez
- ✅ **Condição no Final**: Verifica após executar
- ✅ **Controle Manual**: Incremento manual da variável
- ✅ **Log Level**: `Log.w()` (Warning)

**Quando usar:**
- Quando você quer garantir que o código execute pelo menos uma vez
- Para validação de entrada do usuário
- Quando a condição depende do resultado da primeira execução

## 📊 Método popularLista()

### 🎯 **Função do Método**

```java
private void popularLista(List<String> linguagens) {
    linguagens.add("Java");
    linguagens.add("JavaScript");
    linguagens.add("PHP");
    linguagens.add("C");
    linguagens.add("C++");
    linguagens.add("Prolog");
    linguagens.add("Pascal");
}
```

**Responsabilidades:**
- ✅ **Preenchimento da Lista**: Adiciona linguagens de programação
- ✅ **Dados de Exemplo**: Fornece dados para demonstração
- ✅ **Reutilização**: Método separado para organização

## 📱 Interface de Usuário

### 📄 **activity_main.xml**

Layout simples que exibe apenas "Hello World!" na tela.

```xml
<TextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Hello World!"
    app:layout_constraintBottom_toBottomOf="parent"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toTopOf="parent" />
```

**Características:**
- **Layout Simples**: Foco no código, não na interface
- **ConstraintLayout**: Posicionamento centralizado
- **TextView**: Exibição de texto simples

## 📊 Saída no Logcat

### 🔍 **Como Visualizar os Resultados**

Para ver a demonstração das estruturas de repetição:

1. **Abra o Logcat** no Android Studio
2. **Filtre por tag**: `CursoAndroid`
3. **Execute o app** e observe as mensagens

### 📝 **Exemplo de Saída Esperada**

```
I/CursoAndroid: For: Java
I/CursoAndroid: For: JavaScript
I/CursoAndroid: For: PHP
I/CursoAndroid: For: C
I/CursoAndroid: For: C++
I/CursoAndroid: For: Prolog
I/CursoAndroid: For: Pascal

W/CursoAndroid: Foreach: Java
W/CursoAndroid: Foreach: JavaScript
W/CursoAndroid: Foreach: PHP
W/CursoAndroid: Foreach: C
W/CursoAndroid: Foreach: C++
W/CursoAndroid: Foreach: Prolog
W/CursoAndroid: Foreach: Pascal

I/CursoAndroid: While: Prolog
I/CursoAndroid: While: Pascal

W/CursoAndroid: do While: Java
```

## 🎯 Análise dos Comportamentos

### 🔍 **Comportamentos Específicos**

#### **For Loop:**
- Itera sobre **todos os elementos** da lista
- Mostra cada linguagem com prefixo "For:"

#### **ForEach Loop:**
- Itera sobre **todos os elementos** da lista
- Mostra cada linguagem com prefixo "Foreach:"

#### **While Loop:**
- **Inicia em x = 10** (posição 10)
- **Lista tem 7 elementos** (índices 0-6)
- **Não executa** porque 10 >= 7
- **Resultado**: Nenhuma saída

#### **Do-While Loop:**
- **Executa uma vez** (y = 0)
- Mostra "do While: Java"
- **Define y = 10** dentro do loop
- **Para** porque 10 >= 7
- **Resultado**: Uma execução

## 🆚 Comparação das Estruturas

| Estrutura | Sintaxe | Controle | Execução Mínima | Melhor Para |
|-----------|---------|----------|-----------------|-------------|
| **For** | `for(int i=0; i<n; i++)` | Índice | 0 vezes | Iteração com índice |
| **ForEach** | `for(T item : collection)` | Elemento | 0 vezes | Iteração simples |
| **While** | `while(condição)` | Manual | 0 vezes | Condições complexas |
| **Do-While** | `do { } while(condição)` | Manual | 1 vez | Execução garantida |

## 🎓 Conceitos Demonstrados

### 1. **Estruturas de Controle**
- Diferentes formas de repetição
- Controle de fluxo de execução

### 2. **Collections em Java**
- **ArrayList**: Lista dinâmica
- **List Interface**: Contrato para listas
- **Métodos**: `add()`, `size()`, `get()`

### 3. **Logging Android**
- **Log.i()**: Informação
- **Log.w()**: Warning
- **Tags**: Identificação das mensagens

### 4. **Programação Estruturada**
- Organização do código em métodos
- Separação de responsabilidades

## 🚀 Como Executar

1. **Clone** o repositório
2. **Abra** o projeto no Android Studio
3. **Sincronize** o Gradle
4. **Execute** em emulador ou dispositivo físico
5. **Abra o Logcat** e filtre por "CursoAndroid"
6. **Observe** as diferentes saídas das estruturas de repetição

## 🎯 Objetivos de Aprendizado

Este projeto demonstra:
- ✅ **For Loop**: Iteração tradicional com índice
- ✅ **ForEach Loop**: Iteração simplificada
- ✅ **While Loop**: Repetição com condição
- ✅ **Do-While Loop**: Repetição com execução garantida
- ✅ **Collections**: Uso de ArrayList e List
- ✅ **Logging**: Exibição de informações no Logcat
- ✅ **Programação Estruturada**: Organização do código
- ✅ **Controle de Fluxo**: Diferentes formas de repetição

## 🌟 Vantagens de Cada Estrutura

### **For Loop:**
- Controle total sobre a iteração
- Acesso ao índice
- Flexibilidade para modificações

### **ForEach Loop:**
- Sintaxe mais limpa
- Menos propenso a erros
- Legibilidade superior

### **While Loop:**
- Condições complexas
- Controle manual da iteração
- Flexibilidade máxima

### **Do-While Loop:**
- Execução garantida
- Validação após execução
- Útil para entrada de dados

---

**Desenvolvido com ❤️ para o Curso de Desenvolvimento Android Java e Kotlin**  
**Professor Marco Maddo** 🎓 