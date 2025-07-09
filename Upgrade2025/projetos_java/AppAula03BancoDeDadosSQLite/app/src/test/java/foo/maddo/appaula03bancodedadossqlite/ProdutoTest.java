package foo.maddo.appaula03bancodedadossqlite;

import org.junit.Test;
import static org.junit.Assert.*;

import foo.maddo.appaula03bancodedadossqlite.model.Produto;

public class ProdutoTest {

    @Test
    public void testConstrutorVazio() {
        Produto produto = new Produto();
        assertNotNull("Produto não deve ser null", produto);
        assertEquals("ID deve ser 0 por padrão", 0, produto.getId());
        assertNull("Descrição deve ser null por padrão", produto.getDescricao());
        assertNull("Unidade deve ser null por padrão", produto.getUnidade());
        assertEquals("Quantidade deve ser 0.0 por padrão", 0.0, produto.getQuantidade(), 0.001);
        assertEquals("Valor deve ser 0.0 por padrão", 0.0, produto.getValor(), 0.001);
        assertFalse("Estoque deve ser false por padrão", produto.isEstoque());
        assertEquals("FornecedorId deve ser 0 por padrão", 0, produto.getFornecedorId());
    }

    @Test
    public void testConstrutorComParametros() {
        String descricao = "Notebook Dell Inspiron";
        String unidade = "unidade";
        double quantidade = 10.0;
        double valor = 3500.00;
        boolean estoque = true;
        long fornecedorId = 1L;

        Produto produto = new Produto(descricao, unidade, quantidade, valor, estoque, fornecedorId);

        assertNotNull("Produto não deve ser null", produto);
        assertEquals("Descrição deve ser igual à passada", descricao, produto.getDescricao());
        assertEquals("Unidade deve ser igual à passada", unidade, produto.getUnidade());
        assertEquals("Quantidade deve ser igual à passada", quantidade, produto.getQuantidade(), 0.001);
        assertEquals("Valor deve ser igual ao passado", valor, produto.getValor(), 0.001);
        assertEquals("Estoque deve ser igual ao passado", estoque, produto.isEstoque());
        assertEquals("FornecedorId deve ser igual ao passado", fornecedorId, produto.getFornecedorId());
    }

    @Test
    public void testConstrutorCompleto() {
        long id = 1L;
        String descricao = "Mouse Wireless Logitech";
        String unidade = "unidade";
        double quantidade = 50.0;
        double valor = 89.90;
        boolean estoque = true;
        long fornecedorId = 2L;

        Produto produto = new Produto(id, descricao, unidade, quantidade, valor, estoque, fornecedorId);

        assertNotNull("Produto não deve ser null", produto);
        assertEquals("ID deve ser igual ao passado", id, produto.getId());
        assertEquals("Descrição deve ser igual à passada", descricao, produto.getDescricao());
        assertEquals("Unidade deve ser igual à passada", unidade, produto.getUnidade());
        assertEquals("Quantidade deve ser igual à passada", quantidade, produto.getQuantidade(), 0.001);
        assertEquals("Valor deve ser igual ao passado", valor, produto.getValor(), 0.001);
        assertEquals("Estoque deve ser igual ao passado", estoque, produto.isEstoque());
        assertEquals("FornecedorId deve ser igual ao passado", fornecedorId, produto.getFornecedorId());
    }

    @Test
    public void testSetId() {
        Produto produto = new Produto();
        long id = 5L;
        
        produto.setId(id);
        
        assertEquals("ID deve ser atualizado", id, produto.getId());
    }

    @Test
    public void testGetId() {
        long id = 10L;
        Produto produto = new Produto(id, "Produto Teste", "unidade", 1.0, 100.0, true, 1L);
        
        assertEquals("ID deve ser retornado corretamente", id, produto.getId());
    }

    @Test
    public void testSetDescricao() {
        Produto produto = new Produto();
        String descricao = "Novo Produto";
        
        produto.setDescricao(descricao);
        
        assertEquals("Descrição deve ser atualizada", descricao, produto.getDescricao());
    }

    @Test
    public void testGetDescricao() {
        String descricao = "Teclado Mecânico RGB";
        Produto produto = new Produto(descricao, "unidade", 25.0, 299.90, true, 1L);
        
        assertEquals("Descrição deve ser retornada corretamente", descricao, produto.getDescricao());
    }

    @Test
    public void testSetUnidade() {
        Produto produto = new Produto();
        String unidade = "kg";
        
        produto.setUnidade(unidade);
        
        assertEquals("Unidade deve ser atualizada", unidade, produto.getUnidade());
    }

    @Test
    public void testGetUnidade() {
        String unidade = "litros";
        Produto produto = new Produto("Água", unidade, 10.0, 5.0, true, 1L);
        
        assertEquals("Unidade deve ser retornada corretamente", unidade, produto.getUnidade());
    }

    @Test
    public void testSetQuantidade() {
        Produto produto = new Produto();
        double quantidade = 15.5;
        
        produto.setQuantidade(quantidade);
        
        assertEquals("Quantidade deve ser atualizada", quantidade, produto.getQuantidade(), 0.001);
    }

    @Test
    public void testGetQuantidade() {
        double quantidade = 7.25;
        Produto produto = new Produto("Produto Teste", "unidade", quantidade, 50.0, true, 1L);
        
        assertEquals("Quantidade deve ser retornada corretamente", quantidade, produto.getQuantidade(), 0.001);
    }

    @Test
    public void testSetValor() {
        Produto produto = new Produto();
        double valor = 199.99;
        
        produto.setValor(valor);
        
        assertEquals("Valor deve ser atualizado", valor, produto.getValor(), 0.001);
    }

    @Test
    public void testGetValor() {
        double valor = 899.90;
        Produto produto = new Produto("Monitor LG 24\"", "unidade", 15.0, valor, true, 1L);
        
        assertEquals("Valor deve ser retornado corretamente", valor, produto.getValor(), 0.001);
    }

    @Test
    public void testSetEstoque() {
        Produto produto = new Produto();
        
        produto.setEstoque(true);
        assertTrue("Estoque deve ser true", produto.isEstoque());
        
        produto.setEstoque(false);
        assertFalse("Estoque deve ser false", produto.isEstoque());
    }

    @Test
    public void testIsEstoque() {
        Produto produto = new Produto("Webcam HD 1080p", "unidade", 30.0, 199.90, true, 1L);
        assertTrue("Estoque deve ser true", produto.isEstoque());
        
        Produto produtoSemEstoque = new Produto("Placa de Vídeo GTX 1660", "unidade", 8.0, 1899.90, false, 1L);
        assertFalse("Estoque deve ser false", produtoSemEstoque.isEstoque());
    }

    @Test
    public void testSetFornecedorId() {
        Produto produto = new Produto();
        long fornecedorId = 15L;
        
        produto.setFornecedorId(fornecedorId);
        
        assertEquals("FornecedorId deve ser atualizado", fornecedorId, produto.getFornecedorId());
    }

    @Test
    public void testGetFornecedorId() {
        long fornecedorId = 20L;
        Produto produto = new Produto("SSD 500GB Kingston", "unidade", 40.0, 299.90, true, fornecedorId);
        
        assertEquals("FornecedorId deve ser retornado corretamente", fornecedorId, produto.getFornecedorId());
    }

    @Test
    public void testToString() {
        long id = 1L;
        String descricao = "Memória RAM 8GB";
        String unidade = "unidade";
        double quantidade = 60.0;
        double valor = 199.90;
        boolean estoque = true;
        long fornecedorId = 3L;
        
        Produto produto = new Produto(id, descricao, unidade, quantidade, valor, estoque, fornecedorId);
        String resultado = produto.toString();
        
        assertNotNull("toString não deve ser null", resultado);
        assertTrue("toString deve conter o ID", resultado.contains("id=" + id));
        assertTrue("toString deve conter a descrição", resultado.contains("descricao='" + descricao + "'"));
        assertTrue("toString deve conter a unidade", resultado.contains("unidade='" + unidade + "'"));
        assertTrue("toString deve conter a quantidade", resultado.contains("quantidade=" + quantidade));
        assertTrue("toString deve conter o valor", resultado.contains("valor=" + valor));
        assertTrue("toString deve conter o estoque", resultado.contains("estoque=" + estoque));
        assertTrue("toString deve conter o fornecedorId", resultado.contains("fornecedorId=" + fornecedorId));
    }

    @Test
    public void testToStringComValoresNull() {
        Produto produto = new Produto();
        String resultado = produto.toString();
        
        assertNotNull("toString não deve ser null mesmo com valores null", resultado);
        assertTrue("toString deve conter informações do objeto", resultado.contains("Produto{"));
    }

    @Test
    public void testEqualsMesmoObjeto() {
        Produto produto = new Produto(1L, "Produto Teste", "unidade", 1.0, 100.0, true, 1L);
        
        assertEquals("Objeto deve ser igual a si mesmo", produto, produto);
    }

    @Test
    public void testEqualsObjetosDiferentes() {
        Produto produto1 = new Produto(1L, "Produto A", "unidade", 1.0, 100.0, true, 1L);
        Produto produto2 = new Produto(2L, "Produto B", "unidade", 2.0, 200.0, false, 2L);
        
        assertNotEquals("Objetos com IDs diferentes devem ser diferentes", produto1, produto2);
    }

    @Test
    public void testEqualsObjetosIguais() {
        Produto produto1 = new Produto(1L, "Produto Teste", "unidade", 1.0, 100.0, true, 1L);
        Produto produto2 = new Produto(1L, "Produto Teste", "unidade", 1.0, 100.0, true, 1L);
        
        assertEquals("Objetos com mesmos valores devem ser iguais", produto1.getId(), produto2.getId());
        assertEquals("Descrições devem ser iguais", produto1.getDescricao(), produto2.getDescricao());
        assertEquals("Unidades devem ser iguais", produto1.getUnidade(), produto2.getUnidade());
        assertEquals("Quantidades devem ser iguais", produto1.getQuantidade(), produto2.getQuantidade(), 0.001);
        assertEquals("Valores devem ser iguais", produto1.getValor(), produto2.getValor(), 0.001);
        assertEquals("Estoques devem ser iguais", produto1.isEstoque(), produto2.isEstoque());
        assertEquals("FornecedorIds devem ser iguais", produto1.getFornecedorId(), produto2.getFornecedorId());
    }

    @Test
    public void testHashCodeConsistencia() {
        Produto produto1 = new Produto(1L, "Produto Teste", "unidade", 1.0, 100.0, true, 1L);
        Produto produto2 = new Produto(1L, "Produto Teste", "unidade", 1.0, 100.0, true, 1L);
        
        assertEquals("Hash codes devem ser iguais para objetos iguais", 
                    produto1.hashCode(), produto2.hashCode());
    }

    @Test
    public void testValoresLimites() {
        // Teste com ID máximo
        long idMaximo = Long.MAX_VALUE;
        Produto produto = new Produto(idMaximo, "Produto Teste", "unidade", 1.0, 100.0, true, 1L);
        assertEquals("ID máximo deve ser aceito", idMaximo, produto.getId());
        
        // Teste com ID mínimo
        long idMinimo = Long.MIN_VALUE;
        produto.setId(idMinimo);
        assertEquals("ID mínimo deve ser aceito", idMinimo, produto.getId());
        
        // Teste com FornecedorId máximo
        long fornecedorIdMaximo = Long.MAX_VALUE;
        produto.setFornecedorId(fornecedorIdMaximo);
        assertEquals("FornecedorId máximo deve ser aceito", fornecedorIdMaximo, produto.getFornecedorId());
    }

    @Test
    public void testValoresNumericosLimites() {
        Produto produto = new Produto();
        
        // Teste com quantidade máxima
        double quantidadeMaxima = Double.MAX_VALUE;
        produto.setQuantidade(quantidadeMaxima);
        assertEquals("Quantidade máxima deve ser aceita", quantidadeMaxima, produto.getQuantidade(), 0.001);
        
        // Teste com quantidade mínima
        double quantidadeMinima = Double.MIN_VALUE;
        produto.setQuantidade(quantidadeMinima);
        assertEquals("Quantidade mínima deve ser aceita", quantidadeMinima, produto.getQuantidade(), 0.001);
        
        // Teste com valor máximo
        double valorMaximo = Double.MAX_VALUE;
        produto.setValor(valorMaximo);
        assertEquals("Valor máximo deve ser aceito", valorMaximo, produto.getValor(), 0.001);
        
        // Teste com valor mínimo
        double valorMinimo = Double.MIN_VALUE;
        produto.setValor(valorMinimo);
        assertEquals("Valor mínimo deve ser aceito", valorMinimo, produto.getValor(), 0.001);
    }

    @Test
    public void testStringsVazias() {
        Produto produto = new Produto();
        
        produto.setDescricao("");
        produto.setUnidade("");
        
        assertEquals("String vazia deve ser aceita para descrição", "", produto.getDescricao());
        assertEquals("String vazia deve ser aceita para unidade", "", produto.getUnidade());
    }

    @Test
    public void testStringsLongas() {
        String descricaoLonga = "Descrição muito longa do produto para testar se a classe suporta strings extensas sem problemas de performance ou memória";
        String unidadeLonga = "Unidade muito longa para testar o comportamento da classe com strings longas";
        
        Produto produto = new Produto(descricaoLonga, unidadeLonga, 1.0, 100.0, true, 1L);
        
        assertEquals("String longa deve ser aceita para descrição", descricaoLonga, produto.getDescricao());
        assertEquals("String longa deve ser aceita para unidade", unidadeLonga, produto.getUnidade());
    }

    @Test
    public void testValoresNegativos() {
        Produto produto = new Produto();
        
        // Teste com quantidade negativa
        double quantidadeNegativa = -10.5;
        produto.setQuantidade(quantidadeNegativa);
        assertEquals("Quantidade negativa deve ser aceita", quantidadeNegativa, produto.getQuantidade(), 0.001);
        
        // Teste com valor negativo
        double valorNegativo = -50.0;
        produto.setValor(valorNegativo);
        assertEquals("Valor negativo deve ser aceito", valorNegativo, produto.getValor(), 0.001);
        
        // Teste com FornecedorId negativo
        long fornecedorIdNegativo = -1L;
        produto.setFornecedorId(fornecedorIdNegativo);
        assertEquals("FornecedorId negativo deve ser aceito", fornecedorIdNegativo, produto.getFornecedorId());
    }

    @Test
    public void testValoresZero() {
        Produto produto = new Produto();
        
        produto.setQuantidade(0.0);
        produto.setValor(0.0);
        produto.setFornecedorId(0L);
        
        assertEquals("Quantidade zero deve ser aceita", 0.0, produto.getQuantidade(), 0.001);
        assertEquals("Valor zero deve ser aceito", 0.0, produto.getValor(), 0.001);
        assertEquals("FornecedorId zero deve ser aceito", 0L, produto.getFornecedorId());
    }

    @Test
    public void testValoresDecimais() {
        Produto produto = new Produto();
        
        // Teste com valores decimais pequenos
        produto.setQuantidade(0.001);
        produto.setValor(0.99);
        assertEquals("Quantidade decimal pequena deve ser aceita", 0.001, produto.getQuantidade(), 0.0001);
        assertEquals("Valor decimal pequeno deve ser aceito", 0.99, produto.getValor(), 0.001);
        
        // Teste com valores decimais grandes
        produto.setQuantidade(123.456789);
        produto.setValor(999.999999);
        assertEquals("Quantidade decimal grande deve ser aceita", 123.456789, produto.getQuantidade(), 0.000001);
        assertEquals("Valor decimal grande deve ser aceito", 999.999999, produto.getValor(), 0.000001);
    }

    @Test
    public void testUnidadesDiferentes() {
        Produto produto = new Produto();
        
        String[] unidades = {
            "unidade",
            "kg",
            "litros",
            "metros",
            "caixa",
            "pacote",
            "par",
            "dozena",
            "centena",
            "milheiro"
        };
        
        for (String unidade : unidades) {
            produto.setUnidade(unidade);
            assertEquals("Unidade deve ser aceita: " + unidade, unidade, produto.getUnidade());
        }
    }

    @Test
    public void testEstoqueAlternado() {
        Produto produto = new Produto();
        
        // Alternar estoque várias vezes
        for (int i = 0; i < 10; i++) {
            boolean estoque = i % 2 == 0;
            produto.setEstoque(estoque);
            assertEquals("Estoque deve alternar corretamente na iteração " + i, estoque, produto.isEstoque());
        }
    }

    @Test
    public void testPrecisaoNumerica() {
        Produto produto = new Produto();
        
        // Teste de precisão para valores monetários
        produto.setValor(10.99);
        assertEquals("Valor deve manter precisão", 10.99, produto.getValor(), 0.001);
        
        produto.setValor(100.01);
        assertEquals("Valor deve manter precisão", 100.01, produto.getValor(), 0.001);
        
        produto.setValor(0.01);
        assertEquals("Valor deve manter precisão", 0.01, produto.getValor(), 0.001);
    }
} 