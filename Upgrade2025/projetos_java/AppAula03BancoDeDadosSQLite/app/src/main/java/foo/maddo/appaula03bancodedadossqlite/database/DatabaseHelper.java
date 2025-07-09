package foo.maddo.appaula03bancodedadossqlite.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "AppAula03DB";
    private static final int DATABASE_VERSION = 1;

    // Tabela Endereco
    public static final String TABLE_ENDERECO = "endereco";
    public static final String COLUMN_ENDERECO_ID = "id";
    public static final String COLUMN_ENDERECO_ENDERECO = "endereco";
    public static final String COLUMN_ENDERECO_CIDADE = "cidade";
    public static final String COLUMN_ENDERECO_ESTADO = "estado";

    // Tabela Fornecedor
    public static final String TABLE_FORNECEDOR = "fornecedor";
    public static final String COLUMN_FORNECEDOR_ID = "id";
    public static final String COLUMN_FORNECEDOR_NOME = "nome";
    public static final String COLUMN_FORNECEDOR_CONTATO = "contato";
    public static final String COLUMN_FORNECEDOR_ENDERECO_ID = "endereco_id";

    // Tabela Produto
    public static final String TABLE_PRODUTO = "produto";
    public static final String COLUMN_PRODUTO_ID = "id";
    public static final String COLUMN_PRODUTO_DESCRICAO = "descricao";
    public static final String COLUMN_PRODUTO_UNIDADE = "unidade";
    public static final String COLUMN_PRODUTO_QUANTIDADE = "quantidade";
    public static final String COLUMN_PRODUTO_VALOR = "valor";
    public static final String COLUMN_PRODUTO_ESTOQUE = "estoque";
    public static final String COLUMN_PRODUTO_FORNECEDOR_ID = "fornecedor_id";

    // Tabela de relacionamento muitos-para-muitos entre Produto e Fornecedor
    public static final String TABLE_PRODUTO_FORNECEDOR = "produto_fornecedor";
    public static final String COLUMN_PRODUTO_FORNECEDOR_PRODUTO_ID = "produto_id";
    public static final String COLUMN_PRODUTO_FORNECEDOR_FORNECEDOR_ID = "fornecedor_id";

    // SQL para criar tabelas
    private static final String CREATE_TABLE_ENDERECO = 
            "CREATE TABLE " + TABLE_ENDERECO + " (" +
                    COLUMN_ENDERECO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_ENDERECO_ENDERECO + " TEXT NOT NULL, " +
                    COLUMN_ENDERECO_CIDADE + " TEXT NOT NULL, " +
                    COLUMN_ENDERECO_ESTADO + " TEXT NOT NULL)";

    private static final String CREATE_TABLE_FORNECEDOR = 
            "CREATE TABLE " + TABLE_FORNECEDOR + " (" +
                    COLUMN_FORNECEDOR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_FORNECEDOR_NOME + " TEXT NOT NULL, " +
                    COLUMN_FORNECEDOR_CONTATO + " TEXT NOT NULL, " +
                    COLUMN_FORNECEDOR_ENDERECO_ID + " INTEGER, " +
                    "FOREIGN KEY(" + COLUMN_FORNECEDOR_ENDERECO_ID + ") REFERENCES " + 
                    TABLE_ENDERECO + "(" + COLUMN_ENDERECO_ID + "))";

    private static final String CREATE_TABLE_PRODUTO = 
            "CREATE TABLE " + TABLE_PRODUTO + " (" +
                    COLUMN_PRODUTO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_PRODUTO_DESCRICAO + " TEXT NOT NULL, " +
                    COLUMN_PRODUTO_UNIDADE + " TEXT NOT NULL, " +
                    COLUMN_PRODUTO_QUANTIDADE + " REAL NOT NULL, " +
                    COLUMN_PRODUTO_VALOR + " REAL NOT NULL, " +
                    COLUMN_PRODUTO_ESTOQUE + " INTEGER NOT NULL, " +
                    COLUMN_PRODUTO_FORNECEDOR_ID + " INTEGER, " +
                    "FOREIGN KEY(" + COLUMN_PRODUTO_FORNECEDOR_ID + ") REFERENCES " + 
                    TABLE_FORNECEDOR + "(" + COLUMN_FORNECEDOR_ID + "))";

    private static final String CREATE_TABLE_PRODUTO_FORNECEDOR = 
            "CREATE TABLE " + TABLE_PRODUTO_FORNECEDOR + " (" +
                    COLUMN_PRODUTO_FORNECEDOR_PRODUTO_ID + " INTEGER, " +
                    COLUMN_PRODUTO_FORNECEDOR_FORNECEDOR_ID + " INTEGER, " +
                    "PRIMARY KEY(" + COLUMN_PRODUTO_FORNECEDOR_PRODUTO_ID + ", " + 
                    COLUMN_PRODUTO_FORNECEDOR_FORNECEDOR_ID + "), " +
                    "FOREIGN KEY(" + COLUMN_PRODUTO_FORNECEDOR_PRODUTO_ID + ") REFERENCES " + 
                    TABLE_PRODUTO + "(" + COLUMN_PRODUTO_ID + "), " +
                    "FOREIGN KEY(" + COLUMN_PRODUTO_FORNECEDOR_FORNECEDOR_ID + ") REFERENCES " + 
                    TABLE_FORNECEDOR + "(" + COLUMN_FORNECEDOR_ID + "))";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("DatabaseHelper", "Criando tabelas do banco de dados");
        
        // Criar tabelas na ordem correta (respeitando as foreign keys)
        db.execSQL(CREATE_TABLE_ENDERECO);
        db.execSQL(CREATE_TABLE_FORNECEDOR);
        db.execSQL(CREATE_TABLE_PRODUTO);
        db.execSQL(CREATE_TABLE_PRODUTO_FORNECEDOR);
        
        Log.d("DatabaseHelper", "Tabelas criadas com sucesso");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("DatabaseHelper", "Atualizando banco de dados de versão " + oldVersion + " para " + newVersion);
        
        // Drop das tabelas na ordem inversa (respeitando as foreign keys)
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUTO_FORNECEDOR);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUTO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FORNECEDOR);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ENDERECO);
        
        // Recriar as tabelas
        onCreate(db);
    }
} 