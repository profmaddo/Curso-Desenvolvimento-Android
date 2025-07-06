# 🍔 TemplateMenuDrawer - Template de Navegação com Menu Drawer

> **Parte do Curso Desenvolvimento Android Java e Kotlin**  
> **Professor: Marco Maddo** 🎓

## 📋 Sobre o Projeto

O **TemplateMenuDrawer** é um projeto Android que serve como **template starter** para criação de aplicativos com navegação usando **Navigation Drawer** (Menu Lateral). O projeto demonstra uma implementação completa e funcional de menu drawer, incluindo:

- **Navigation Drawer** com animações suaves
- **Toolbar** integrada com hamburger menu
- **Header personalizado** do menu drawer
- **Itens de menu** com ícones e funcionalidades
- **Mudança dinâmica** de cores e textos
- **Floating Action Button** (FAB)
- **CoordinatorLayout** para layout responsivo

## 🎯 Objetivos do Template

Este projeto tem como objetivo fornecer:

1. **🏗️ Base Sólida**: Estrutura pronta para projetos com menu drawer
2. **📚 Aprendizado**: Exemplo prático de navegação Android
3. **🔧 Customização**: Fácil adaptação para diferentes projetos
4. **🎨 Interface Moderna**: Design Material Design
5. **⚡ Performance**: Implementação otimizada

## 🏗️ Arquitetura do Projeto

### 📁 **Estrutura de Arquivos**

```
app/src/main/
├── java/foo/maddo/templatemenudrawer/
│   └── MainActivity.java              # Activity principal
├── res/
│   ├── layout/
│   │   ├── activity_main.xml         # Layout principal com DrawerLayout
│   │   ├── app_bar_main.xml          # Layout da toolbar e FAB
│   │   ├── content_main.xml          # Conteúdo principal
│   │   └── nav_header_main.xml       # Header do menu drawer
│   ├── menu/
│   │   ├── activity_main_drawer.xml  # Itens do menu drawer
│   │   └── main.xml                  # Menu da toolbar
│   ├── drawable/
│   │   ├── ic_menu_preto.xml         # Ícone menu preto
│   │   ├── ic_menu_vermelho.xml      # Ícone menu vermelho
│   │   ├── ic_menu_azul.xml          # Ícone menu azul
│   │   └── side_nav_bar.xml          # Background do header
│   └── values/
│       ├── strings.xml               # Strings do app
│       ├── colors.xml                # Cores
│       ├── themes.xml                # Temas
│       └── dimens.xml                # Dimensões
└── AndroidManifest.xml               # Configuração do app
```

## 📱 Classes e Componentes

### 🚀 **MainActivity.java**

A **Activity Principal** que gerencia toda a navegação e funcionalidades do menu drawer.

#### **Características Principais:**

```java
public class MainActivity extends AppCompatActivity 
    implements NavigationView.OnNavigationItemSelectedListener {
    
    NavigationView navigationView;
    Menu menu;
    MenuItem nav_preto, nav_vermelho, nav_azul;
    TextView txtTitulo;
}
```

#### **Funcionalidades Implementadas:**

1. **🔄 Navigation Drawer**: Gerenciamento completo do menu lateral
2. **🎨 Mudança de Cores**: Alteração dinâmica de cores do app
3. **📝 Mudança de Textos**: Atualização de títulos dos itens
4. **🎯 Toolbar Integration**: Integração com ActionBar/Toolbar
5. **🔙 Back Navigation**: Gerenciamento do botão voltar

#### **Métodos Principais:**

- **`onCreate()`**: Inicialização e configuração
- **`onBackPressed()`**: Gerenciamento do botão voltar
- **`onNavigationItemSelected()`**: Tratamento de cliques no menu
- **`onCreateOptionsMenu()`**: Criação do menu da toolbar
- **`onOptionsItemSelected()`**: Tratamento de cliques na toolbar

## 🎨 Estrutura XML Detalhada

### 📄 **1. activity_main.xml (Layout Principal)**

```xml
<androidx.drawerlayout.widget.DrawerLayout
    android:id="@+id/drawer_layout"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:fitsSystemWindows="true"
    tools:openDrawer="start">

    <include layout="@layout/app_bar_main" />
    
    <com.google.android.material.navigation.NavigationView
        android:id="@+id/nav_view"
        android:layout_width="wrap_content"
        android:layout_height="match_parent"
        android:layout_gravity="start"
        android:fitsSystemWindows="true"
        app:headerLayout="@layout/nav_header_main"
        app:menu="@menu/activity_main_drawer" />

</androidx.drawerlayout.widget.DrawerLayout>
```

**Características Importantes:**
- **`DrawerLayout`**: Container principal para navegação
- **`fitsSystemWindows="true"`**: Ajuste automático para status bar
- **`tools:openDrawer="start"`**: Preview no Android Studio
- **`include`**: Reutilização do layout da toolbar
- **`NavigationView`**: Componente do menu drawer

### 📄 **2. app_bar_main.xml (Toolbar e FAB)**

```xml
<androidx.coordinatorlayout.widget.CoordinatorLayout>
    
    <com.google.android.material.appbar.AppBarLayout>
        <androidx.appcompat.widget.Toolbar
            android:id="@+id/toolbar"
            android:layout_width="match_parent"
            android:layout_height="?attr/actionBarSize"
            android:background="?attr/colorPrimary"
            app:popupTheme="@style/AppTheme.PopupOverlay" />
    </com.google.android.material.appbar.AppBarLayout>

    <include layout="@layout/content_main" />

    <com.google.android.material.floatingactionbutton.FloatingActionButton
        android:id="@+id/fab"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="bottom|end"
        android:layout_margin="@dimen/fab_margin"
        app:srcCompat="@android:drawable/ic_dialog_email" />

</androidx.coordinatorlayout.widget.CoordinatorLayout>
```

**Características Importantes:**
- **`CoordinatorLayout`**: Layout responsivo com comportamentos
- **`AppBarLayout`**: Container para toolbar e elementos de app bar
- **`Toolbar`**: Barra de ferramentas customizável
- **`FloatingActionButton`**: Botão flutuante de ação

### 📄 **3. content_main.xml (Conteúdo Principal)**

```xml
<androidx.constraintlayout.widget.ConstraintLayout
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:layout_behavior="@string/appbar_scrolling_view_behavior"
    tools:showIn="@layout/app_bar_main">

    <TextView
        android:id="@+id/txtTitulo"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Curso Android\nVersão 2023\nAtualização\ndo\nCurso"
        android:textSize="30sp"
        android:gravity="center"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

**Características Importantes:**
- **`layout_behavior`**: Comportamento de scroll com AppBarLayout
- **`tools:showIn`**: Referência para preview no Android Studio
- **`ConstraintLayout`**: Layout flexível e responsivo

### 📄 **4. nav_header_main.xml (Header do Menu)**

```xml
<LinearLayout
    android:layout_width="match_parent"
    android:layout_height="@dimen/nav_header_height"
    android:background="@drawable/side_nav_bar"
    android:gravity="bottom"
    android:orientation="vertical"
    android:theme="@style/ThemeOverlay.AppCompat.Dark">

    <ImageView
        android:id="@+id/imageView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:contentDescription="@string/nav_header_desc"
        app:srcCompat="@mipmap/ic_launcher_round" />

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/nav_header_title"
        android:textAppearance="@style/TextAppearance.AppCompat.Body1" />

    <TextView
        android:id="@+id/textView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/nav_header_subtitle" />

</LinearLayout>
```

**Características Importantes:**
- **`background`**: Imagem de fundo personalizada
- **`theme="@style/ThemeOverlay.AppCompat.Dark"`**: Tema escuro para o header
- **`gravity="bottom"`**: Alinhamento na parte inferior
- **`dimens`**: Altura personalizada do header

## 🍔 Estrutura dos Menus

### 📄 **1. activity_main_drawer.xml (Menu do Drawer)**

```xml
<menu xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    tools:showIn="navigation_view">

    <group android:checkableBehavior="single">
        
        <item android:id="@+id/nav_preto"
            android:icon="@drawable/ic_menu_preto"
            android:title="Preto" />

        <item android:id="@+id/nav_vermelho"
            android:icon="@drawable/ic_menu_vermelho"
            android:title="Vermelho" />

        <item android:id="@+id/nav_azul"
            android:icon="@drawable/ic_menu_azul"
            android:title="Azul" />

    </group>

</menu>
```

**Características Importantes:**
- **`group`**: Agrupamento de itens relacionados
- **`checkableBehavior="single"`**: Seleção única (radio button)
- **`android:icon`**: Ícones personalizados para cada item
- **`tools:showIn`**: Preview no Android Studio

### 📄 **2. main.xml (Menu da Toolbar)**

```xml
<menu xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">
    
    <item
        android:id="@+id/action_settings"
        android:orderInCategory="100"
        android:title="@string/action_settings"
        app:showAsAction="never" />
        
</menu>
```

**Características Importantes:**
- **`orderInCategory`**: Ordem de exibição no menu
- **`showAsAction="never"`**: Sempre no menu overflow
- **`app:showAsAction`**: Comportamento de exibição

## 🔧 Implementação Java Detalhada

### 🚀 **Inicialização e Configuração**

```java
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    EdgeToEdge.enable(this);
    setContentView(R.layout.activity_main);
    
    // Configuração da Toolbar
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    
    // Configuração do FAB
    FloatingActionButton fab = findViewById(R.id.fab);
    fab.setOnClickListener(view -> Snackbar.make(view, 
        "Replace with your own action", Snackbar.LENGTH_LONG)
        .setAction("Action", null).show());
    
    // Configuração do Drawer
    DrawerLayout drawer = findViewById(R.id.drawer_layout);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
        this, drawer, toolbar, 
        R.string.navigation_drawer_open, 
        R.string.navigation_drawer_close);
    drawer.addDrawerListener(toggle);
    toggle.syncState();
    
    // Configuração do NavigationView
    navigationView = findViewById(R.id.nav_view);
    navigationView.setNavigationItemSelectedListener(this);
    
    txtTitulo = findViewById(R.id.txtTitulo);
}
```

### 🎯 **Gerenciamento do Botão Voltar**

```java
@SuppressLint("GestureBackNavigation")
@Override
public void onBackPressed() {
    DrawerLayout drawer = findViewById(R.id.drawer_layout);
    if (drawer.isDrawerOpen(GravityCompat.START)) {
        drawer.closeDrawer(GravityCompat.START);
    } else {
        super.onBackPressed();
    }
}
```

### 🍔 **Tratamento de Cliques no Menu**

```java
@Override
public boolean onNavigationItemSelected(MenuItem item) {
    int id = item.getItemId();
    
    if (id == R.id.nav_preto) {
        // Lógica para opção preto
        menu = navigationView.getMenu();
        nav_preto = menu.findItem(R.id.nav_preto);
        nav_preto.setTitle("Preto Ativado");
        
        // Atualizar outros itens
        nav_vermelho = menu.findItem(R.id.nav_vermelho);
        nav_vermelho.setTitle("Vermelho");
        nav_azul = menu.findItem(R.id.nav_azul);
        nav_azul.setTitle("Azul");
        
        // Mudar cor do menu e título
        navigationView.setItemTextColor(ColorStateList.valueOf(Color.BLACK));
        txtTitulo.setTextColor(ColorStateList.valueOf(Color.BLACK));
        
    } else if (id == R.id.nav_vermelho) {
        // Lógica similar para vermelho
    } else if (id == R.id.nav_azul) {
        // Lógica similar para azul
    }
    
    // Fechar o drawer após seleção
    DrawerLayout drawer = findViewById(R.id.drawer_layout);
    drawer.closeDrawer(GravityCompat.START);
    return true;
}
```

## 🎨 Funcionalidades Demonstradas

### 🎯 **Mudança Dinâmica de Cores**

O template demonstra como:
- **Alterar cor do texto** do menu programaticamente
- **Mudar cor do título** principal
- **Atualizar textos** dos itens do menu
- **Manter estado** da seleção atual

### 🔄 **Navegação Intuitiva**

- **Hamburger Menu**: Botão na toolbar para abrir/fechar
- **Swipe Gesture**: Deslizar da borda esquerda
- **Back Button**: Fecha drawer se aberto
- **Smooth Animations**: Transições suaves

### 🎨 **Design Material**

- **Toolbar**: Barra de ferramentas moderna
- **FAB**: Botão flutuante de ação
- **CoordinatorLayout**: Layout responsivo
- **Themes**: Aplicação de temas Material Design

## 🚀 Como Usar como Template

### 📋 **Passos para Adaptação:**

1. **Clone o projeto** como base
2. **Modifique os itens** do menu em `activity_main_drawer.xml`
3. **Adicione ícones** personalizados em `drawable/`
4. **Customize o header** em `nav_header_main.xml`
5. **Implemente a lógica** em `onNavigationItemSelected()`
6. **Adapte as cores** e temas conforme necessário

### 🔧 **Personalizações Comuns:**

#### **Adicionar Novos Itens de Menu:**
```xml
<item android:id="@+id/nav_novo_item"
    android:icon="@drawable/ic_novo_icone"
    android:title="Novo Item" />
```

#### **Implementar Navegação para Fragments:**
```java
if (id == R.id.nav_novo_item) {
    // Carregar fragment
    getSupportFragmentManager().beginTransaction()
        .replace(R.id.fragment_container, new NovoFragment())
        .commit();
}
```

#### **Customizar Cores:**
```java
// Mudar cor do menu
navigationView.setItemTextColor(ColorStateList.valueOf(Color.RED));

// Mudar cor do header
navigationView.setItemBackgroundColor(ColorStateList.valueOf(Color.BLUE));
```

## 🛠️ Tecnologias e Recursos Utilizados

### **Linguagem e Framework:**
- **Java**: Linguagem de programação principal
- **Android SDK**: Framework de desenvolvimento
- **Material Design**: Design system moderno

### **Componentes de Navegação:**
- **DrawerLayout**: Container principal do drawer
- **NavigationView**: Componente do menu lateral
- **ActionBarDrawerToggle**: Integração com toolbar
- **CoordinatorLayout**: Layout responsivo

### **Recursos de Interface:**
- **Toolbar**: Barra de ferramentas customizável
- **FloatingActionButton**: Botão flutuante
- **ConstraintLayout**: Layout flexível
- **LinearLayout**: Layout do header

## 📊 Saída Esperada

### **Interface do App:**
- **Toolbar**: Com hamburger menu e título
- **Menu Drawer**: Lateral com header e itens
- **Conteúdo**: Texto central que muda de cor
- **FAB**: Botão flutuante no canto inferior direito

### **Comportamento:**
- **Abertura do Menu**: Clique no hamburger ou swipe
- **Mudança de Cores**: Seleção de itens do menu
- **Atualização de Textos**: Títulos dinâmicos
- **Navegação Suave**: Animações fluidas

## 🎯 Objetivos de Aprendizado

Este template demonstra:
- ✅ **Navigation Drawer**: Implementação completa
- ✅ **Material Design**: Componentes modernos
- ✅ **Toolbar Integration**: Integração com ActionBar
- ✅ **Dynamic UI**: Mudanças programáticas
- ✅ **Layout Management**: Estruturas complexas
- ✅ **Event Handling**: Tratamento de cliques
- ✅ **Resource Management**: Organização de recursos

## 🌟 Vantagens do Template

### **✅ Pronto para Uso:**
- **Estrutura completa** implementada
- **Código testado** e funcional
- **Documentação** detalhada
- **Fácil customização**

### **✅ Boas Práticas:**
- **Material Design** guidelines
- **Performance** otimizada
- **Código limpo** e organizado
- **Separação de responsabilidades**

### **✅ Escalabilidade:**
- **Fácil adição** de novos itens
- **Suporte a fragments** para navegação
- **Temas customizáveis**
- **Ícones personalizáveis**

---

**Desenvolvido com ❤️ para o Curso de Desenvolvimento Android Java e Kotlin**  
**Professor Marco Maddo** 🎓 