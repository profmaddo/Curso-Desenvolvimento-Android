package android.curso.mediaescolarmvc.datamodel;

/**
 * Created by marcomaddo on 18/01/2018.
 */

public class MediaEscolarDataModel {

    // Dados para criar as tabelas no banco de dados
    // MOR - Modelo objeto relacional
    // TUPLA ou Registros

    private final static String TABELA = "media_escolar";

    private final static String id = "id";
    private final static String materia = "materia";
    private final static String bimestre = "bimestre";
    private final static String situacao = "situacao";
    private final static String notaProva = "notaProva";
    private final static String notaMateria = "notaMateria";
    private final static String mediaFinal = "mediaFinal";

    private static String queryCriarTabela = "";


    // Criar dinamicamente uma query SQL para criar
    // a tabela Média Escolar no Banco de Dados

    public static String criarTabela(){

        queryCriarTabela = "CREATE TABLE "+TABELA;
        queryCriarTabela += "(";
        queryCriarTabela += id + " INTEGER PRIMARY KEY AUTOINCREMENT, ";
        queryCriarTabela += materia + " TEXT, ";
        queryCriarTabela += bimestre + " TEXT, ";
        queryCriarTabela += situacao + " TEXT, ";
        queryCriarTabela += notaProva + " REAL, ";
        queryCriarTabela += notaMateria + " REAL, ";
        queryCriarTabela += mediaFinal + " REAL ";
        queryCriarTabela += ")";

        return  queryCriarTabela;
    }

    public static String getTABELA() {
        return TABELA;
    }

    public static String getId() {
        return id;
    }

    public static String getMateria() {
        return materia;
    }

    public static String getBimestre() {
        return bimestre;
    }

    public static String getSituacao() {
        return situacao;
    }

    public static String getNotaProva() {
        return notaProva;
    }

    public static String getNotaMateria() {
        return notaMateria;
    }

    public static String getMediaFinal() {
        return mediaFinal;
    }

    public static String getQueryCriarTabela() {
        return queryCriarTabela;
    }

    public static void setQueryCriarTabela(String queryCriarTabela) {
        MediaEscolarDataModel.queryCriarTabela = queryCriarTabela;
    }



}
