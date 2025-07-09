# 🏗️ Fundamentos da Programação Orientada a Objetos (POO)

## 📚 Projeto: AppAula03BancoDeDadosSQLite

> **Transforme-se em um arquiteto de software dominando os 4 pilares da POO!** 🎯

---

## 🎯 **O que é Programação Orientada a Objetos?**

Imagine que você está construindo uma casa 🏠. Em vez de misturar tudo (tijolos, cimento, telhas) em um monte confuso, você organiza cada parte:

- **Tijolos** → Classe `Endereco`
- **Portas** → Classe `Fornecedor` 
- **Janelas** → Classe `Produto`
- **Planta da casa** → Classe `DatabaseHelper`

A POO é exatamente isso: **organizar seu código em "blocos" chamados objetos**, cada um com sua responsabilidade específica!

---

## 🏛️ **Os 4 Pilares da POO**

### 1. 🔒 **ENCAPSULAMENTO** - Protegendo seus dados

> *"Encapsulamento é como colocar seus dados em uma caixa forte com senha"* 🔐

#### **Onde encontramos no projeto:**

```java
// Em Endereco.java
public class Endereco {
    private long id;           // 🔒 PRIVADO - só a própria classe pode acessar
    private String endereco;   // 🔒 PRIVADO
    private String cidade;     // 🔒 PRIVADO
    private String estado;     // 🔒 PRIVADO

    // 🔓 PÚBLICO - métodos para acessar os dados privados
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
```

#### **Por que usar Encapsulamento?**

| ❌ **SEM Encapsulamento** | ✅ **COM Encapsulamento** |
|---------------------------|---------------------------|
| `endereco.id = -5;` | `endereco.setId(-5);` |
| `endereco.cidade = "";` | `endereco.setCidade("São Paulo");` |
| **Problema:** Dados podem ser corrompidos | **Vantagem:** Validação e controle |

#### **Vantagens do Encapsulamento:**
- 🛡️ **Proteção de dados** - Ninguém pode modificar diretamente
- 🔧 **Validação** - Você pode verificar se os dados são válidos
- 🔄 **Flexibilidade** - Pode mudar a implementação sem afetar outros códigos
- 🧪 **Testabilidade** - Mais fácil de testar

---

### 2. 🧬 **HERANÇA** - Reutilizando código

> *"Herança é como herdar características dos seus pais"* 👨‍👩‍👧‍👦

#### **Onde encontramos no projeto:**

```java
// DatabaseHelper HERDA de SQLiteOpenHelper
public class DatabaseHelper extends SQLiteOpenHelper {
    // 🧬 Herda todos os métodos de SQLiteOpenHelper
    // 🧬 Pode usar: getWritableDatabase(), close(), etc.
    
    @Override  // 🔄 Sobrescreve métodos da classe pai
    public void onCreate(SQLiteDatabase db) {
        // Sua implementação específica
    }
    
    @Override  // 🔄 Sobrescreve métodos da classe pai
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Sua implementação específica
    }
}
```

#### **Hierarquia de Herança:**

```
📱 SQLiteOpenHelper (Classe Pai)
    ↓ extends
🏗️ DatabaseHelper (Classe Filha)
    ↓ usa
📊 EnderecoDAO, FornecedorDAO, ProdutoDAO
```

#### **Vantagens da Herança:**
- ♻️ **Reutilização de código** - Não precisa reescrever métodos
- 🎯 **Especialização** - Cada filho pode ter comportamentos específicos
- 🏗️ **Organização** - Código mais organizado e hierárquico
- 🔧 **Manutenção** - Mudanças na classe pai afetam todos os filhos

---

### 3. 🎭 **POLIMORFISMO** - Múltiplas formas

> *"Polimorfismo é como um ator que pode interpretar vários personagens"* 🎬

#### **Onde encontramos no projeto:**

```java
// 🎭 Mesmo método, comportamentos diferentes
public class EnderecoDAO {
    public long insert(Endereco endereco) {
        // Insere endereço no banco
    }
}

public class FornecedorDAO {
    public long insert(Fornecedor fornecedor) {
        // Insere fornecedor no banco (comportamento diferente)
    }
}

public class ProdutoDAO {
    public long insert(Produto produto) {
        // Insere produto no banco (comportamento diferente)
    }
}
```

#### **Polimorfismo de Sobrescrita (Override):**

```java
// 🎭 Mesmo método toString(), resultados diferentes
@Override
public String toString() {
    return "Endereco{" + "id=" + id + ", endereco='" + endereco + '\'' + '}';
}

@Override
public String toString() {
    return "Fornecedor{" + "id=" + id + ", nome='" + nome + '\'' + '}';
}

@Override
public String toString() {
    return "Produto{" + "id=" + id + ", descricao='" + descricao + '\'' + '}';
}
```

#### **Vantagens do Polimorfismo:**
- 🎯 **Flexibilidade** - Mesmo método, comportamentos diferentes
- 🔧 **Extensibilidade** - Fácil adicionar novos tipos
- 🧪 **Testabilidade** - Pode testar diferentes implementações
- 🎨 **Interface consistente** - Mesma forma de usar, resultados diferentes

---

### 4. 🎨 **ABSTRAÇÃO** - Simplificando a complexidade

> *"Abstração é como usar um carro sem saber como funciona o motor"* 🚗

#### **Onde encontramos no projeto:**

```java
// 🎨 Classe abstrata que esconde a complexidade do banco
public class EnderecoDAO {
    private DatabaseHelper dbHelper;  // 🎨 Esconde a complexidade do SQLite
    
    // 🎨 Métodos simples que escondem SQL complexo
    public long insert(Endereco endereco) {
        // Internamente executa: INSERT INTO endereco VALUES (...)
        // Mas você só precisa chamar: enderecoDAO.insert(endereco)
    }
    
    public Endereco getById(long id) {
        // Internamente executa: SELECT * FROM endereco WHERE id = ?
        // Mas você só precisa chamar: enderecoDAO.getById(1)
    }
}
```

#### **Abstração em Camadas:**

```
🎨 Interface do Usuário (MainActivity)
    ↓ usa
🎨 Camada de Teste (CRUDTest)
    ↓ usa  
🎨 Camada de Acesso (DAO)
    ↓ usa
🎨 Camada de Banco (DatabaseHelper)
    ↓ usa
🎨 SQLite (Sistema Android)
```

#### **Vantagens da Abstração:**
- 🧠 **Simplicidade** - Esconde complexidade desnecessária
- 🔧 **Manutenção** - Mudanças internas não afetam o usuário
- 🎯 **Foco** - Cada camada tem uma responsabilidade específica
- 🧪 **Testabilidade** - Pode testar cada camada independentemente

---

## 🏗️ **Arquitetura POO no Projeto**

### **Estrutura de Pacotes (Organização POO):**

```
📦 foo.maddo.appaula03bancodedadossqlite
├── 🏗️ model/          # Classes de dados (Encapsulamento)
│   ├── Endereco.java
│   ├── Fornecedor.java
│   └── Produto.java
├── 🗄️ database/       # Gerenciamento de banco (Herança)
│   └── DatabaseHelper.java
├── 🔧 dao/            # Acesso a dados (Abstração)
│   ├── EnderecoDAO.java
│   ├── FornecedorDAO.java
│   └── ProdutoDAO.java
├── 🧪 test/           # Testes (Polimorfismo)
│   ├── CRUDTest.java
│   └── JUnitTestRunner.java
└── 📊 data/           # Dados mockados
    └── MockData.java
```

---

## 🎯 **Padrões de Design POO Aplicados**

### 1. **Padrão DAO (Data Access Object)**

```java
// 🎯 Cada DAO segue o mesmo padrão
public class EnderecoDAO {
    // CREATE
    public long insert(Endereco endereco) { ... }
    
    // READ
    public Endereco getById(long id) { ... }
    public List<Endereco> getAll() { ... }
    
    // UPDATE
    public int update(Endereco endereco) { ... }
    
    // DELETE
    public int delete(long id) { ... }
}
```

**Vantagens:**
- 🎯 **Consistência** - Todos os DAOs seguem o mesmo padrão
- 🔧 **Manutenção** - Fácil de manter e modificar
- 🧪 **Testabilidade** - Pode testar cada operação separadamente

### 2. **Padrão Singleton (no DatabaseHelper)**

```java
// 🎯 Uma única instância do banco
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "AppAula03DB";
    // 🎯 Constantes compartilhadas por toda a aplicação
}
```

### 3. **Padrão Factory (no MockData)**

```java
// 🎯 Fábrica de objetos de teste
public class MockData {
    public static Endereco criarEnderecoMock() { ... }
    public static Fornecedor criarFornecedorMock() { ... }
    public static Produto criarProdutoMock() { ... }
}
```

---

## 🧪 **POO nos Testes**

### **Organização POO nos Testes:**

```java
// 🧪 Classe de teste organizada por responsabilidades
public class CRUDTest {
    // 🔒 Encapsulamento - dados privados
    private Context context;
    private EnderecoDAO enderecoDAO;
    
    // 🎭 Polimorfismo - mesmo método, testes diferentes
    public void testarCRUDEndereco() { ... }
    public void testarCRUDFornecedor() { ... }
    public void testarCRUDProduto() { ... }
    
    // 🎨 Abstração - métodos privados escondem complexidade
    private void testarCreateEndereco() { ... }
    private void testarReadEndereco() { ... }
}
```

---

## 🎓 **Boas Práticas POO Aplicadas**

### 1. **Responsabilidade Única (SRP)**
```java
// ✅ Cada classe tem uma responsabilidade
EnderecoDAO → Gerencia endereços no banco
FornecedorDAO → Gerencia fornecedores no banco
ProdutoDAO → Gerencia produtos no banco
```

### 2. **Baixo Acoplamento**
```java
// ✅ Classes não dependem diretamente umas das outras
EnderecoDAO usa DatabaseHelper (baixo acoplamento)
FornecedorDAO usa DatabaseHelper (baixo acoplamento)
// ❌ Não: EnderecoDAO usa FornecedorDAO diretamente
```

### 3. **Alta Coesão**
```java
// ✅ Cada classe tem métodos relacionados
EnderecoDAO: insert(), getById(), getAll(), update(), delete()
// Todos relacionados a gerenciar endereços
```

### 4. **Nomenclatura Clara**
```java
// ✅ Nomes que explicam o que fazem
public long insert(Endereco endereco)  // Claro: insere um endereço
public Endereco getById(long id)       // Claro: busca por ID
public int delete(long id)             // Claro: deleta por ID
```

---

## 🚀 **Vantagens da POO no Projeto**

### **Para o Desenvolvedor:**
- 🧠 **Organização mental** - Código mais fácil de entender
- 🔧 **Manutenção** - Mudanças localizadas
- 🧪 **Testes** - Cada classe pode ser testada independentemente
- 🔄 **Reutilização** - Código pode ser usado em outros projetos

### **Para o Projeto:**
- 📈 **Escalabilidade** - Fácil adicionar novas funcionalidades
- 🛡️ **Robustez** - Menos bugs, mais confiável
- 🎯 **Clareza** - Código auto-documentado
- 🔧 **Flexibilidade** - Fácil de modificar e estender

---

## 🎯 **Exercícios Práticos de POO**

### **1. Exercício de Encapsulamento:**
```java
// Adicione validação no setter
public void setIdade(int idade) {
    if (idade >= 0 && idade <= 150) {
        this.idade = idade;
    } else {
        throw new IllegalArgumentException("Idade inválida!");
    }
}
```

### **2. Exercício de Herança:**
```java
// Crie uma classe base para todos os DAOs
public abstract class BaseDAO<T> {
    protected DatabaseHelper dbHelper;
    
    public abstract long insert(T obj);
    public abstract T getById(long id);
    public abstract List<T> getAll();
    public abstract int update(T obj);
    public abstract int delete(long id);
}
```

### **3. Exercício de Polimorfismo:**
```java
// Use uma interface comum
public interface CRUDOperations<T> {
    long insert(T obj);
    T getById(long id);
    List<T> getAll();
    int update(T obj);
    int delete(long id);
}
```

### **4. Exercício de Abstração:**
```java
// Crie uma fachada que simplifica o uso
public class DatabaseManager {
    private EnderecoDAO enderecoDAO;
    private FornecedorDAO fornecedorDAO;
    private ProdutoDAO produtoDAO;
    
    public void salvarEnderecoCompleto(Endereco endereco, Fornecedor fornecedor) {
        // Esconde a complexidade de salvar endereço + fornecedor
    }
}
```

---

## 🎉 **Conclusão**

### **O que você aprendeu:**

1. 🔒 **Encapsulamento** - Protege dados com getters/setters
2. 🧬 **Herança** - Reutiliza código com `extends`
3. 🎭 **Polimorfismo** - Mesmo método, comportamentos diferentes
4. 🎨 **Abstração** - Esconde complexidade desnecessária

### **Por que isso é importante:**

- 🎯 **Profissionalismo** - Código de qualidade empresarial
- 🚀 **Carreira** - Habilidades essenciais para qualquer desenvolvedor
- 🏗️ **Projetos reais** - Aplicado em 99% dos projetos Android
- 🧠 **Pensamento estruturado** - Organiza sua mente de programador

---

## 💡 **Dica do Professor:**

> *"POO é como construir com LEGO: cada peça (classe) tem sua função específica, mas todas se encaixam perfeitamente para formar algo incrível!"* 🧱

---

## 🚀 **Próximos passos:**

Após dominar os fundamentos da POO, você estará pronto para:
- 🎨 **Design Patterns** - Padrões avançados de POO
- 🏗️ **Arquitetura Android** - MVVM, MVP, Clean Architecture
- 🔧 **Frameworks** - Room, Retrofit, Dagger
- 🚀 **Projetos complexos** - Apps empresariais

---

**🎯 Lembre-se: POO não é apenas uma técnica, é uma forma de pensar e organizar o mundo da programação!**

---

*Desenvolvido com ❤️ para transformar você em um arquiteto de software!* 🏗️ 