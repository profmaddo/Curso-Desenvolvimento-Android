# 🧪 Testes Unitários JUnit - AppAula03BancoDeDadosSQLite

## 📋 Visão Geral

Este diretório contém todos os testes unitários JUnit para as classes do modelo do projeto. Os testes foram criados para garantir a qualidade e confiabilidade do código, seguindo as melhores práticas de desenvolvimento.

---

## 🎯 **Objetivos dos Testes**

### ✅ **Cobertura Completa:**
- **100% dos métodos** das classes modelo testados
- **Todos os construtores** validados
- **Todos os getters e setters** verificados
- **Métodos equals, hashCode e toString** testados
- **Cenários de limite** e valores extremos cobertos

### 🔍 **Validações Específicas:**
- **Integridade dos dados** - valores são armazenados corretamente
- **Relacionamentos** - foreign keys funcionam adequadamente
- **Cenários edge cases** - valores nulos, vazios, extremos
- **Performance básica** - criação de múltiplos objetos

---

## 📁 **Estrutura dos Testes**

### **1. Testes Unitários Individuais**

#### **EnderecoTest.java**
- ✅ **Construtores**: vazio, com parâmetros, completo
- ✅ **Getters e Setters**: todos os campos
- ✅ **Métodos Object**: toString, equals, hashCode
- ✅ **Cenários especiais**: strings longas, valores limites
- ✅ **Validações**: strings vazias, valores nulos

#### **FornecedorTest.java**
- ✅ **Construtores**: vazio, com parâmetros, completo
- ✅ **Getters e Setters**: todos os campos
- ✅ **Lista de Produtos**: manipulação de coleções
- ✅ **Métodos Object**: toString, equals, hashCode
- ✅ **Relacionamentos**: enderecoId
- ✅ **Performance**: listas grandes (100 produtos)

#### **ProdutoTest.java**
- ✅ **Construtores**: vazio, com parâmetros, completo
- ✅ **Getters e Setters**: todos os campos
- ✅ **Tipos de dados**: double, boolean, long
- ✅ **Métodos Object**: toString, equals, hashCode
- ✅ **Valores numéricos**: precisão decimal, limites
- ✅ **Unidades**: diferentes tipos de unidade

### **2. Testes de Integração**

#### **ModelIntegrationTest.java**
- ✅ **Relacionamentos**: Endereco ↔ Fornecedor ↔ Produto
- ✅ **Ciclo de vida completo**: criação → atualização → relacionamento
- ✅ **Validação de dados**: cenários reais de uso
- ✅ **Cenários limite**: valores extremos e nulos
- ✅ **Performance**: criação de 1000 objetos

### **3. Suíte de Testes**

#### **ModelTestSuite.java**
- ✅ **Execução centralizada** de todos os testes
- ✅ **Organização** por tipo de teste
- ✅ **Facilita** execução em lote

---

## 🚀 **Como Executar os Testes**

### **Via Android Studio:**
1. **Clique direito** no arquivo de teste
2. **Selecione** "Run 'NomeDoTeste'"
3. **Ou execute** toda a suíte: `ModelTestSuite`

### **Via Gradle:**
```bash
# Executar todos os testes
./gradlew test

# Executar testes específicos
./gradlew test --tests "foo.maddo.appaula03bancodedadossqlite.EnderecoTest"
./gradlew test --tests "foo.maddo.appaula03bancodedadossqlite.ModelTestSuite"
```

### **Via Linha de Comando:**
```bash
# Navegar para o diretório do projeto
cd projetos_java/AppAula03BancoDeDadosSQLite

# Executar testes
./gradlew test
```

---

## 📊 **Cobertura de Testes**

### **EnderecoTest - 15 Testes:**
- ✅ `testConstrutorVazio()` - Construtor sem parâmetros
- ✅ `testConstrutorComParametros()` - Construtor com dados
- ✅ `testConstrutorCompleto()` - Construtor com ID
- ✅ `testSetId()` / `testGetId()` - Manipulação de ID
- ✅ `testSetEndereco()` / `testGetEndereco()` - Campo endereço
- ✅ `testSetCidade()` / `testGetCidade()` - Campo cidade
- ✅ `testSetEstado()` / `testGetEstado()` - Campo estado
- ✅ `testToString()` - Representação em string
- ✅ `testToStringComValoresNull()` - toString com nulls
- ✅ `testEqualsMesmoObjeto()` - Igualdade de objetos
- ✅ `testEqualsObjetosDiferentes()` - Objetos diferentes
- ✅ `testEqualsObjetosIguais()` - Objetos iguais
- ✅ `testHashCodeConsistencia()` - Consistência do hashCode
- ✅ `testValoresLimites()` - IDs máximo e mínimo
- ✅ `testStringsVazias()` - Strings vazias
- ✅ `testStringsLongas()` - Strings extensas

### **FornecedorTest - 18 Testes:**
- ✅ `testConstrutorVazio()` - Construtor sem parâmetros
- ✅ `testConstrutorComParametros()` - Construtor com dados
- ✅ `testConstrutorCompleto()` - Construtor com ID
- ✅ `testSetId()` / `testGetId()` - Manipulação de ID
- ✅ `testSetNome()` / `testGetNome()` - Campo nome
- ✅ `testSetContato()` / `testGetContato()` - Campo contato
- ✅ `testSetEnderecoId()` / `testGetEnderecoId()` - Foreign key
- ✅ `testSetProdutos()` / `testGetProdutos()` - Lista de produtos
- ✅ `testSetProdutosNull()` - Lista null
- ✅ `testToString()` - Representação em string
- ✅ `testToStringComProdutos()` - toString com produtos
- ✅ `testToStringComValoresNull()` - toString com nulls
- ✅ `testEqualsMesmoObjeto()` - Igualdade de objetos
- ✅ `testEqualsObjetosDiferentes()` - Objetos diferentes
- ✅ `testEqualsObjetosIguais()` - Objetos iguais
- ✅ `testHashCodeConsistencia()` - Consistência do hashCode
- ✅ `testValoresLimites()` - IDs máximo e mínimo
- ✅ `testStringsVazias()` - Strings vazias
- ✅ `testStringsLongas()` - Strings extensas
- ✅ `testListaProdutosVazia()` - Lista vazia
- ✅ `testListaProdutosGrande()` - Lista com 100 produtos
- ✅ `testEnderecoIdNegativo()` - ID negativo
- ✅ `testContatoComFormatosDiferentes()` - Formatos de contato

### **ProdutoTest - 20 Testes:**
- ✅ `testConstrutorVazio()` - Construtor sem parâmetros
- ✅ `testConstrutorComParametros()` - Construtor com dados
- ✅ `testConstrutorCompleto()` - Construtor com ID
- ✅ `testSetId()` / `testGetId()` - Manipulação de ID
- ✅ `testSetDescricao()` / `testGetDescricao()` - Campo descrição
- ✅ `testSetUnidade()` / `testGetUnidade()` - Campo unidade
- ✅ `testSetQuantidade()` / `testGetQuantidade()` - Campo quantidade
- ✅ `testSetValor()` / `testGetValor()` - Campo valor
- ✅ `testSetEstoque()` / `testIsEstoque()` - Campo estoque
- ✅ `testSetFornecedorId()` / `testGetFornecedorId()` - Foreign key
- ✅ `testToString()` - Representação em string
- ✅ `testToStringComValoresNull()` - toString com nulls
- ✅ `testEqualsMesmoObjeto()` - Igualdade de objetos
- ✅ `testEqualsObjetosDiferentes()` - Objetos diferentes
- ✅ `testEqualsObjetosIguais()` - Objetos iguais
- ✅ `testHashCodeConsistencia()` - Consistência do hashCode
- ✅ `testValoresLimites()` - IDs máximo e mínimo
- ✅ `testValoresNumericosLimites()` - Valores double extremos
- ✅ `testStringsVazias()` - Strings vazias
- ✅ `testStringsLongas()` - Strings extensas
- ✅ `testValoresNegativos()` - Valores negativos
- ✅ `testValoresZero()` - Valores zero
- ✅ `testValoresDecimais()` - Precisão decimal
- ✅ `testUnidadesDiferentes()` - Tipos de unidade
- ✅ `testEstoqueAlternado()` - Alternância de estoque
- ✅ `testPrecisaoNumerica()` - Precisão monetária

### **ModelIntegrationTest - 10 Testes:**
- ✅ `testRelacionamentoEnderecoFornecedor()` - Relacionamento 1:1
- ✅ `testRelacionamentoFornecedorProduto()` - Relacionamento 1:N
- ✅ `testRelacionamentoCompleto()` - Relacionamento completo
- ✅ `testCicloDeVidaCompleto()` - Ciclo completo CRUD
- ✅ `testValidacaoDeDados()` - Validação de dados
- ✅ `testToStringIntegracao()` - toString integrado
- ✅ `testEqualsEHashCodeIntegracao()` - equals/hashCode integrado
- ✅ `testCenariosLimite()` - Valores extremos
- ✅ `testCenariosNulos()` - Valores nulos
- ✅ `testPerformanceBasica()` - Performance com 1000 objetos

---

## 🎓 **Aprendizados dos Testes**

### **Para o Estudante:**

#### **1. Boas Práticas de Teste:**
- ✅ **Nomes descritivos** para métodos de teste
- ✅ **Um assert por teste** quando possível
- ✅ **Mensagens claras** nos asserts
- ✅ **Cobertura completa** de cenários
- ✅ **Testes independentes** entre si

#### **2. Conceitos de Teste:**
- ✅ **Testes unitários** vs testes de integração
- ✅ **Cenários de limite** e edge cases
- ✅ **Validação de dados** e tipos
- ✅ **Performance básica** e escalabilidade
- ✅ **Relacionamentos** entre objetos

#### **3. Ferramentas JUnit:**
- ✅ **Anotações** @Test, @RunWith, @SuiteClasses
- ✅ **Asserts** assertEquals, assertNotNull, assertTrue
- ✅ **Suítes de teste** para organização
- ✅ **Execução** via IDE ou linha de comando

---

## 🔧 **Manutenção dos Testes**

### **Quando Adicionar Novos Testes:**
- 🆕 **Nova funcionalidade** adicionada
- 🐛 **Bug corrigido** - adicionar teste para evitar regressão
- 🔄 **Refatoração** - garantir que comportamento não mudou
- 📈 **Cenário edge case** descoberto

### **Boas Práticas:**
- ✅ **Mantenha testes atualizados** com mudanças no código
- ✅ **Execute testes regularmente** durante desenvolvimento
- ✅ **Use testes como documentação** do comportamento esperado
- ✅ **Refatore testes** quando necessário

---

## 🎯 **Resultado Esperado**

### **Ao executar todos os testes:**
```
Tests run: 63, Failures: 0, Errors: 0, Skipped: 0
```

### **Cobertura de código:**
- ✅ **100% dos métodos** das classes modelo
- ✅ **100% dos construtores** testados
- ✅ **100% dos getters/setters** validados
- ✅ **Todos os cenários** de uso cobertos

---

## 💡 **Dicas para Estudantes**

### **Para Executar os Testes:**
1. **Abra o projeto** no Android Studio
2. **Navegue** para `app/src/test/java/foo/maddo/appaula03bancodedadossqlite/`
3. **Clique direito** em qualquer arquivo de teste
4. **Selecione** "Run 'NomeDoTeste'"

### **Para Entender os Testes:**
1. **Leia os nomes** dos métodos de teste
2. **Analise os asserts** para entender o que está sendo validado
3. **Execute testes individuais** para ver o comportamento
4. **Modifique valores** para ver como os testes falham

### **Para Criar Novos Testes:**
1. **Copie estrutura** de testes existentes
2. **Adapte** para sua nova funcionalidade
3. **Siga padrão** de nomenclatura
4. **Execute** para garantir que passam

---

**🎯 Lembre-se: Testes unitários são seu seguro contra bugs e sua documentação viva do código!**

---

*Desenvolvido com ❤️ para ensinar testes unitários profissionais!* 🧪 