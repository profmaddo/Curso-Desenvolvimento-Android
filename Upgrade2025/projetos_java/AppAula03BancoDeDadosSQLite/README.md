# 🗄️ Aula 03 - Banco de Dados SQLite no Android

## 📱 Projeto: AppAula03BancoDeDadosSQLite

> **Domine o SQLite e implemente CRUD completo com relacionamentos!** 🎯

---

## 🎯 **O que você vai aprender nesta aula?**

### ✨ **Habilidades Principais:**
- 🗄️ **SQLite Database**: Crie e gerencie bancos de dados locais
- 🔧 **SQLOpenHelper**: Implemente a arquitetura de banco de dados Android
- 📊 **CRUD Completo**: Create, Read, Update, Delete para todas as entidades
- 🔗 **Relacionamentos**: Domine foreign keys e JOINs
- 🧪 **Testes Unitários**: Valide todas as operações do banco
- 📈 **Dados Mockados**: Popule tabelas com dados de teste

---

## 🏗️ **Arquitetura do Projeto**

### **📁 Estrutura de Pacotes:**
```
foo.maddo.appaula03bancodedadossqlite/
├── 📁 model/           # Classes de entidade
│   ├── Endereco.java
│   ├── Fornecedor.java
│   └── Produto.java
├── 📁 database/        # Gerenciamento do banco
│   └── DatabaseHelper.java
├── 📁 dao/            # Data Access Objects
│   ├── EnderecoDAO.java
│   ├── FornecedorDAO.java
│   └── ProdutoDAO.java
├── 📁 data/           # Dados mockados
│   └── MockData.java
├── 📁 test/           # Testes unitários
│   └── CRUDTest.java
└── MainActivity.java
```

---

## 🗂️ **Modelo de Dados**

### **📍 Entidade: Endereco**
```java
public class Endereco {
    private long id;
    private String endereco;
    private String cidade;
    private String estado;
}
```

### **🏢 Entidade: Fornecedor**
```java
public class Fornecedor {
    private long id;
    private String nome;
    private String contato;
    private long enderecoId; // Foreign Key para Endereco
}
```

### **📦 Entidade: Produto**
```java
public class Produto {
    private long id;
    private String descricao;
    private String unidade;
    private double quantidade;
    private double valor;
    private boolean estoque;
    private long fornecedorId; // Foreign Key para Fornecedor
}
```

---

## 🔗 **Relacionamentos**

### **📊 Diagrama de Relacionamentos:**
```
Endereco (1) ←→ (N) Fornecedor
Fornecedor (1) ←→ (N) Produto
```

- **Endereco → Fornecedor**: Um endereço pode ter vários fornecedores
- **Fornecedor → Produto**: Um fornecedor pode ter vários produtos
- **Produto → Fornecedor**: Um produto pertence a um fornecedor

---

## 🗄️ **Estrutura do Banco de Dados**

### **📋 Tabelas Criadas:**

#### **Tabela: endereco**
```sql
CREATE TABLE endereco (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    endereco TEXT NOT NULL,
    cidade TEXT NOT NULL,
    estado TEXT NOT NULL
);
```

#### **Tabela: fornecedor**
```sql
CREATE TABLE fornecedor (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nome TEXT NOT NULL,
    contato TEXT NOT NULL,
    endereco_id INTEGER,
    FOREIGN KEY(endereco_id) REFERENCES endereco(id)
);
```

#### **Tabela: produto**
```sql
CREATE TABLE produto (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    descricao TEXT NOT NULL,
    unidade TEXT NOT NULL,
    quantidade REAL NOT NULL,
    valor REAL NOT NULL,
    estoque INTEGER NOT NULL,
    fornecedor_id INTEGER,
    FOREIGN KEY(fornecedor_id) REFERENCES fornecedor(id)
);
```

#### **Tabela: produto_fornecedor** (Relacionamento N:N)
```sql
CREATE TABLE produto_fornecedor (
    produto_id INTEGER,
    fornecedor_id INTEGER,
    PRIMARY KEY(produto_id, fornecedor_id),
    FOREIGN KEY(produto_id) REFERENCES produto(id),
    FOREIGN KEY(fornecedor_id) REFERENCES fornecedor(id)
);
```

---

## 🧪 **Operações CRUD Implementadas**

### **📍 EnderecoDAO**
- ✅ **CREATE**: `insert(Endereco endereco)`
- ✅ **READ**: `getById(long id)`, `getAll()`, `getByCidade(String cidade)`
- ✅ **UPDATE**: `update(Endereco endereco)`
- ✅ **DELETE**: `delete(long id)`, `deleteAll()`
- ✅ **COUNT**: `getCount()`

### **🏢 FornecedorDAO**
- ✅ **CREATE**: `insert(Fornecedor fornecedor)`
- ✅ **READ**: `getById(long id)`, `getAll()`, `getByNome(String nome)`, `getByEnderecoId(long enderecoId)`
- ✅ **UPDATE**: `update(Fornecedor fornecedor)`
- ✅ **DELETE**: `delete(long id)`, `deleteAll()`
- ✅ **COUNT**: `getCount()`
- ✅ **JOIN**: `getAllWithEndereco()`

### **📦 ProdutoDAO**
- ✅ **CREATE**: `insert(Produto produto)`
- ✅ **READ**: `getById(long id)`, `getAll()`, `getByDescricao(String descricao)`, `getByFornecedorId(long fornecedorId)`
- ✅ **UPDATE**: `update(Produto produto)`
- ✅ **DELETE**: `delete(long id)`, `deleteAll()`
- ✅ **COUNT**: `getCount()`
- ✅ **FILTERS**: `getEmEstoque()`, `getByFaixaPreco(double min, double max)`
- ✅ **JOIN**: `getAllWithFornecedor()`

---

## 🎮 **Interface do App**

### **📱 Botões Disponíveis:**

#### **📊 Dados Mockados:**
- 🔄 **Popular Dados Mockados** - Insere dados de teste
- 🗑️ **Limpar Todos os Dados** - Remove todos os registros
- 📈 **Exibir Estatísticas** - Mostra contadores

#### **🧪 Testes CRUD:**
- 📍 **Testar CRUD Completo - Endereço**
- 🏢 **Testar CRUD Completo - Fornecedor**
- 📦 **Testar CRUD Completo - Produto**
- 🔗 **Testar Relacionamentos**

---

## 📊 **Dados Mockados Incluídos**

### **📍 Endereços (10 registros):**
- Rua das Flores, 123 - São Paulo, SP
- Av. Paulista, 1000 - São Paulo, SP
- Rua Augusta, 500 - São Paulo, SP
- E mais 7 endereços...

### **🏢 Fornecedores (10 registros):**
- Tech Solutions Ltda - (11) 99999-1111
- Digital Innovations - (11) 99999-2222
- Smart Systems - (11) 99999-3333
- E mais 7 fornecedores...

### **📦 Produtos (20 registros):**
- Notebook Dell Inspiron - R$ 3.500,00
- Mouse Wireless Logitech - R$ 89,90
- Teclado Mecânico RGB - R$ 299,90
- E mais 17 produtos...

---

## 🧪 **Testes Implementados**

### **📋 Testes Automatizados:**
- ✅ **CREATE**: Inserção de novos registros
- ✅ **READ**: Busca por ID, listagem completa, filtros
- ✅ **UPDATE**: Atualização de registros existentes
- ✅ **DELETE**: Remoção de registros
- ✅ **RELACIONAMENTOS**: Testes de foreign keys
- ✅ **ESTATÍSTICAS**: Contadores e métricas

### **📱 Resultados dos Testes:**
- **LogCat**: Todos os resultados são exibidos no LogCat
- **TOAST**: Notificações na tela indicando qual teste está rodando
- **TAGS**: Filtros organizados por CRUDTest, EnderecoDAO, FornecedorDAO, ProdutoDAO, MockData

---

## 🎯 **Objetivos de Aprendizado:**

### **Ao final desta aula, você será capaz de:**

1. 🗄️ **Criar bancos SQLite** com SQLOpenHelper
2. 🔧 **Implementar DAOs** para todas as entidades
3. 📊 **Executar operações CRUD** completas
4. 🔗 **Gerenciar relacionamentos** entre tabelas
5. 🧪 **Criar testes unitários** para validação
6. 📈 **Popular dados** com informações mockadas
7. 📱 **Interface responsiva** para testes
8. 🔍 **Debug eficiente** com LogCat

---

## 🚀 **Por que esta aula é importante?**

### **Para sua carreira:**
- 🗄️ **SQLite é fundamental** - Banco local em 90% dos apps Android
- 🔧 **CRUD é essencial** - Base para qualquer aplicação
- 🧪 **Testes garantem qualidade** - Evitam bugs em produção
- 📊 **Relacionamentos são complexos** - Habilidade valorizada

### **Para projetos reais:**
- 📱 **Apps offline** - Dados locais sem internet
- 💾 **Cache de dados** - Performance e economia
- 🔄 **Sincronização** - Dados locais + servidor
- 📈 **Analytics local** - Métricas do usuário

---

## 🎓 **Pré-requisitos:**
- ✅ Conhecimento básico de Java
- ✅ Familiaridade com Android Studio
- ✅ Entendimento de classes e objetos (Aula 01)
- ✅ Conhecimento de métodos (Aula 02)

---

## 🎉 **Resultado Final:**

Após esta aula, você terá criado um sistema completo que:
- 🗄️ Gerencia banco de dados SQLite
- 📊 Implementa CRUD para 3 entidades
- 🔗 Respeita relacionamentos entre tabelas
- 🧪 Inclui testes unitários completos
- 📈 Possui dados mockados realistas
- 📱 Interface para executar testes
- 🔍 Logs detalhados no LogCat

---

## 💡 **Dica do Professor:**

> *"SQLite é como uma biblioteca local: você organiza os livros (dados) em prateleiras (tabelas), com catálogos (índices) e referências cruzadas (foreign keys). Quanto melhor a organização, mais fácil encontrar o que precisa!"* 📚

---

## 🚀 **Próximos passos:**

Após dominar esta aula, você estará pronto para:
- 🌐 Integração com APIs REST
- 🔄 Sincronização de dados
- 📊 Relatórios complexos
- 🎮 Apps com dados persistentes
- 📱 Sistemas completos de gestão

---

## 🔍 **Como usar o app:**

1. **Execute o app** no Android Studio
2. **Clique em "Popular Dados Mockados"** para inserir dados de teste
3. **Execute os testes CRUD** para cada entidade
4. **Verifique o LogCat** para ver os resultados
5. **Filtre por tags** para organizar os logs

---

**🎯 Lembre-se: Cada tabela, cada relacionamento, cada teste é um passo em direção ao domínio completo de bancos de dados Android!**

---

*Desenvolvido com ❤️ para transformar você em um desenvolvedor Android profissional!* 