# 📱 FontesAula01POO - Aplicativo de Contatos (Java)

> **Parte do Curso Desenvolvimento Android Java e Kotlin**  
> **Professor: Marco Maddo** 🎓

## 📋 Sobre o Projeto

O **FontesAula01POO** é um aplicativo Android desenvolvido em **Java** que demonstra os conceitos fundamentais de **Programação Orientada a Objetos (POO)** integrados com **interface gráfica**. O projeto serve como exemplo prático de como criar um aplicativo completo que combina:

- **Classes e Objetos** em Java
- **Interface de Usuário** em XML
- **Integração** entre código Java e layout XML
- **Eventos de Usuário** (cliques de botões)
- **Manipulação de Dados** em tempo real
- **Criação de Múltiplos Objetos** da mesma classe

## 🎯 Funcionalidades do App

O aplicativo permite ao usuário:

1. **📝 Inserir Dados**: Preencher formulário com informações pessoais
2. **💾 Salvar Contato**: Criar objetos da classe Contato com os dados inseridos
3. **🧹 Limpar Formulário**: Resetar todos os campos para vazio
4. **📱 Interface Intuitiva**: Interface gráfica amigável e responsiva
5. **📊 Exibir Dados**: Mostrar informações via Toast messages
6. **🏭 Criação de Objetos**: Demonstração de múltiplas instâncias da classe

## 🏗️ Arquitetura do Projeto

### 📁 **Estrutura de Arquivos**

```
app/src/main/
├── java/foo/maddo/fontesaula01poo/
│   ├── MainActivity.java        # Activity principal
│   └── Contato.java            # Classe de modelo de dados
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

### 🚀 **MainActivity.java**

A **Activity Principal** que gerencia a interface e a lógica do aplicativo em Java.

#### **Propriedades (Variáveis de Instância):**

```java
// Referências para os componentes de interface
EditText primeiroNome, segundoNome, telefone, email;
Button btnLimpar, btnSalvar;

// Objeto da classe Contato
Contato contato;
```

#### **Métodos Principais:**

1. **`onCreate()`**: Inicialização da Activity
   - Configura o layout XML
   - Vincula componentes XML com variáveis Java
   - Configura listeners de eventos usando classes anônimas

2. **Listener do Botão Limpar**: Limpa todos os campos do formulário
   - Reseta todos os EditText para vazio
   - Implementado como classe anônima

3. **Listener do Botão Salvar**: Processa e salva dados do contato
   - Exibe dados via Toast messages
   - Cria objeto da classe Contato
   - Demonstra criação de múltiplos objetos
   - Chama métodos da classe Contato

### 👤 **Contato.java**

A **Classe de Modelo** que representa um contato com suas propriedades e comportamentos.

#### **Propriedades:**

```java
public String primeiroNome;
public String segundoNome;
public String telefone;
public String email;
```

#### **Métodos:**

1. **`salvar()`**: Método para salvar o contato (implementação futura)
2. **`limpar()`**: Método para limpar dados do contato (implementação futura)

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

## 🔗 Integração Java ↔ XML

### 1. **Vinculação de Componentes (findViewById)**

```java
// No onCreate() da MainActivity
primeiroNome = findViewById(R.id.primeiroNome);
segundoNome = findViewById(R.id.segundoNome);
telefone = findViewById(R.id.telefone);
email = findViewById(R.id.email);
btnLimpar = findViewById(R.id.btnLimpar);
btnSalvar = findViewById(R.id.btnSalvar);
```

**Como funciona:**
- `findViewById()` busca o componente XML pelo ID
- Retorna referência para manipulação no código Java
- Permite acesso às propriedades e métodos do componente

### 2. **Eventos de Usuário (OnClickListener com Classes Anônimas)**

```java
// Configuração de listeners para botões usando classes anônimas
btnLimpar.setOnClickListener(
    new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            primeiroNome.setText("");
            segundoNome.setText("");
            telefone.setText("");
            email.setText("");
        }
    });

btnSalvar.setOnClickListener(
    new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Lógica de salvamento
            contato = new Contato();
            contato.salvar();
            contato.limpar();
        }
    });
```

**Como funciona:**
- `setOnClickListener()` define o que acontece quando botão é clicado
- **Classes Anônimas**: Implementação inline da interface OnClickListener
- Executa lógica específica (limpar ou salvar)
- Interface entre usuário e lógica de negócio

### 3. **Manipulação de Dados**

```java
// Leitura de dados dos campos
String nome = primeiroNome.getText().toString();
String sobrenome = segundoNome.getText().toString();
String telefoneStr = telefone.getText().toString();
String emailStr = email.getText().toString();

// Escrita de dados nos campos
primeiroNome.setText("");
segundoNome.setText("");
telefone.setText("");
email.setText("");

// Exibição via Toast
Toast.makeText(getApplicationContext(), "Primeiro nome: " + nome, Toast.LENGTH_LONG).show();
```

**Como funciona:**
- `.getText()` acessa o texto digitado no EditText
- `.toString()` converte para String
- `.setText("")` limpa o campo
- `Toast.makeText()` exibe mensagens temporárias

### 4. **Criação de Objetos**

```java
// Criação de múltiplos objetos da classe Contato
contato = new Contato();
Contato maddo = new Contato();
Contato joana = new Contato();
Contato objMaria = new Contato();
```

**Como funciona:**
- `new Contato()` instancia um novo objeto
- Cada objeto é independente e pode armazenar dados diferentes
- Demonstra o conceito de múltiplas instâncias da mesma classe

## 🎯 Fluxo de Execução

### 📱 **Inicialização do App:**

1. **AndroidManifest.xml** define MainActivity como ponto de entrada
2. **MainActivity.onCreate()** é executado
3. **Layout XML** é carregado e exibido
4. **Componentes** são vinculados às variáveis Java
5. **Listeners** são configurados usando classes anônimas

### 🔄 **Interação do Usuário:**

#### **Salvando Contato:**
1. Usuário preenche campos do formulário
2. Clica no botão "Salvar"
3. `OnClickListener` (classe anônima) executa lógica de salvamento
4. Dados são lidos dos EditText via Toast
5. Objeto `Contato` é criado
6. Métodos `salvar()` e `limpar()` são chamados
7. Múltiplos objetos são criados para demonstração

#### **Limpando Formulário:**
1. Usuário clica no botão "Limpar"
2. `OnClickListener` (classe anônima) executa lógica de limpeza
3. Todos os EditText são resetados para vazio

## 🛠️ Tecnologias e Recursos Utilizados

### **Linguagem e Framework:**
- **Java**: Linguagem de programação principal
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

### **Padrões Java:**
- **Classes Anônimas**: Para implementação de interfaces
- **findViewById**: Vinculação de componentes
- **Event Handling**: Gerenciamento de eventos de usuário

## 🎓 Conceitos de POO Demonstrados

### 1. **Classes e Objetos**
- **Classe Contato**: Define estrutura de dados
- **Objetos contato, maddo, joana, objMaria**: Instâncias criadas em tempo de execução

### 2. **Propriedades (Atributos)**
- Dados que o objeto armazena (nome, telefone, email)
- Acesso direto às propriedades públicas

### 3. **Métodos (Comportamentos)**
- Ações que o objeto pode executar (salvar, limpar)

### 4. **Encapsulamento**
- Agrupamento de dados e comportamentos relacionados

### 5. **Integração com Interface**
- Objetos interagindo com componentes visuais

### 6. **Múltiplas Instâncias**
- Criação de vários objetos da mesma classe
- Cada objeto mantém seus próprios dados

## 🆚 Diferenças Java vs Kotlin

| Aspecto | Java | Kotlin |
|---------|------|--------|
| **Declaração de Variáveis** | `EditText primeiroNome` | `var primeiroNome: EditText?` |
| **Listeners** | Classes anônimas | Lambda expressions |
| **Null Safety** | Manual | Automático |
| **Sintaxe** | Mais verboso | Mais conciso |
| **findViewById** | Manual | View Binding (moderno) |
| **String Concatenation** | `+` | `$` (string templates) |

## 🚀 Como Executar

1. **Clone** o repositório
2. **Abra** o projeto no Android Studio
3. **Sincronize** o Gradle
4. **Execute** em emulador ou dispositivo físico
5. **Teste** as funcionalidades:
   - Preencha os campos
   - Clique em "Salvar" (verá Toasts com os dados)
   - Clique em "Limpar"

## 📊 Saída Esperada

- **Interface gráfica** com formulário completo
- **Campos de entrada** funcionais
- **Botões responsivos** com feedback visual
- **Mensagens Toast** ao salvar contato mostrando:
  - "Primeiro nome: [valor]"
  - "Segundo nome: [valor]"
  - "Telefone: [valor]"
  - "Email: [valor]"
- **Limpeza automática** dos campos

## 🎯 Objetivos de Aprendizado

Este projeto demonstra:
- ✅ Criação de classes em Java
- ✅ Integração com interface XML
- ✅ Manipulação de eventos de usuário
- ✅ Vinculação de componentes com findViewById
- ✅ Uso de classes anônimas para listeners
- ✅ Fluxo de dados entre UI e código
- ✅ Criação de múltiplos objetos
- ✅ Conceitos fundamentais de POO
- ✅ Desenvolvimento Android prático em Java

## 🌟 Vantagens do Java

- **Estabilidade**: Linguagem madura e estável
- **Documentação**: Extensa documentação e recursos
- **Comunidade**: Grande comunidade de desenvolvedores
- **Compatibilidade**: Funciona em todas as versões do Android
- **Padrões Estabelecidos**: Padrões bem definidos e testados

---

**Desenvolvido com ❤️ para o Curso de Desenvolvimento Android Java e Kotlin**  
**Professor Marco Maddo** 🎓 