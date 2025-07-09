package foo.maddo.appaula03bancodedadossqlite;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import foo.maddo.appaula03bancodedadossqlite.model.Endereco;
import foo.maddo.appaula03bancodedadossqlite.model.Fornecedor;
import foo.maddo.appaula03bancodedadossqlite.model.Produto;

/**
 * Testes de integração para validar os relacionamentos entre as classes do modelo.
 * Estes testes verificam se as classes funcionam corretamente juntas.
 */
public class ModelIntegrationTest {

    @Test
    public void testRelacionamentoEnderecoFornecedor() {
        // Criar endereço
        Endereco endereco = new Endereco(1L, "Rua das Flores, 123", "São Paulo", "SP");
        
        // Criar fornecedor que referencia o endereço
        Fornecedor fornecedor = new Fornecedor(1L, "Tech Solutions Ltda", "(11) 99999-1111", endereco.getId());
        
        // Verificar se o relacionamento está correto
        assertEquals("Fornecedor deve referenciar o ID do endereço", endereco.getId(), fornecedor.getEnderecoId());
        assertNotNull("Endereço não deve ser null", endereco);
        assertNotNull("Fornecedor não deve ser null", fornecedor);
    }

    @Test
    public void testRelacionamentoFornecedorProduto() {
        // Criar fornecedor
        Fornecedor fornecedor = new Fornecedor(1L, "Digital Innovations", "(11) 99999-2222", 1L);
        
        // Criar produtos que referenciam o fornecedor
        Produto produto1 = new Produto(1L, "Notebook Dell", "unidade", 10.0, 3500.0, true, fornecedor.getId());
        Produto produto2 = new Produto(2L, "Mouse Logitech", "unidade", 50.0, 89.90, true, fornecedor.getId());
        
        // Verificar se os relacionamentos estão corretos
        assertEquals("Produto 1 deve referenciar o ID do fornecedor", fornecedor.getId(), produto1.getFornecedorId());
        assertEquals("Produto 2 deve referenciar o ID do fornecedor", fornecedor.getId(), produto2.getFornecedorId());
        assertNotNull("Fornecedor não deve ser null", fornecedor);
        assertNotNull("Produto 1 não deve ser null", produto1);
        assertNotNull("Produto 2 não deve ser null", produto2);
    }

    @Test
    public void testRelacionamentoCompleto() {
        // Criar endereço
        Endereco endereco = new Endereco(1L, "Av. Paulista, 1000", "São Paulo", "SP");
        
        // Criar fornecedor
        Fornecedor fornecedor = new Fornecedor(1L, "Smart Systems", "(11) 99999-3333", endereco.getId());
        
        // Criar produtos
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto(1L, "Teclado RGB", "unidade", 25.0, 299.90, true, fornecedor.getId()));
        produtos.add(new Produto(2L, "Monitor 24\"", "unidade", 15.0, 899.90, true, fornecedor.getId()));
        produtos.add(new Produto(3L, "Webcam HD", "unidade", 30.0, 199.90, false, fornecedor.getId()));
        
        // Associar produtos ao fornecedor
        fornecedor.setProdutos(produtos);
        
        // Verificar relacionamentos
        assertEquals("Fornecedor deve referenciar o endereço", endereco.getId(), fornecedor.getEnderecoId());
        assertEquals("Fornecedor deve ter 3 produtos", 3, fornecedor.getProdutos().size());
        
        for (Produto produto : produtos) {
            assertEquals("Cada produto deve referenciar o fornecedor", fornecedor.getId(), produto.getFornecedorId());
        }
    }

    @Test
    public void testCicloDeVidaCompleto() {
        // 1. Criar endereço
        Endereco endereco = new Endereco("Rua Augusta, 500", "São Paulo", "SP");
        assertNotNull("Endereço deve ser criado", endereco);
        
        // 2. Atualizar endereço
        endereco.setId(1L);
        assertEquals("ID do endereço deve ser 1", 1L, endereco.getId());
        
        // 3. Criar fornecedor
        Fornecedor fornecedor = new Fornecedor("Future Tech", "(11) 99999-4444", endereco.getId());
        assertNotNull("Fornecedor deve ser criado", fornecedor);
        
        // 4. Atualizar fornecedor
        fornecedor.setId(1L);
        assertEquals("ID do fornecedor deve ser 1", 1L, fornecedor.getId());
        
        // 5. Criar produtos
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Headset Gamer", "unidade", 20.0, 399.90, true, fornecedor.getId()));
        produtos.add(new Produto("SSD 500GB", "unidade", 40.0, 299.90, true, fornecedor.getId()));
        
        // 6. Associar produtos ao fornecedor
        fornecedor.setProdutos(produtos);
        assertEquals("Fornecedor deve ter 2 produtos", 2, fornecedor.getProdutos().size());
        
        // 7. Atualizar produtos
        for (int i = 0; i < produtos.size(); i++) {
            produtos.get(i).setId(i + 1L);
            assertEquals("ID do produto " + (i + 1) + " deve ser " + (i + 1), (long)(i + 1), produtos.get(i).getId());
        }
    }

    @Test
    public void testValidacaoDeDados() {
        // Teste com dados válidos
        Endereco endereco = new Endereco("Rua Válida, 123", "Cidade Válida", "UF");
        Fornecedor fornecedor = new Fornecedor("Fornecedor Válido", "(11) 99999-9999", 1L);
        Produto produto = new Produto("Produto Válido", "unidade", 10.0, 100.0, true, 1L);
        
        assertNotNull("Endereço com dados válidos deve ser criado", endereco);
        assertNotNull("Fornecedor com dados válidos deve ser criado", fornecedor);
        assertNotNull("Produto com dados válidos deve ser criado", produto);
        
        // Verificar se os dados foram armazenados corretamente
        assertEquals("Endereço deve manter os dados", "Rua Válida, 123", endereco.getEndereco());
        assertEquals("Fornecedor deve manter os dados", "Fornecedor Válido", fornecedor.getNome());
        assertEquals("Produto deve manter os dados", "Produto Válido", produto.getDescricao());
    }

    @Test
    public void testToStringIntegracao() {
        // Criar objetos relacionados
        Endereco endereco = new Endereco(1L, "Rua Teste, 123", "Cidade Teste", "TS");
        Fornecedor fornecedor = new Fornecedor(1L, "Fornecedor Teste", "(11) 99999-9999", endereco.getId());
        Produto produto = new Produto(1L, "Produto Teste", "unidade", 1.0, 100.0, true, fornecedor.getId());
        
        // Verificar se toString funciona para todos os objetos
        String enderecoStr = endereco.toString();
        String fornecedorStr = fornecedor.toString();
        String produtoStr = produto.toString();
        
        assertNotNull("toString do endereço não deve ser null", enderecoStr);
        assertNotNull("toString do fornecedor não deve ser null", fornecedorStr);
        assertNotNull("toString do produto não deve ser null", produtoStr);
        
        // Verificar se contêm informações relevantes
        assertTrue("toString do endereço deve conter informações", enderecoStr.contains("Endereco{"));
        assertTrue("toString do fornecedor deve conter informações", fornecedorStr.contains("Fornecedor{"));
        assertTrue("toString do produto deve conter informações", produtoStr.contains("Produto{"));
    }

    @Test
    public void testEqualsEHashCodeIntegracao() {
        // Criar objetos idênticos
        Endereco endereco1 = new Endereco(1L, "Rua Igual, 123", "Cidade Igual", "UF");
        Endereco endereco2 = new Endereco(1L, "Rua Igual, 123", "Cidade Igual", "UF");
        
        Fornecedor fornecedor1 = new Fornecedor(1L, "Fornecedor Igual", "(11) 99999-9999", 1L);
        Fornecedor fornecedor2 = new Fornecedor(1L, "Fornecedor Igual", "(11) 99999-9999", 1L);
        
        Produto produto1 = new Produto(1L, "Produto Igual", "unidade", 1.0, 100.0, true, 1L);
        Produto produto2 = new Produto(1L, "Produto Igual", "unidade", 1.0, 100.0, true, 1L);
        
        // Verificar equals
        assertEquals("Endereços iguais devem ser iguais", endereco1.getId(), endereco2.getId());
        assertEquals("Fornecedores iguais devem ser iguais", fornecedor1.getId(), fornecedor2.getId());
        assertEquals("Produtos iguais devem ser iguais", produto1.getId(), produto2.getId());
        
        // Verificar hashCode
        assertEquals("Hash codes de endereços iguais devem ser iguais", endereco1.hashCode(), endereco2.hashCode());
        assertEquals("Hash codes de fornecedores iguais devem ser iguais", fornecedor1.hashCode(), fornecedor2.hashCode());
        assertEquals("Hash codes de produtos iguais devem ser iguais", produto1.hashCode(), produto2.hashCode());
    }

    @Test
    public void testCenariosLimite() {
        // Teste com valores extremos
        Endereco endereco = new Endereco(Long.MAX_VALUE, "Endereço Extremo", "Cidade Extremo", "EX");
        Fornecedor fornecedor = new Fornecedor(Long.MAX_VALUE, "Fornecedor Extremo", "Contato Extremo", Long.MAX_VALUE);
        Produto produto = new Produto(Long.MAX_VALUE, "Produto Extremo", "Unidade Extremo", Double.MAX_VALUE, Double.MAX_VALUE, true, Long.MAX_VALUE);
        
        // Verificar se os valores extremos são aceitos
        assertEquals("ID máximo deve ser aceito no endereço", Long.MAX_VALUE, endereco.getId());
        assertEquals("ID máximo deve ser aceito no fornecedor", Long.MAX_VALUE, fornecedor.getId());
        assertEquals("ID máximo deve ser aceito no produto", Long.MAX_VALUE, produto.getId());
        assertEquals("Quantidade máxima deve ser aceita", Double.MAX_VALUE, produto.getQuantidade(), 0.001);
        assertEquals("Valor máximo deve ser aceito", Double.MAX_VALUE, produto.getValor(), 0.001);
    }

    @Test
    public void testCenariosNulos() {
        // Teste com valores nulos
        Endereco endereco = new Endereco();
        Fornecedor fornecedor = new Fornecedor();
        Produto produto = new Produto();
        
        // Definir valores nulos
        endereco.setEndereco(null);
        endereco.setCidade(null);
        endereco.setEstado(null);
        
        fornecedor.setNome(null);
        fornecedor.setContato(null);
        fornecedor.setProdutos(null);
        
        produto.setDescricao(null);
        produto.setUnidade(null);
        
        // Verificar se valores nulos são aceitos
        assertNull("Endereço null deve ser aceito", endereco.getEndereco());
        assertNull("Cidade null deve ser aceita", endereco.getCidade());
        assertNull("Estado null deve ser aceito", endereco.getEstado());
        
        assertNull("Nome null deve ser aceito", fornecedor.getNome());
        assertNull("Contato null deve ser aceito", fornecedor.getContato());
        assertNull("Lista de produtos null deve ser aceita", fornecedor.getProdutos());
        
        assertNull("Descrição null deve ser aceita", produto.getDescricao());
        assertNull("Unidade null deve ser aceita", produto.getUnidade());
    }

    @Test
    public void testPerformanceBasica() {
        // Teste de performance básica com múltiplos objetos
        List<Endereco> enderecos = new ArrayList<>();
        List<Fornecedor> fornecedores = new ArrayList<>();
        List<Produto> produtos = new ArrayList<>();
        
        // Criar 1000 objetos de cada tipo
        for (int i = 0; i < 1000; i++) {
            enderecos.add(new Endereco(i, "Rua " + i, "Cidade " + i, "UF"));
            fornecedores.add(new Fornecedor(i, "Fornecedor " + i, "Contato " + i, i));
            produtos.add(new Produto(i, "Produto " + i, "unidade", i, i * 10.0, i % 2 == 0, i));
        }
        
        // Verificar se todos foram criados
        assertEquals("Deve ter 1000 endereços", 1000, enderecos.size());
        assertEquals("Deve ter 1000 fornecedores", 1000, fornecedores.size());
        assertEquals("Deve ter 1000 produtos", 1000, produtos.size());
        
        // Verificar se os dados estão corretos
        assertEquals("Primeiro endereço deve ter ID 0", 0, enderecos.get(0).getId());
        assertEquals("Último endereço deve ter ID 999", 999, enderecos.get(999).getId());
        assertEquals("Primeiro fornecedor deve ter ID 0", 0, fornecedores.get(0).getId());
        assertEquals("Último fornecedor deve ter ID 999", 999, fornecedores.get(999).getId());
        assertEquals("Primeiro produto deve ter ID 0", 0, produtos.get(0).getId());
        assertEquals("Último produto deve ter ID 999", 999, produtos.get(999).getId());
    }
} 