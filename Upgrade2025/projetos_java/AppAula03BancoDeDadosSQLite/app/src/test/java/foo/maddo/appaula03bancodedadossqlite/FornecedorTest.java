package foo.maddo.appaula03bancodedadossqlite;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import foo.maddo.appaula03bancodedadossqlite.model.Fornecedor;
import foo.maddo.appaula03bancodedadossqlite.model.Produto;

public class FornecedorTest {

    @Test
    public void testConstrutorVazio() {
        Fornecedor fornecedor = new Fornecedor();
        assertNotNull("Fornecedor não deve ser null", fornecedor);
        assertEquals("ID deve ser 0 por padrão", 0, fornecedor.getId());
        assertNull("Nome deve ser null por padrão", fornecedor.getNome());
        assertNull("Contato deve ser null por padrão", fornecedor.getContato());
        assertEquals("EnderecoId deve ser 0 por padrão", 0, fornecedor.getEnderecoId());
        assertNull("Lista de produtos deve ser null por padrão", fornecedor.getProdutos());
    }

    @Test
    public void testConstrutorComParametros() {
        String nome = "Tech Solutions Ltda";
        String contato = "(11) 99999-1111";
        long enderecoId = 1L;

        Fornecedor fornecedor = new Fornecedor(nome, contato, enderecoId);

        assertNotNull("Fornecedor não deve ser null", fornecedor);
        assertEquals("Nome deve ser igual ao passado", nome, fornecedor.getNome());
        assertEquals("Contato deve ser igual ao passado", contato, fornecedor.getContato());
        assertEquals("EnderecoId deve ser igual ao passado", enderecoId, fornecedor.getEnderecoId());
    }

    @Test
    public void testConstrutorCompleto() {
        long id = 1L;
        String nome = "Digital Innovations";
        String contato = "(11) 99999-2222";
        long enderecoId = 2L;

        Fornecedor fornecedor = new Fornecedor(id, nome, contato, enderecoId);

        assertNotNull("Fornecedor não deve ser null", fornecedor);
        assertEquals("ID deve ser igual ao passado", id, fornecedor.getId());
        assertEquals("Nome deve ser igual ao passado", nome, fornecedor.getNome());
        assertEquals("Contato deve ser igual ao passado", contato, fornecedor.getContato());
        assertEquals("EnderecoId deve ser igual ao passado", enderecoId, fornecedor.getEnderecoId());
    }

    @Test
    public void testSetId() {
        Fornecedor fornecedor = new Fornecedor();
        long id = 5L;
        
        fornecedor.setId(id);
        
        assertEquals("ID deve ser atualizado", id, fornecedor.getId());
    }

    @Test
    public void testGetId() {
        long id = 10L;
        Fornecedor fornecedor = new Fornecedor(id, "Fornecedor Teste", "(11) 99999-9999", 1L);
        
        assertEquals("ID deve ser retornado corretamente", id, fornecedor.getId());
    }

    @Test
    public void testSetNome() {
        Fornecedor fornecedor = new Fornecedor();
        String nome = "Novo Fornecedor";
        
        fornecedor.setNome(nome);
        
        assertEquals("Nome deve ser atualizado", nome, fornecedor.getNome());
    }

    @Test
    public void testGetNome() {
        String nome = "Smart Systems";
        Fornecedor fornecedor = new Fornecedor(nome, "(11) 99999-3333", 1L);
        
        assertEquals("Nome deve ser retornado corretamente", nome, fornecedor.getNome());
    }

    @Test
    public void testSetContato() {
        Fornecedor fornecedor = new Fornecedor();
        String contato = "(11) 88888-8888";
        
        fornecedor.setContato(contato);
        
        assertEquals("Contato deve ser atualizado", contato, fornecedor.getContato());
    }

    @Test
    public void testGetContato() {
        String contato = "(11) 77777-7777";
        Fornecedor fornecedor = new Fornecedor("Future Tech", contato, 1L);
        
        assertEquals("Contato deve ser retornado corretamente", contato, fornecedor.getContato());
    }

    @Test
    public void testSetEnderecoId() {
        Fornecedor fornecedor = new Fornecedor();
        long enderecoId = 15L;
        
        fornecedor.setEnderecoId(enderecoId);
        
        assertEquals("EnderecoId deve ser atualizado", enderecoId, fornecedor.getEnderecoId());
    }

    @Test
    public void testGetEnderecoId() {
        long enderecoId = 20L;
        Fornecedor fornecedor = new Fornecedor("Innovation Corp", "(11) 99999-5555", enderecoId);
        
        assertEquals("EnderecoId deve ser retornado corretamente", enderecoId, fornecedor.getEnderecoId());
    }

    @Test
    public void testSetProdutos() {
        Fornecedor fornecedor = new Fornecedor();
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Produto 1", "unidade", 10.0, 100.0, true, 1L));
        produtos.add(new Produto("Produto 2", "unidade", 5.0, 50.0, false, 1L));
        
        fornecedor.setProdutos(produtos);
        
        assertNotNull("Lista de produtos não deve ser null", fornecedor.getProdutos());
        assertEquals("Lista deve ter 2 produtos", 2, fornecedor.getProdutos().size());
        assertEquals("Primeiro produto deve ser igual", "Produto 1", fornecedor.getProdutos().get(0).getDescricao());
        assertEquals("Segundo produto deve ser igual", "Produto 2", fornecedor.getProdutos().get(1).getDescricao());
    }

    @Test
    public void testGetProdutos() {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Notebook", "unidade", 1.0, 3500.0, true, 1L));
        
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setProdutos(produtos);
        
        List<Produto> produtosRetornados = fornecedor.getProdutos();
        assertNotNull("Lista de produtos não deve ser null", produtosRetornados);
        assertEquals("Lista deve ter 1 produto", 1, produtosRetornados.size());
        assertEquals("Produto deve ser igual", "Notebook", produtosRetornados.get(0).getDescricao());
    }

    @Test
    public void testSetProdutosNull() {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setProdutos(null);
        
        assertNull("Lista de produtos deve ser null", fornecedor.getProdutos());
    }

    @Test
    public void testToString() {
        long id = 1L;
        String nome = "Tech Masters";
        String contato = "(11) 99999-6666";
        long enderecoId = 3L;
        
        Fornecedor fornecedor = new Fornecedor(id, nome, contato, enderecoId);
        String resultado = fornecedor.toString();
        
        assertNotNull("toString não deve ser null", resultado);
        assertTrue("toString deve conter o ID", resultado.contains("id=" + id));
        assertTrue("toString deve conter o nome", resultado.contains("nome='" + nome + "'"));
        assertTrue("toString deve conter o contato", resultado.contains("contato='" + contato + "'"));
        assertTrue("toString deve conter o enderecoId", resultado.contains("enderecoId=" + enderecoId));
    }

    @Test
    public void testToStringComProdutos() {
        Fornecedor fornecedor = new Fornecedor(1L, "Digital Experts", "(11) 99999-7777", 1L);
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Mouse", "unidade", 10.0, 89.90, true, 1L));
        fornecedor.setProdutos(produtos);
        
        String resultado = fornecedor.toString();
        
        assertNotNull("toString não deve ser null", resultado);
        assertTrue("toString deve conter informações dos produtos", resultado.contains("produtos="));
    }

    @Test
    public void testToStringComValoresNull() {
        Fornecedor fornecedor = new Fornecedor();
        String resultado = fornecedor.toString();
        
        assertNotNull("toString não deve ser null mesmo com valores null", resultado);
        assertTrue("toString deve conter informações do objeto", resultado.contains("Fornecedor{"));
    }

    @Test
    public void testEqualsMesmoObjeto() {
        Fornecedor fornecedor = new Fornecedor(1L, "Fornecedor Teste", "(11) 99999-9999", 1L);
        
        assertEquals("Objeto deve ser igual a si mesmo", fornecedor, fornecedor);
    }

    @Test
    public void testEqualsObjetosDiferentes() {
        Fornecedor fornecedor1 = new Fornecedor(1L, "Fornecedor A", "(11) 11111-1111", 1L);
        Fornecedor fornecedor2 = new Fornecedor(2L, "Fornecedor B", "(11) 22222-2222", 2L);
        
        assertNotEquals("Objetos com IDs diferentes devem ser diferentes", fornecedor1, fornecedor2);
    }

    @Test
    public void testEqualsObjetosIguais() {
        Fornecedor fornecedor1 = new Fornecedor(1L, "Fornecedor Teste", "(11) 99999-9999", 1L);
        Fornecedor fornecedor2 = new Fornecedor(1L, "Fornecedor Teste", "(11) 99999-9999", 1L);
        
        assertEquals("Objetos com mesmos valores devem ser iguais", fornecedor1.getId(), fornecedor2.getId());
        assertEquals("Nomes devem ser iguais", fornecedor1.getNome(), fornecedor2.getNome());
        assertEquals("Contatos devem ser iguais", fornecedor1.getContato(), fornecedor2.getContato());
        assertEquals("EnderecoIds devem ser iguais", fornecedor1.getEnderecoId(), fornecedor2.getEnderecoId());
    }

    @Test
    public void testHashCodeConsistencia() {
        Fornecedor fornecedor1 = new Fornecedor(1L, "Fornecedor Teste", "(11) 99999-9999", 1L);
        Fornecedor fornecedor2 = new Fornecedor(1L, "Fornecedor Teste", "(11) 99999-9999", 1L);
        
        assertEquals("Hash codes devem ser iguais para objetos iguais", 
                    fornecedor1.hashCode(), fornecedor2.hashCode());
    }

    @Test
    public void testValoresLimites() {
        // Teste com ID máximo
        long idMaximo = Long.MAX_VALUE;
        Fornecedor fornecedor = new Fornecedor(idMaximo, "Fornecedor Teste", "(11) 99999-9999", 1L);
        assertEquals("ID máximo deve ser aceito", idMaximo, fornecedor.getId());
        
        // Teste com ID mínimo
        long idMinimo = Long.MIN_VALUE;
        fornecedor.setId(idMinimo);
        assertEquals("ID mínimo deve ser aceito", idMinimo, fornecedor.getId());
        
        // Teste com EnderecoId máximo
        long enderecoIdMaximo = Long.MAX_VALUE;
        fornecedor.setEnderecoId(enderecoIdMaximo);
        assertEquals("EnderecoId máximo deve ser aceito", enderecoIdMaximo, fornecedor.getEnderecoId());
    }

    @Test
    public void testStringsVazias() {
        Fornecedor fornecedor = new Fornecedor();
        
        fornecedor.setNome("");
        fornecedor.setContato("");
        
        assertEquals("String vazia deve ser aceita para nome", "", fornecedor.getNome());
        assertEquals("String vazia deve ser aceita para contato", "", fornecedor.getContato());
    }

    @Test
    public void testStringsLongas() {
        String nomeLongo = "Nome muito longo do fornecedor para testar se a classe suporta strings extensas sem problemas de performance ou memória";
        String contatoLongo = "Contato muito longo com muitos caracteres para testar o comportamento da classe com strings longas";
        
        Fornecedor fornecedor = new Fornecedor(nomeLongo, contatoLongo, 1L);
        
        assertEquals("String longa deve ser aceita para nome", nomeLongo, fornecedor.getNome());
        assertEquals("String longa deve ser aceita para contato", contatoLongo, fornecedor.getContato());
    }

    @Test
    public void testListaProdutosVazia() {
        Fornecedor fornecedor = new Fornecedor();
        List<Produto> produtosVazios = new ArrayList<>();
        
        fornecedor.setProdutos(produtosVazios);
        
        assertNotNull("Lista vazia não deve ser null", fornecedor.getProdutos());
        assertEquals("Lista vazia deve ter 0 elementos", 0, fornecedor.getProdutos().size());
    }

    @Test
    public void testListaProdutosGrande() {
        Fornecedor fornecedor = new Fornecedor();
        List<Produto> produtosGrande = new ArrayList<>();
        
        // Criar 100 produtos para testar performance
        for (int i = 0; i < 100; i++) {
            produtosGrande.add(new Produto("Produto " + i, "unidade", i, i * 10.0, i % 2 == 0, 1L));
        }
        
        fornecedor.setProdutos(produtosGrande);
        
        assertNotNull("Lista grande não deve ser null", fornecedor.getProdutos());
        assertEquals("Lista grande deve ter 100 elementos", 100, fornecedor.getProdutos().size());
        assertEquals("Primeiro produto deve ser correto", "Produto 0", fornecedor.getProdutos().get(0).getDescricao());
        assertEquals("Último produto deve ser correto", "Produto 99", fornecedor.getProdutos().get(99).getDescricao());
    }

    @Test
    public void testEnderecoIdNegativo() {
        Fornecedor fornecedor = new Fornecedor();
        long enderecoIdNegativo = -1L;
        
        fornecedor.setEnderecoId(enderecoIdNegativo);
        
        assertEquals("EnderecoId negativo deve ser aceito", enderecoIdNegativo, fornecedor.getEnderecoId());
    }

    @Test
    public void testContatoComFormatosDiferentes() {
        Fornecedor fornecedor = new Fornecedor();
        
        // Teste com diferentes formatos de contato
        String[] contatos = {
            "(11) 99999-9999",
            "11999999999",
            "+55 11 99999-9999",
            "contato@empresa.com",
            "www.empresa.com"
        };
        
        for (String contato : contatos) {
            fornecedor.setContato(contato);
            assertEquals("Contato deve ser aceito: " + contato, contato, fornecedor.getContato());
        }
    }
} 