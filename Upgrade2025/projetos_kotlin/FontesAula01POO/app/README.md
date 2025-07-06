# 📱 FontesAula01POO - Aplicativo de Contatos

> **Parte do Curso Desenvolvimento Android Java e Kotlin**  
> **Professor: Marco Maddo** 🎓

## 📋 Sobre o Projeto

O **FontesAula01POO** é um aplicativo Android que demonstra os conceitos fundamentais de **Programação Orientada a Objetos (POO)** integrados com **interface gráfica**. O projeto serve como exemplo prático de como criar um aplicativo completo que combina:

- **Classes e Objetos** em Kotlin
- **Interface de Usuário** em XML
- **Integração** entre código e layout
- **Eventos de Usuário** (cliques de botões)
- **Manipulação de Dados** em tempo real

## 🎯 Funcionalidades do App

O aplicativo permite ao usuário:

1. **📝 Inserir Dados**: Preencher formulário com informações pessoais
2. **💾 Salvar Contato**: Criar objeto da classe Contato com os dados inseridos
3. **🧹 Limpar Formulário**: Resetar todos os campos para vazio
4. **📱 Interface Intuitiva**: Interface gráfica amigável e responsiva

## 🏗️ Arquitetura do Projeto

### 📁 **Estrutura de Arquivos**

```
app/src/main/
├── java/foo/maddo/kotlin/fontesaula01poo/
│   ├── MainActivity.kt          # Activity principal
│   └── Contato.kt              # Classe de modelo de dados
├── res/
│   ├── layout/
│   │   └── activity_main.xml   # Layout da interface
│   └── values/
│       ├── strings.xml         # Strings do app
│       ├── colors.xml          # Cores
│       └── themes.xml          # Temas
└── AndroidManifest.xml         # Configuração do app
```

## 📱 Classes e Componentes

### 🚀 **MainActivity.kt**

A **Activity Principal** que gerencia a interface e a lógica do aplicativo.

#### **Propriedades (Variáveis de Instância):**

```kotlin
// Referências para os componentes de interface
var primeiroNome: EditText? = null
var segundoNome: EditText? = null
var telefone: EditText? = null
var email: EditText? = null
var btnLimpar: Button? = null
var btnSalvar: Button? = null

// Objeto da classe Contato
var contato: Contato? = null
```

#### **Métodos Principais:**

1. **`onCreate()`**: Inicialização da Activity
   - Configura o layout
   - Vincula componentes XML com variáveis Java/Kotlin
   - Configura listeners de eventos

2. **`limpar()`**: Limpa todos os campos do formulário
   - Reseta todos os EditText para vazio

3. **`salvar()`**: Cria e salva um novo contato
   - Instancia objeto da classe Contato
   - Preenche propriedades com dados dos campos
   - Exibe mensagem de sucesso

### 👤 **Contato.kt**

A **Classe de Modelo** que representa um contato com suas propriedades e comportamentos.

#### **Propriedades:**

```kotlin
var primeiroNome: String = ""
var segundoNome: String = ""
var telefone: String = ""
var email: String = ""
```

#### **Métodos:**

1. **`salvar()`**: Método para salvar o contato (implementação futura)
2. **`limpar()`**: Limpa todas as propriedades do contato

## 🎨 Interface de Usuário (XML)

### 📄 **activity_main.xml**

Layout principal que define a estrutura visual do aplicativo.

#### **Componentes Utilizados:**

| Componente | ID | Tipo | Função |
|------------|----|------|--------|
| **Título** | `txtTitulo` | `TextView` | Exibe "1º Aplicativo" |
| **Primeiro Nome** | `primeiroNome` | `EditText` | Campo para nome |
| **Segundo Nome** | `segundoNome` | `EditText` | Campo para sobrenome |
| **Telefone** | `telefone` | `EditText` | Campo para telefone |
| **Email** | `email` | `EditText` | Campo para email |
| **Botão Limpar** | `btnLimpar` | `Button` | Limpa formulário |
| **Botão Salvar** | `btnSalvar` | `Button` | Salva contato |

#### **Layout Manager:**
- **ConstraintLayout**: Layout responsivo que posiciona elementos através de constraints

#### **Características dos Campos:**

```xml
<!-- Exemplo de EditText -->
<EditText 
    android:id="@+id/primeiroNome"
    android:layout_width="0dp"
    android:layout_height="wrap_content"
    android:hint="Informe seu primeiro nome..."
    android:inputType="textPersonName"
    android:ems="10" />
```

- **`inputType`**: Define o tipo de teclado (textPersonName, phone, textEmailAddress)
- **`hint`**: Texto de dica quando campo está vazio
- **`ems`**: Largura do campo em caracteres

## 🔗 Integração Java/Kotlin ↔ XML

### 1. **Vinculação de Componentes (findViewById)**

```kotlin
// No onCreate() da MainActivity
primeiroNome = findViewById(R.id.primeiroNome)
segundoNome = findViewById(R.id.segundoNome)
telefone = findViewById(R.id.telefone)
email = findViewById(R.id.email)
btnLimpar = findViewById(R.id.btnLimpar)
btnSalvar = findViewById(R.id.btnSalvar)
```

**Como funciona:**
- `findViewById()` busca o componente XML pelo ID
- Retorna referência para manipulação no código
- Permite acesso às propriedades e métodos do componente

### 2. **Eventos de Usuário (OnClickListener)**

```kotlin
// Configuração de listeners para botões
btnLimpar?.setOnClickListener(View.OnClickListener {
    limpar()
})

btnSalvar?.setOnClickListener(View.OnClickListener {
    salvar()
})
```

**Como funciona:**
- `setOnClickListener()` define o que acontece quando botão é clicado
- Executa método específico (limpar ou salvar)
- Interface entre usuário e lógica de negócio

### 3. **Manipulação de Dados**

```kotlin
// Leitura de dados dos campos
contato?.primeiroNome = primeiroNome?.text.toString()
contato?.segundoNome = segundoNome?.text.toString()
contato?.telefone = telefone?.text.toString()
contato?.email = email?.text.toString()

// Escrita de dados nos campos
primeiroNome?.setText("")
segundoNome?.setText("")
```

**Como funciona:**
- `.text` acessa o texto digitado no EditText
- `.toString()` converte para String
- `.setText("")` limpa o campo

## 🎯 Fluxo de Execução

### 📱 **Inicialização do App:**

1. **AndroidManifest.xml** define MainActivity como ponto de entrada
2. **MainActivity.onCreate()** é executado
3. **Layout XML** é carregado e exibido
4. **Componentes** são vinculados às variáveis
5. **Listeners** são configurados para eventos

### 🔄 **Interação do Usuário:**

#### **Salvando Contato:**
1. Usuário preenche campos do formulário
2. Clica no botão "Salvar"
3. `OnClickListener` executa método `salvar()`
4. Dados são lidos dos EditText
5. Objeto `Contato` é criado e preenchido
6. Toast exibe mensagem de sucesso

#### **Limpando Formulário:**
1. Usuário clica no botão "Limpar"
2. `OnClickListener` executa método `limpar()`
3. Todos os EditText são resetados para vazio

## 🛠️ Tecnologias e Recursos Utilizados

### **Linguagem e Framework:**
- **Kotlin**: Linguagem de programação principal
- **Android SDK**: Framework de desenvolvimento
- **AndroidX**: Bibliotecas de suporte modernas

### **Componentes de Interface:**
- **ConstraintLayout**: Layout responsivo
- **EditText**: Campos de entrada de texto
- **Button**: Botões de ação
- **TextView**: Exibição de texto
- **Toast**: Mensagens temporárias

### **Recursos de Layout:**
- **Margins e Padding**: Espaçamento entre elementos
- **Constraints**: Posicionamento relativo
- **Colors**: Cores personalizadas (#088A4B, #D8F6CE)
- **Text Styles**: Estilos de texto (bold, size)

## 🎓 Conceitos de POO Demonstrados

### 1. **Classes e Objetos**
- **Classe Contato**: Define estrutura de dados
- **Objeto contato**: Instância criada em tempo de execução

### 2. **Propriedades (Atributos)**
- Dados que o objeto armazena (nome, telefone, email)

### 3. **Métodos (Comportamentos)**
- Ações que o objeto pode executar (salvar, limpar)

### 4. **Encapsulamento**
- Agrupamento de dados e comportamentos relacionados

### 5. **Integração com Interface**
- Objetos interagindo com componentes visuais

## 🚀 Como Executar

1. **Clone** o repositório
2. **Abra** o projeto no Android Studio
3. **Sincronize** o Gradle
4. **Execute** em emulador ou dispositivo físico
5. **Teste** as funcionalidades:
   - Preencha os campos
   - Clique em "Salvar"
   - Clique em "Limpar"

## 📊 Saída Esperada

- **Interface gráfica** com formulário completo
- **Campos de entrada** funcionais
- **Botões responsivos** com feedback visual
- **Mensagens Toast** ao salvar contato
- **Limpeza automática** dos campos

## 🎯 Objetivos de Aprendizado

Este projeto demonstra:
- ✅ Criação de classes em Kotlin
- ✅ Integração com interface XML
- ✅ Manipulação de eventos de usuário
- ✅ Vinculação de componentes
- ✅ Fluxo de dados entre UI e código
- ✅ Conceitos fundamentais de POO
- ✅ Desenvolvimento Android prático

---

**Desenvolvido com ❤️ para o Curso de Desenvolvimento Android Java e Kotlin**  
**Professor Marco Maddo** 🎓 