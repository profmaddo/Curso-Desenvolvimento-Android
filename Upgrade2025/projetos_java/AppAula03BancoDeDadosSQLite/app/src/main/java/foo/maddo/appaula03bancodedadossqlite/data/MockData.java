package foo.maddo.appaula03bancodedadossqlite.data;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import foo.maddo.appaula03bancodedadossqlite.dao.EnderecoDAO;
import foo.maddo.appaula03bancodedadossqlite.dao.FornecedorDAO;
import foo.maddo.appaula03bancodedadossqlite.dao.ProdutoDAO;
import foo.maddo.appaula03bancodedadossqlite.model.Endereco;
import foo.maddo.appaula03bancodedadossqlite.model.Fornecedor;
import foo.maddo.appaula03bancodedadossqlite.model.Produto;

public class MockData {
    
    public static void popularBancoDeDados(EnderecoDAO enderecoDAO, FornecedorDAO fornecedorDAO, ProdutoDAO produtoDAO) {
        Log.d("MockData", "Iniciando população do banco de dados com dados mockados");
        
        // Limpar dados existentes
        produtoDAO.deleteAll();
        fornecedorDAO.deleteAll();
        enderecoDAO.deleteAll();
        
        // Criar endereços
        List<Long> enderecoIds = criarEnderecos(enderecoDAO);
        
        // Criar fornecedores
        List<Long> fornecedorIds = criarFornecedores(fornecedorDAO, enderecoIds);
        
        // Criar produtos
        criarProdutos(produtoDAO, fornecedorIds);
        
        Log.d("MockData", "Banco de dados populado com sucesso!");
    }
    
    private static List<Long> criarEnderecos(EnderecoDAO enderecoDAO) {
        List<Long> enderecoIds = new ArrayList<>();
        
        String[][] enderecosData = {
            {"Rua das Flores, 123", "São Paulo", "SP"},
            {"Av. Paulista, 1000", "São Paulo", "SP"},
            {"Rua Augusta, 500", "São Paulo", "SP"},
            {"Av. Brigadeiro Faria Lima, 2000", "São Paulo", "SP"},
            {"Rua Oscar Freire, 300", "São Paulo", "SP"},
            {"Av. Rebouças, 1500", "São Paulo", "SP"},
            {"Rua Haddock Lobo, 800", "São Paulo", "SP"},
            {"Av. Jabaquara, 1200", "São Paulo", "SP"},
            {"Rua Vergueiro, 900", "São Paulo", "SP"},
            {"Av. Santo Amaro, 700", "São Paulo", "SP"}
        };
        
        for (String[] enderecoData : enderecosData) {
            Endereco endereco = new Endereco(enderecoData[0], enderecoData[1], enderecoData[2]);
            long id = enderecoDAO.insert(endereco);
            enderecoIds.add(id);
            Log.d("MockData", "Endereço criado: " + endereco + " com ID: " + id);
        }
        
        return enderecoIds;
    }
    
    private static List<Long> criarFornecedores(FornecedorDAO fornecedorDAO, List<Long> enderecoIds) {
        List<Long> fornecedorIds = new ArrayList<>();
        
        String[][] fornecedoresData = {
            {"Tech Solutions Ltda", "(11) 99999-1111"},
            {"Digital Innovations", "(11) 99999-2222"},
            {"Smart Systems", "(11) 99999-3333"},
            {"Future Tech", "(11) 99999-4444"},
            {"Innovation Corp", "(11) 99999-5555"},
            {"Tech Masters", "(11) 99999-6666"},
            {"Digital Experts", "(11) 99999-7777"},
            {"Smart Solutions", "(11) 99999-8888"},
            {"Future Systems", "(11) 99999-9999"},
            {"Innovation Tech", "(11) 99999-0000"}
        };
        
        for (int i = 0; i < fornecedoresData.length; i++) {
            String[] fornecedorData = fornecedoresData[i];
            long enderecoId = enderecoIds.get(i % enderecoIds.size()); // Distribuir endereços
            Fornecedor fornecedor = new Fornecedor(fornecedorData[0], fornecedorData[1], enderecoId);
            long id = fornecedorDAO.insert(fornecedor);
            fornecedorIds.add(id);
            Log.d("MockData", "Fornecedor criado: " + fornecedor + " com ID: " + id);
        }
        
        return fornecedorIds;
    }
    
    private static void criarProdutos(ProdutoDAO produtoDAO, List<Long> fornecedorIds) {
        String[][] produtosData = {
            {"Notebook Dell Inspiron", "unidade", "10.0", "3500.00", "true"},
            {"Mouse Wireless Logitech", "unidade", "50.0", "89.90", "true"},
            {"Teclado Mecânico RGB", "unidade", "25.0", "299.90", "true"},
            {"Monitor LG 24\"", "unidade", "15.0", "899.90", "true"},
            {"Webcam HD 1080p", "unidade", "30.0", "199.90", "true"},
            {"Headset Gamer", "unidade", "20.0", "399.90", "true"},
            {"SSD 500GB Kingston", "unidade", "40.0", "299.90", "true"},
            {"Memória RAM 8GB", "unidade", "60.0", "199.90", "true"},
            {"Placa de Vídeo GTX 1660", "unidade", "8.0", "1899.90", "false"},
            {"Processador Intel i7", "unidade", "12.0", "2499.90", "true"},
            {"Fonte 500W", "unidade", "18.0", "299.90", "true"},
            {"Gabinete ATX", "unidade", "22.0", "199.90", "true"},
            {"Cooler CPU", "unidade", "35.0", "149.90", "true"},
            {"Placa Mãe B450", "unidade", "10.0", "599.90", "false"},
            {"HD Externo 1TB", "unidade", "25.0", "399.90", "true"},
            {"Pendrive 32GB", "unidade", "100.0", "49.90", "true"},
            {"Cabo HDMI 2m", "unidade", "80.0", "29.90", "true"},
            {"Adaptador USB-C", "unidade", "120.0", "19.90", "true"},
            {"Suporte para Notebook", "unidade", "15.0", "89.90", "true"},
            {"Mousepad Gamer", "unidade", "45.0", "39.90", "true"}
        };
        
        for (int i = 0; i < produtosData.length; i++) {
            String[] produtoData = produtosData[i];
            long fornecedorId = fornecedorIds.get(i % fornecedorIds.size()); // Distribuir fornecedores
            boolean estoque = Boolean.parseBoolean(produtoData[4]);
            
            Produto produto = new Produto(
                produtoData[0], // descricao
                produtoData[1], // unidade
                Double.parseDouble(produtoData[2]), // quantidade
                Double.parseDouble(produtoData[3]), // valor
                estoque, // estoque
                fornecedorId // fornecedorId
            );
            
            long id = produtoDAO.insert(produto);
            Log.d("MockData", "Produto criado: " + produto + " com ID: " + id);
        }
    }
    
    public static void limparBancoDeDados(EnderecoDAO enderecoDAO, FornecedorDAO fornecedorDAO, ProdutoDAO produtoDAO) {
        Log.d("MockData", "Limpando banco de dados");
        
        produtoDAO.deleteAll();
        fornecedorDAO.deleteAll();
        enderecoDAO.deleteAll();
        
        Log.d("MockData", "Banco de dados limpo com sucesso!");
    }
    
    public static void exibirEstatisticas(EnderecoDAO enderecoDAO, FornecedorDAO fornecedorDAO, ProdutoDAO produtoDAO) {
        int totalEnderecos = enderecoDAO.getCount();
        int totalFornecedores = fornecedorDAO.getCount();
        int totalProdutos = produtoDAO.getCount();
        
        Log.i("MockData", "=== ESTATÍSTICAS DO BANCO ===");
        Log.i("MockData", "Total de Endereços: " + totalEnderecos);
        Log.i("MockData", "Total de Fornecedores: " + totalFornecedores);
        Log.i("MockData", "Total de Produtos: " + totalProdutos);
        Log.i("MockData", "=============================");
    }
} 