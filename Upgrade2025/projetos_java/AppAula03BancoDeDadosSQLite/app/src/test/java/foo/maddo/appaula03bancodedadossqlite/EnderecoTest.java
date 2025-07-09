package foo.maddo.appaula03bancodedadossqlite;

import org.junit.Test;
import static org.junit.Assert.*;

import foo.maddo.appaula03bancodedadossqlite.model.Endereco;

public class EnderecoTest {

    @Test
    public void testConstrutorVazio() {
        Endereco endereco = new Endereco();
        assertNotNull("Endereço não deve ser null", endereco);
        assertEquals("ID deve ser 0 por padrão", 0, endereco.getId());
        assertNull("Endereço deve ser null por padrão", endereco.getEndereco());
        assertNull("Cidade deve ser null por padrão", endereco.getCidade());
        assertNull("Estado deve ser null por padrão", endereco.getEstado());
    }

    @Test
    public void testConstrutorComParametros() {
        String enderecoStr = "Rua das Flores, 123";
        String cidade = "São Paulo";
        String estado = "SP";

        Endereco endereco = new Endereco(enderecoStr, cidade, estado);

        assertNotNull("Endereço não deve ser null", endereco);
        assertEquals("Endereço deve ser igual ao passado", enderecoStr, endereco.getEndereco());
        assertEquals("Cidade deve ser igual à passada", cidade, endereco.getCidade());
        assertEquals("Estado deve ser igual ao passado", estado, endereco.getEstado());
    }

    @Test
    public void testConstrutorCompleto() {
        long id = 1L;
        String enderecoStr = "Av. Paulista, 1000";
        String cidade = "São Paulo";
        String estado = "SP";

        Endereco endereco = new Endereco(id, enderecoStr, cidade, estado);

        assertNotNull("Endereço não deve ser null", endereco);
        assertEquals("ID deve ser igual ao passado", id, endereco.getId());
        assertEquals("Endereço deve ser igual ao passado", enderecoStr, endereco.getEndereco());
        assertEquals("Cidade deve ser igual à passada", cidade, endereco.getCidade());
        assertEquals("Estado deve ser igual ao passado", estado, endereco.getEstado());
    }

    @Test
    public void testSetId() {
        Endereco endereco = new Endereco();
        long id = 5L;
        
        endereco.setId(id);
        
        assertEquals("ID deve ser atualizado", id, endereco.getId());
    }

    @Test
    public void testGetId() {
        long id = 10L;
        Endereco endereco = new Endereco(id, "Rua Teste", "Cidade Teste", "TS");
        
        assertEquals("ID deve ser retornado corretamente", id, endereco.getId());
    }

    @Test
    public void testSetEndereco() {
        Endereco endereco = new Endereco();
        String enderecoStr = "Rua Nova, 456";
        
        endereco.setEndereco(enderecoStr);
        
        assertEquals("Endereço deve ser atualizado", enderecoStr, endereco.getEndereco());
    }

    @Test
    public void testGetEndereco() {
        String enderecoStr = "Av. Brasil, 789";
        Endereco endereco = new Endereco(enderecoStr, "Rio de Janeiro", "RJ");
        
        assertEquals("Endereço deve ser retornado corretamente", enderecoStr, endereco.getEndereco());
    }

    @Test
    public void testSetCidade() {
        Endereco endereco = new Endereco();
        String cidade = "Belo Horizonte";
        
        endereco.setCidade(cidade);
        
        assertEquals("Cidade deve ser atualizada", cidade, endereco.getCidade());
    }

    @Test
    public void testGetCidade() {
        String cidade = "Salvador";
        Endereco endereco = new Endereco("Rua Bahia", cidade, "BA");
        
        assertEquals("Cidade deve ser retornada corretamente", cidade, endereco.getCidade());
    }

    @Test
    public void testSetEstado() {
        Endereco endereco = new Endereco();
        String estado = "MG";
        
        endereco.setEstado(estado);
        
        assertEquals("Estado deve ser atualizado", estado, endereco.getEstado());
    }

    @Test
    public void testGetEstado() {
        String estado = "RS";
        Endereco endereco = new Endereco("Rua Gaúcha", "Porto Alegre", estado);
        
        assertEquals("Estado deve ser retornado corretamente", estado, endereco.getEstado());
    }

    @Test
    public void testToString() {
        long id = 1L;
        String enderecoStr = "Rua das Flores, 123";
        String cidade = "São Paulo";
        String estado = "SP";
        
        Endereco endereco = new Endereco(id, enderecoStr, cidade, estado);
        String resultado = endereco.toString();
        
        assertNotNull("toString não deve ser null", resultado);
        assertTrue("toString deve conter o ID", resultado.contains("id=" + id));
        assertTrue("toString deve conter o endereço", resultado.contains("endereco='" + enderecoStr + "'"));
        assertTrue("toString deve conter a cidade", resultado.contains("cidade='" + cidade + "'"));
        assertTrue("toString deve conter o estado", resultado.contains("estado='" + estado + "'"));
    }

    @Test
    public void testToStringComValoresNull() {
        Endereco endereco = new Endereco();
        String resultado = endereco.toString();
        
        assertNotNull("toString não deve ser null mesmo com valores null", resultado);
        assertTrue("toString deve conter informações do objeto", resultado.contains("Endereco{"));
    }

    @Test
    public void testEqualsMesmoObjeto() {
        Endereco endereco = new Endereco(1L, "Rua Teste", "Cidade", "UF");
        
        assertEquals("Objeto deve ser igual a si mesmo", endereco, endereco);
    }

    @Test
    public void testEqualsObjetosDiferentes() {
        Endereco endereco1 = new Endereco(1L, "Rua A", "Cidade A", "UF A");
        Endereco endereco2 = new Endereco(2L, "Rua B", "Cidade B", "UF B");
        
        assertNotEquals("Objetos com IDs diferentes devem ser diferentes", endereco1, endereco2);
    }

    @Test
    public void testEqualsObjetosIguais() {
        Endereco endereco1 = new Endereco(1L, "Rua Teste", "Cidade", "UF");
        Endereco endereco2 = new Endereco(1L, "Rua Teste", "Cidade", "UF");
        
        assertEquals("Objetos com mesmos valores devem ser iguais", endereco1.getId(), endereco2.getId());
        assertEquals("Endereços devem ser iguais", endereco1.getEndereco(), endereco2.getEndereco());
        assertEquals("Cidades devem ser iguais", endereco1.getCidade(), endereco2.getCidade());
        assertEquals("Estados devem ser iguais", endereco1.getEstado(), endereco2.getEstado());
    }

    @Test
    public void testHashCodeConsistencia() {
        Endereco endereco1 = new Endereco(1L, "Rua Teste", "Cidade", "UF");
        Endereco endereco2 = new Endereco(1L, "Rua Teste", "Cidade", "UF");
        
        assertEquals("Hash codes devem ser iguais para objetos iguais", 
                    endereco1.hashCode(), endereco2.hashCode());
    }

    @Test
    public void testValoresLimites() {
        // Teste com ID máximo
        long idMaximo = Long.MAX_VALUE;
        Endereco endereco = new Endereco(idMaximo, "Rua Teste", "Cidade", "UF");
        assertEquals("ID máximo deve ser aceito", idMaximo, endereco.getId());
        
        // Teste com ID mínimo
        long idMinimo = Long.MIN_VALUE;
        endereco.setId(idMinimo);
        assertEquals("ID mínimo deve ser aceito", idMinimo, endereco.getId());
    }

    @Test
    public void testStringsVazias() {
        Endereco endereco = new Endereco();
        
        endereco.setEndereco("");
        endereco.setCidade("");
        endereco.setEstado("");
        
        assertEquals("String vazia deve ser aceita para endereço", "", endereco.getEndereco());
        assertEquals("String vazia deve ser aceita para cidade", "", endereco.getCidade());
        assertEquals("String vazia deve ser aceita para estado", "", endereco.getEstado());
    }

    @Test
    public void testStringsLongas() {
        String enderecoLongo = "Rua muito longa com muitos caracteres para testar se a classe suporta strings extensas sem problemas de performance ou memória";
        String cidadeLonga = "Cidade com nome muito extenso para testar o comportamento da classe com strings longas";
        String estadoLongo = "Estado com nome muito extenso para testar limites";
        
        Endereco endereco = new Endereco(enderecoLongo, cidadeLonga, estadoLongo);
        
        assertEquals("String longa deve ser aceita para endereço", enderecoLongo, endereco.getEndereco());
        assertEquals("String longa deve ser aceita para cidade", cidadeLonga, endereco.getCidade());
        assertEquals("String longa deve ser aceita para estado", estadoLongo, endereco.getEstado());
    }
} 