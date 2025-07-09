package foo.maddo.appaula03bancodedadossqlite.test;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import foo.maddo.appaula03bancodedadossqlite.dao.EnderecoDAO;
import foo.maddo.appaula03bancodedadossqlite.dao.FornecedorDAO;
import foo.maddo.appaula03bancodedadossqlite.dao.ProdutoDAO;
import foo.maddo.appaula03bancodedadossqlite.data.MockData;
import foo.maddo.appaula03bancodedadossqlite.model.Endereco;
import foo.maddo.appaula03bancodedadossqlite.model.Fornecedor;
import foo.maddo.appaula03bancodedadossqlite.model.Produto;

public class CRUDTest {
    private Context context;
    private EnderecoDAO enderecoDAO;
    private FornecedorDAO fornecedorDAO;
    private ProdutoDAO produtoDAO;

    public CRUDTest(Context context) {
        this.context = context;
        this.enderecoDAO = new EnderecoDAO(context);
        this.fornecedorDAO = new FornecedorDAO(context);
        this.produtoDAO = new ProdutoDAO(context);
    }

    public void abrirConexao() {
        enderecoDAO.open();
        fornecedorDAO.open();
        produtoDAO.open();
    }

    public void fecharConexao() {
        enderecoDAO.close();
        fornecedorDAO.close();
        produtoDAO.close();
    }

    // ========== TESTES PARA ENDEREÇO ==========

    public void testarCRUDEndereco() {
        Log.i("CRUDTest", "=== INICIANDO TESTES CRUD ENDEREÇO ===");
        Toast.makeText(context, "Testando CRUD - Endereço", Toast.LENGTH_SHORT).show();

        // CREATE
        testarCreateEndereco();
        
        // READ
        testarReadEndereco();
        
        // UPDATE
        testarUpdateEndereco();
        
        // DELETE
        testarDeleteEndereco();
        
        Log.i("CRUDTest", "=== TESTES CRUD ENDEREÇO CONCLUÍDOS ===");
    }

    private void testarCreateEndereco() {
        Log.d("CRUDTest", "--- Testando CREATE Endereço ---");
        
        Endereco endereco = new Endereco("Rua Teste, 123", "São Paulo", "SP");
        long id = enderecoDAO.insert(endereco);
        
        if (id > 0) {
            Log.i("CRUDTest", "✅ CREATE Endereço: SUCESSO - ID: " + id);
        } else {
            Log.e("CRUDTest", "❌ CREATE Endereço: FALHOU");
        }
    }

    private void testarReadEndereco() {
        Log.d("CRUDTest", "--- Testando READ Endereço ---");
        
        // Buscar por ID
        Endereco endereco = enderecoDAO.getById(1);
        if (endereco != null) {
            Log.i("CRUDTest", "✅ READ Endereço por ID: SUCESSO - " + endereco);
        } else {
            Log.w("CRUDTest", "⚠️ READ Endereço por ID: NÃO ENCONTRADO");
        }
        
        // Listar todos
        List<Endereco> enderecos = enderecoDAO.getAll();
        Log.i("CRUDTest", "✅ READ Endereço - Lista: " + enderecos.size() + " registros");
        
        // Buscar por cidade
        List<Endereco> enderecosSP = enderecoDAO.getByCidade("São Paulo");
        Log.i("CRUDTest", "✅ READ Endereço por cidade: " + enderecosSP.size() + " registros");
    }

    private void testarUpdateEndereco() {
        Log.d("CRUDTest", "--- Testando UPDATE Endereço ---");
        
        Endereco endereco = enderecoDAO.getById(1);
        if (endereco != null) {
            endereco.setEndereco("Rua Atualizada, 456");
            endereco.setCidade("Rio de Janeiro");
            endereco.setEstado("RJ");
            
            int rowsAffected = enderecoDAO.update(endereco);
            if (rowsAffected > 0) {
                Log.i("CRUDTest", "✅ UPDATE Endereço: SUCESSO - " + rowsAffected + " linhas afetadas");
            } else {
                Log.e("CRUDTest", "❌ UPDATE Endereço: FALHOU");
            }
        } else {
            Log.w("CRUDTest", "⚠️ UPDATE Endereço: ENDEREÇO NÃO ENCONTRADO");
        }
    }

    private void testarDeleteEndereco() {
        Log.d("CRUDTest", "--- Testando DELETE Endereço ---");
        
        int countAntes = enderecoDAO.getCount();
        int rowsAffected = enderecoDAO.delete(1);
        int countDepois = enderecoDAO.getCount();
        
        if (rowsAffected > 0) {
            Log.i("CRUDTest", "✅ DELETE Endereço: SUCESSO - " + rowsAffected + " linhas afetadas");
            Log.i("CRUDTest", "📊 Contagem antes: " + countAntes + ", depois: " + countDepois);
        } else {
            Log.w("CRUDTest", "⚠️ DELETE Endereço: NENHUM REGISTRO DELETADO");
        }
    }

    // ========== TESTES PARA FORNECEDOR ==========

    public void testarCRUDFornecedor() {
        Log.i("CRUDTest", "=== INICIANDO TESTES CRUD FORNECEDOR ===");
        Toast.makeText(context, "Testando CRUD - Fornecedor", Toast.LENGTH_SHORT).show();

        // CREATE
        testarCreateFornecedor();
        
        // READ
        testarReadFornecedor();
        
        // UPDATE
        testarUpdateFornecedor();
        
        // DELETE
        testarDeleteFornecedor();
        
        Log.i("CRUDTest", "=== TESTES CRUD FORNECEDOR CONCLUÍDOS ===");
    }

    private void testarCreateFornecedor() {
        Log.d("CRUDTest", "--- Testando CREATE Fornecedor ---");
        
        // Primeiro criar um endereço
        Endereco endereco = new Endereco("Rua Fornecedor, 789", "São Paulo", "SP");
        long enderecoId = enderecoDAO.insert(endereco);
        
        Fornecedor fornecedor = new Fornecedor("Fornecedor Teste", "(11) 99999-9999", enderecoId);
        long id = fornecedorDAO.insert(fornecedor);
        
        if (id > 0) {
            Log.i("CRUDTest", "✅ CREATE Fornecedor: SUCESSO - ID: " + id);
        } else {
            Log.e("CRUDTest", "❌ CREATE Fornecedor: FALHOU");
        }
    }

    private void testarReadFornecedor() {
        Log.d("CRUDTest", "--- Testando READ Fornecedor ---");
        
        // Buscar por ID
        Fornecedor fornecedor = fornecedorDAO.getById(1);
        if (fornecedor != null) {
            Log.i("CRUDTest", "✅ READ Fornecedor por ID: SUCESSO - " + fornecedor);
        } else {
            Log.w("CRUDTest", "⚠️ READ Fornecedor por ID: NÃO ENCONTRADO");
        }
        
        // Listar todos
        List<Fornecedor> fornecedores = fornecedorDAO.getAll();
        Log.i("CRUDTest", "✅ READ Fornecedor - Lista: " + fornecedores.size() + " registros");
        
        // Buscar por nome
        List<Fornecedor> fornecedoresNome = fornecedorDAO.getByNome("Tech");
        Log.i("CRUDTest", "✅ READ Fornecedor por nome: " + fornecedoresNome.size() + " registros");
    }

    private void testarUpdateFornecedor() {
        Log.d("CRUDTest", "--- Testando UPDATE Fornecedor ---");
        
        Fornecedor fornecedor = fornecedorDAO.getById(1);
        if (fornecedor != null) {
            fornecedor.setNome("Fornecedor Atualizado");
            fornecedor.setContato("(11) 88888-8888");
            
            int rowsAffected = fornecedorDAO.update(fornecedor);
            if (rowsAffected > 0) {
                Log.i("CRUDTest", "✅ UPDATE Fornecedor: SUCESSO - " + rowsAffected + " linhas afetadas");
            } else {
                Log.e("CRUDTest", "❌ UPDATE Fornecedor: FALHOU");
            }
        } else {
            Log.w("CRUDTest", "⚠️ UPDATE Fornecedor: FORNECEDOR NÃO ENCONTRADO");
        }
    }

    private void testarDeleteFornecedor() {
        Log.d("CRUDTest", "--- Testando DELETE Fornecedor ---");
        
        int countAntes = fornecedorDAO.getCount();
        int rowsAffected = fornecedorDAO.delete(1);
        int countDepois = fornecedorDAO.getCount();
        
        if (rowsAffected > 0) {
            Log.i("CRUDTest", "✅ DELETE Fornecedor: SUCESSO - " + rowsAffected + " linhas afetadas");
            Log.i("CRUDTest", "📊 Contagem antes: " + countAntes + ", depois: " + countDepois);
        } else {
            Log.w("CRUDTest", "⚠️ DELETE Fornecedor: NENHUM REGISTRO DELETADO");
        }
    }

    // ========== TESTES PARA PRODUTO ==========

    public void testarCRUDProduto() {
        Log.i("CRUDTest", "=== INICIANDO TESTES CRUD PRODUTO ===");
        Toast.makeText(context, "Testando CRUD - Produto", Toast.LENGTH_SHORT).show();

        // CREATE
        testarCreateProduto();
        
        // READ
        testarReadProduto();
        
        // UPDATE
        testarUpdateProduto();
        
        // DELETE
        testarDeleteProduto();
        
        Log.i("CRUDTest", "=== TESTES CRUD PRODUTO CONCLUÍDOS ===");
    }

    private void testarCreateProduto() {
        Log.d("CRUDTest", "--- Testando CREATE Produto ---");
        
        // Primeiro criar um fornecedor
        Endereco endereco = new Endereco("Rua Produto, 456", "São Paulo", "SP");
        long enderecoId = enderecoDAO.insert(endereco);
        Fornecedor fornecedor = new Fornecedor("Fornecedor Produto", "(11) 77777-7777", enderecoId);
        long fornecedorId = fornecedorDAO.insert(fornecedor);
        
        Produto produto = new Produto("Produto Teste", "unidade", 10.0, 99.90, true, fornecedorId);
        long id = produtoDAO.insert(produto);
        
        if (id > 0) {
            Log.i("CRUDTest", "✅ CREATE Produto: SUCESSO - ID: " + id);
        } else {
            Log.e("CRUDTest", "❌ CREATE Produto: FALHOU");
        }
    }

    private void testarReadProduto() {
        Log.d("CRUDTest", "--- Testando READ Produto ---");
        
        // Buscar por ID
        Produto produto = produtoDAO.getById(1);
        if (produto != null) {
            Log.i("CRUDTest", "✅ READ Produto por ID: SUCESSO - " + produto);
        } else {
            Log.w("CRUDTest", "⚠️ READ Produto por ID: NÃO ENCONTRADO");
        }
        
        // Listar todos
        List<Produto> produtos = produtoDAO.getAll();
        Log.i("CRUDTest", "✅ READ Produto - Lista: " + produtos.size() + " registros");
        
        // Buscar por descrição
        List<Produto> produtosDesc = produtoDAO.getByDescricao("Notebook");
        Log.i("CRUDTest", "✅ READ Produto por descrição: " + produtosDesc.size() + " registros");
        
        // Buscar em estoque
        List<Produto> produtosEstoque = produtoDAO.getEmEstoque();
        Log.i("CRUDTest", "✅ READ Produto em estoque: " + produtosEstoque.size() + " registros");
        
        // Buscar por faixa de preço
        List<Produto> produtosPreco = produtoDAO.getByFaixaPreco(100.0, 500.0);
        Log.i("CRUDTest", "✅ READ Produto por faixa de preço: " + produtosPreco.size() + " registros");
    }

    private void testarUpdateProduto() {
        Log.d("CRUDTest", "--- Testando UPDATE Produto ---");
        
        Produto produto = produtoDAO.getById(1);
        if (produto != null) {
            produto.setDescricao("Produto Atualizado");
            produto.setValor(149.90);
            produto.setEstoque(false);
            
            int rowsAffected = produtoDAO.update(produto);
            if (rowsAffected > 0) {
                Log.i("CRUDTest", "✅ UPDATE Produto: SUCESSO - " + rowsAffected + " linhas afetadas");
            } else {
                Log.e("CRUDTest", "❌ UPDATE Produto: FALHOU");
            }
        } else {
            Log.w("CRUDTest", "⚠️ UPDATE Produto: PRODUTO NÃO ENCONTRADO");
        }
    }

    private void testarDeleteProduto() {
        Log.d("CRUDTest", "--- Testando DELETE Produto ---");
        
        int countAntes = produtoDAO.getCount();
        int rowsAffected = produtoDAO.delete(1);
        int countDepois = produtoDAO.getCount();
        
        if (rowsAffected > 0) {
            Log.i("CRUDTest", "✅ DELETE Produto: SUCESSO - " + rowsAffected + " linhas afetadas");
            Log.i("CRUDTest", "📊 Contagem antes: " + countAntes + ", depois: " + countDepois);
        } else {
            Log.w("CRUDTest", "⚠️ DELETE Produto: NENHUM REGISTRO DELETADO");
        }
    }

    // ========== TESTES ESPECIAIS ==========

    public void testarRelacionamentos() {
        Log.i("CRUDTest", "=== INICIANDO TESTES DE RELACIONAMENTOS ===");
        Toast.makeText(context, "Testando Relacionamentos", Toast.LENGTH_SHORT).show();

        // Testar produtos por fornecedor
        List<Produto> produtosFornecedor = produtoDAO.getByFornecedorId(1);
        Log.i("CRUDTest", "📊 Produtos do fornecedor ID 1: " + produtosFornecedor.size());

        // Testar fornecedores por endereço
        List<Fornecedor> fornecedoresEndereco = fornecedorDAO.getByEnderecoId(1);
        Log.i("CRUDTest", "📊 Fornecedores do endereço ID 1: " + fornecedoresEndereco.size());

        Log.i("CRUDTest", "=== TESTES DE RELACIONAMENTOS CONCLUÍDOS ===");
    }

    public void popularDadosMockados() {
        Log.i("CRUDTest", "=== POPULANDO DADOS MOCKADOS ===");
        Toast.makeText(context, "Populando dados mockados", Toast.LENGTH_SHORT).show();

        MockData.popularBancoDeDados(enderecoDAO, fornecedorDAO, produtoDAO);
        MockData.exibirEstatisticas(enderecoDAO, fornecedorDAO, produtoDAO);

        Log.i("CRUDTest", "=== DADOS MOCKADOS POPULADOS ===");
    }

    public void limparDados() {
        Log.i("CRUDTest", "=== LIMPANDO DADOS ===");
        Toast.makeText(context, "Limpando dados", Toast.LENGTH_SHORT).show();

        MockData.limparBancoDeDados(enderecoDAO, fornecedorDAO, produtoDAO);

        Log.i("CRUDTest", "=== DADOS LIMPOS ===");
    }

    public void exibirEstatisticas() {
        Log.i("CRUDTest", "=== EXIBINDO ESTATÍSTICAS ===");
        Toast.makeText(context, "Exibindo estatísticas", Toast.LENGTH_SHORT).show();

        MockData.exibirEstatisticas(enderecoDAO, fornecedorDAO, produtoDAO);

        Log.i("CRUDTest", "=== ESTATÍSTICAS EXIBIDAS ===");
    }
} 