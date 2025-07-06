# AppAula01Classes - Introdução às Classes e Objetos em Android

## 📚 Sobre o Projeto

Este projeto foi desenvolvido pelo **Professor Marco Maddo** como parte do curso de Desenvolvimento Android, demonstrando conceitos fundamentais de **Programação Orientada a Objetos (POO)** através de um exemplo prático de criação de classes, objetos e métodos em Java para Android.

## 🎯 Objetivos de Aprendizado

- **Compreender o que é uma Classe** e como ela serve como um "molde" para criar objetos
- **Entender Getters e Setters** e sua importância no encapsulamento
- **Aprender a criar objetos** de uma classe usando construtores
- **Implementar métodos** em classes Java
- **Declarar e programar componentes de layout** definidos no XML
- **Capturar eventos de botões** e responder a interações do usuário
- **Modificar textos dinamicamente** em TextView
- **Criar métodos estáticos** e entender quando usá-los
- **Compreender a estrutura de um projeto Android** no Android Studio

## 🏗️ Estrutura de um Projeto Android

### Visão Geral da Estrutura de Pastas

```
AppAula01Classes/
├── app/                          # Módulo principal da aplicação
│   ├── build/                    # Arquivos compilados (gerados automaticamente)
│   ├── src/                      # Código fonte da aplicação
│   │   ├── main/                 # Código principal
│   │   │   ├── java/             # Código Java/Kotlin
│   │   │   ├── res/              # Recursos (layouts, imagens, strings)
│   │   │   └── AndroidManifest.xml # Configuração do app
│   │   ├── androidTest/          # Testes de interface
│   │   └── test/                 # Testes unitários
│   ├── build.gradle.kts          # Configuração de build do módulo
│   └── proguard-rules.pro        # Regras de ofuscação
├── gradle/                       # Configurações do Gradle
├── build.gradle.kts              # Configuração de build do projeto
├── settings.gradle.kts           # Configuração de módulos
├── gradle.properties             # Propriedades do Gradle
├── gradlew                       # Gradle Wrapper (Linux/Mac)
└── gradlew.bat                   # Gradle Wrapper (Windows)
```

### Explicação das Pastas Principais

#### 📁 **app/**
- **Módulo principal** da aplicação Android
- Contém todo o código, recursos e configurações específicas do app

#### 📁 **app/src/main/**
- **Código fonte principal** da aplicação
- Aqui ficam os arquivos Java/Kotlin, layouts XML e recursos

#### 📁 **app/src/main/java/**
- **Código Java/Kotlin** da aplicação
- Organizado em pacotes (packages) seguindo a convenção de nomenclatura

#### 📁 **app/src/main/res/**
- **Recursos da aplicação** (layouts, imagens, strings, cores, etc.)
- Cada tipo de recurso fica em sua pasta específica

#### 📁 **app/src/main/res/layout/**
- **Arquivos XML de layout** que definem a interface do usuário
- Cada Activity geralmente tem seu próprio arquivo de layout

#### 📁 **app/src/main/res/values/**
- **Valores constantes** como strings, cores, dimensões, temas
- Centraliza recursos para facilitar manutenção e internacionalização

#### 📁 **app/src/main/res/drawable/**
- **Imagens e drawables** da aplicação
- Ícones, backgrounds, shapes, etc.

#### 📁 **app/src/main/res/mipmap-***/
- **Ícones da aplicação** em diferentes densidades de tela
- hdpi, mdpi, xhdpi, xxhdpi, xxxhdpi

## 📋 Arquivos do Projeto

### 1. **Pessoa.java** - A Classe Modelo

```java
package foo.maddo.appaula01classes;

public class Pessoa {

    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }
}
```

#### 🔍 **Análise Detalhada da Classe Pessoa**

##### **O que é uma Classe?**
Uma **classe** é um "molde" ou "template" que define:
- **Atributos** (variáveis que armazenam dados)
- **Métodos** (funções que realizam ações)
- **Construtores** (métodos especiais para criar objetos)

##### **Atributos Privados (Encapsulamento)**
```java
private String nome;
private int idade;
```
- **`private`**: Modificador de acesso que impede acesso direto aos atributos
- **Encapsulamento**: Protege os dados e controla como eles são acessados
- **Boas práticas**: Sempre use atributos privados e acesse através de métodos

##### **Construtor**
```java
public Pessoa(String nome, int idade) {
    this.nome = nome;
    this.idade = idade;
}
```
- **Construtor**: Método especial que inicializa um objeto
- **`this`**: Referência ao objeto atual sendo criado
- **Parâmetros**: Valores necessários para criar o objeto

##### **Getters (Métodos Acessores)**
```java
public String getNome() {
    return nome;
}

public int getIdade() {
    return idade;
}
```
- **Getters**: Métodos que retornam o valor de atributos privados
- **Convenção**: Nome começa com "get" + nome do atributo
- **Propósito**: Permitir acesso controlado aos dados

### 2. **MainActivity.java** - A Activity Principal

```java
package foo.maddo.appaula01classes;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public Pessoa pessoa;
    Button btnFabricarObjetoPessoa;
    TextView txtPessoa;
    int contagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtPessoa = findViewById(R.id.txtPessoa);
        btnFabricarObjetoPessoa = findViewById(R.id.btnFabricarObjetoPessoa);
        btnFabricarObjetoPessoa.setOnClickListener(v -> { fabricaPessoa(); });
    }

    private void fabricaPessoa() {
        int idade = getIdade();
        contagem++;
        pessoa = new Pessoa("Marco", idade);
        txtPessoa.setText(pessoa.getNome() + " " + pessoa.getIdade()+" - "+contagem+"ª Pessoas");
    }

    private static int getIdade() {
        Random idadeAleatoria = new Random();
        int min = 18;
        int max = 50;
        int idade = idadeAleatoria.nextInt(max - min + 1) + min;
        return idade;
    }
}
```

#### 🔍 **Análise Detalhada da MainActivity**

##### **Declaração de Variáveis de Instância**
```java
public Pessoa pessoa;
Button btnFabricarObjetoPessoa;
TextView txtPessoa;
int contagem;
```
- **Variáveis de instância**: Pertencem ao objeto da classe
- **Acessíveis em toda a classe**: Podem ser usadas em qualquer método
- **Ciclo de vida**: Existem enquanto o objeto existe

##### **Método onCreate()**
```java
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    EdgeToEdge.enable(this);
    setContentView(R.layout.activity_main);
    // ... configuração de insets
}
```
- **`@Override`**: Indica que estamos sobrescrevendo um método da classe pai
- **`super.onCreate()`**: Chama o método da classe pai (AppCompatActivity)
- **`setContentView()`**: Define qual layout será usado pela Activity
- **`EdgeToEdge.enable()`**: Habilita interface edge-to-edge (Android 14+)

##### **Declaração de Componentes de Layout**
```java
txtPessoa = findViewById(R.id.txtPessoa);
btnFabricarObjetoPessoa = findViewById(R.id.btnFabricarObjetoPessoa);
```
- **`findViewById()`**: Método que conecta variáveis Java aos componentes XML
- **`R.id.nome_do_componente`**: Referência ao ID definido no XML
- **Importante**: Sempre declare os componentes após `setContentView()`

##### **Configuração de Eventos (Event Handling)**
```java
btnFabricarObjetoPessoa.setOnClickListener(v -> { fabricaPessoa(); });
```
- **`setOnClickListener()`**: Define o que acontece quando o botão é clicado
- **Lambda expression**: `v -> { fabricaPessoa(); }` (Java 8+)
- **`v`**: Parâmetro que representa a View clicada (não usado neste caso)

##### **Método fabricaPessoa()**
```java
private void fabricaPessoa() {
    int idade = getIdade();
    contagem++;
    pessoa = new Pessoa("Marco", idade);
    txtPessoa.setText(pessoa.getNome() + " " + pessoa.getIdade()+" - "+contagem+"ª Pessoas");
}
```
- **Criação de objeto**: `new Pessoa("Marco", idade)` cria uma nova instância
- **Uso de getters**: `pessoa.getNome()` e `pessoa.getIdade()` acessam dados
- **Modificação de TextView**: `txtPessoa.setText()` altera o texto dinamicamente
- **Concatenação**: `+` une strings e valores

##### **Método Estático getIdade()**
```java
private static int getIdade() {
    Random idadeAleatoria = new Random();
    int min = 18;
    int max = 50;
    int idade = idadeAleatoria.nextInt(max - min + 1) + min;
    return idade;
}
```
- **`static`**: Método que pertence à classe, não ao objeto
- **Pode ser chamado sem criar objeto**: `getIdade()` em vez de `this.getIdade()`
- **Geração de números aleatórios**: `Random.nextInt()` gera números entre min e max
- **Fórmula**: `nextInt(max - min + 1) + min` garante números no intervalo desejado

### 3. **activity_main.xml** - Layout da Interface

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <TextView
        android:id="@+id/textView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:gravity="center"
        android:text="Curso Desenvolvimento Android\nJava e Kotlin\nProgramação Orientada a Objetosn\nAula 01 Java - Classe Pessoa"
        android:textSize="22sp"
        android:textStyle="bold"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.059" />

    <Button
        android:id="@+id/btnFabricarObjetoPessoa"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="64dp"
        android:layout_margin="16dp"
        android:text="Fabricar uma Pessoa"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.497"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textView" />

    <TextView
        android:id="@+id/txtPessoa"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Nenhuma Pessoa Fabricada"
        android:textSize="22sp"
        android:textStyle="bold"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/btnFabricarObjetoPessoa"
        app:layout_constraintVertical_bias="0.228" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

#### 🔍 **Análise Detalhada do Layout**

##### **ConstraintLayout**
- **Layout principal**: Organiza componentes usando constraints (restrições)
- **Flexível**: Permite layouts responsivos e complexos
- **Performance**: Mais eficiente que layouts aninhados

##### **TextView Principal (Título)**
```xml
<TextView
    android:id="@+id/textView"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:gravity="center"
    android:text="Curso Desenvolvimento Android\nJava e Kotlin\nProgramação Orientada a Objetosn\nAula 01 Java - Classe Pessoa"
    android:textSize="22sp"
    android:textStyle="bold"
    app:layout_constraintBottom_toBottomOf="parent"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toTopOf="parent"
    app:layout_constraintVertical_bias="0.059" />
```
- **`android:id`**: Identificador único para referência no Java
- **`wrap_content`**: Tamanho se ajusta ao conteúdo
- **`gravity="center"`**: Centraliza o texto dentro do componente
- **`\n`**: Quebra de linha no texto
- **Constraints**: Posiciona o componente na tela

##### **Button**
```xml
<Button
    android:id="@+id/btnFabricarObjetoPessoa"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_marginTop="64dp"
    android:layout_margin="16dp"
    android:text="Fabricar uma Pessoa"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toBottomOf="@+id/textView" />
```
- **`match_parent`**: Ocupa toda a largura disponível
- **`layout_margin`**: Espaçamento externo
- **`@+id/textView`**: Referência ao ID de outro componente

##### **TextView de Resultado**
```xml
<TextView
    android:id="@+id/txtPessoa"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Nenhuma Pessoa Fabricada"
    android:textSize="22sp"
    android:textStyle="bold"
    app:layout_constraintBottom_toBottomOf="parent"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toBottomOf="@+id/btnFabricarObjetoPessoa"
    app:layout_constraintVertical_bias="0.228" />
```
- **Texto inicial**: "Nenhuma Pessoa Fabricada"
- **Será modificado dinamicamente** pelo código Java

### 4. **AndroidManifest.xml** - Configuração do App

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools">

    <application
        android:allowBackup="true"
        android:dataExtractionRules="@xml/data_extraction_rules"
        android:fullBackupContent="@xml/backup_rules"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/Theme.AppAula01Classes">
        <activity
            android:name=".MainActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
```

#### 🔍 **Análise do Manifest**

##### **Elementos Principais**
- **`<application>`**: Configurações gerais do app
- **`<activity>`**: Define uma Activity (tela) do app
- **`<intent-filter>`**: Define como a Activity pode ser iniciada
- **`android:exported="true"`**: Permite que outros apps iniciem esta Activity
- **`MAIN/LAUNCHER`**: Indica que esta é a Activity principal do app

### 5. **build.gradle.kts** - Configuração de Build

```kotlin
plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "foo.maddo.appaula01classes"
    compileSdk = 36

    defaultConfig {
        applicationId = "foo.maddo.appaula01classes"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
```

#### 🔍 **Análise do Build.gradle.kts**

##### **Configurações Importantes**
- **`namespace`**: Identificador único do app
- **`compileSdk`**: Versão do Android SDK para compilação
- **`minSdk`**: Versão mínima do Android suportada
- **`targetSdk`**: Versão alvo do Android
- **`applicationId`**: ID único do app na Google Play Store

##### **Dependências**
- **`appcompat`**: Suporte a versões antigas do Android
- **`material`**: Componentes do Material Design
- **`constraintlayout`**: Layout usado no projeto
- **`junit` e `espresso`**: Bibliotecas de teste

## 🚀 Como Executar o Projeto

### Pré-requisitos
- Android Studio (versão mais recente)
- JDK 11 ou superior
- Android SDK (API 24+)

### Passos para Execução
1. **Abra o projeto** no Android Studio
2. **Sincronize o Gradle** (File → Sync Project with Gradle Files)
3. **Conecte um dispositivo** Android ou inicie um emulador
4. **Clique em Run** (botão verde de play) ou pressione Shift+F10

### Funcionamento do App
1. **Tela inicial** mostra o título do curso e um botão
2. **Clique no botão** "Fabricar uma Pessoa"
3. **App cria um objeto** Pessoa com nome "Marco" e idade aleatória
4. **Texto é atualizado** mostrando os dados da pessoa criada
5. **Contador** mostra quantas pessoas foram criadas

## 🎓 Conceitos Aprendidos

### ✅ **Programação Orientada a Objetos**
- **Classe**: Molde para criar objetos
- **Objeto**: Instância de uma classe
- **Encapsulamento**: Proteção de dados com getters/setters
- **Construtor**: Método especial para inicializar objetos

### ✅ **Android Development**
- **Activity**: Tela principal do app
- **Layout XML**: Definição da interface do usuário
- **findViewById()**: Conexão entre Java e XML
- **Event Handling**: Resposta a interações do usuário

### ✅ **Java Programming**
- **Métodos estáticos**: Pertencem à classe, não ao objeto
- **Variáveis de instância**: Pertencem ao objeto
- **Random**: Geração de números aleatórios
- **String concatenation**: União de textos

### ✅ **Android Studio**
- **Estrutura de projetos**: Organização de pastas e arquivos
- **Gradle**: Sistema de build e dependências
- **Manifest**: Configuração do app
- **Resources**: Organização de recursos (layouts, strings, etc.)

## 🔧 Personalização e Experimentação

### Sugestões para Prática
1. **Adicione mais atributos** à classe Pessoa (email, telefone, etc.)
2. **Crie setters** para permitir modificação dos dados
3. **Adicione validação** nos construtores e setters
4. **Crie mais métodos** na classe Pessoa (ex: calcularIdadeEmMeses())
5. **Modifique o layout** para mostrar mais informações
6. **Adicione mais botões** com diferentes funcionalidades

### Exemplo de Melhoria
```java
// Adicionar setter na classe Pessoa
public void setNome(String nome) {
    if (nome != null && !nome.trim().isEmpty()) {
        this.nome = nome;
    }
}

// Adicionar método para calcular idade em meses
public int getIdadeEmMeses() {
    return idade * 12;
}
```

## 📚 Recursos Adicionais

### Documentação Oficial
- [Android Developers - Activities](https://developer.android.com/guide/components/activities)
- [Android Developers - Layouts](https://developer.android.com/guide/topics/ui/declaring-layout)
- [Oracle Java Tutorial - Classes](https://docs.oracle.com/javase/tutorial/java/javaOO/classes.html)

### Próximos Passos no Curso
- **Herança**: Criar classes que herdam de outras
- **Polimorfismo**: Usar objetos de forma polimórfica
- **Interfaces**: Definir contratos entre classes
- **Collections**: Listas, arrays e outras estruturas de dados

---

**Desenvolvido pelo Professor Marco Maddo**  
**Curso de Desenvolvimento Android - Java e Kotlin**  
**Aula 01: Introdução às Classes e Objetos** 