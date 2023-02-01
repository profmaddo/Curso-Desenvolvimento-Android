package professor.marcomaddo.appminhaideiadb.datamodel;

public class ProdutoDataModel {

    // Modelo Objeto Relacional

    // Toda Classe Data Model tem esta estrutura

    // 1 - Atributo nome da tabela
    public static final String TABELA = "produto";

    // 2 - Atributos um para um com os nomes dos campos

    public static final String ID = "id"; // integer
    public static final String NOME = "nome"; // text
    public static final String FORNECEDOR = "fornecedor"; // text

    // 3 - Query para criar a tabela no banco de dados
    public static String queryCriarTabela = "";

    // // 4 - Método para gerar o Script para criar a tabela;

    public static String criarTabela(){

        // Concatenação de String

        queryCriarTabela += "CREATE TABLE "+TABELA+" (";
        queryCriarTabela += ID+" integer primary key autoincrement, ";
        queryCriarTabela += NOME+" text, "; // nome text
        queryCriarTabela += FORNECEDOR +" text ";
        queryCriarTabela += ")";

        // queryCriarTabela = "Parte 01 Parte 02 Parte 03 Parte 04"

        return queryCriarTabela;
    }

}
