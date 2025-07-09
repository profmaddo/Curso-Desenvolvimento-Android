package foo.maddo.appaula03bancodedadossqlite.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import foo.maddo.appaula03bancodedadossqlite.database.DatabaseHelper;
import foo.maddo.appaula03bancodedadossqlite.model.Fornecedor;

public class FornecedorDAO {
    private DatabaseHelper dbHelper;
    private SQLiteDatabase database;

    public FornecedorDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    // CREATE - Inserir novo fornecedor
    public long insert(Fornecedor fornecedor) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_FORNECEDOR_NOME, fornecedor.getNome());
        values.put(DatabaseHelper.COLUMN_FORNECEDOR_CONTATO, fornecedor.getContato());
        values.put(DatabaseHelper.COLUMN_FORNECEDOR_ENDERECO_ID, fornecedor.getEnderecoId());

        long id = database.insert(DatabaseHelper.TABLE_FORNECEDOR, null, values);
        Log.d("FornecedorDAO", "Fornecedor inserido com ID: " + id);
        return id;
    }

    // READ - Buscar fornecedor por ID
    public Fornecedor getById(long id) {
        Cursor cursor = database.query(
                DatabaseHelper.TABLE_FORNECEDOR,
                null,
                DatabaseHelper.COLUMN_FORNECEDOR_ID + " = ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null
        );

        Fornecedor fornecedor = null;
        if (cursor.moveToFirst()) {
            fornecedor = cursorToFornecedor(cursor);
        }
        cursor.close();
        
        Log.d("FornecedorDAO", "Fornecedor buscado por ID " + id + ": " + fornecedor);
        return fornecedor;
    }

    // READ - Listar todos os fornecedores
    public List<Fornecedor> getAll() {
        List<Fornecedor> fornecedores = new ArrayList<>();
        Cursor cursor = database.query(
                DatabaseHelper.TABLE_FORNECEDOR,
                null,
                null,
                null,
                null,
                null,
                DatabaseHelper.COLUMN_FORNECEDOR_ID + " ASC"
        );

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Fornecedor fornecedor = cursorToFornecedor(cursor);
            fornecedores.add(fornecedor);
            cursor.moveToNext();
        }
        cursor.close();
        
        Log.d("FornecedorDAO", "Listados " + fornecedores.size() + " fornecedores");
        return fornecedores;
    }

    // READ - Buscar fornecedores com JOIN para endereço
    public List<Fornecedor> getAllWithEndereco() {
        List<Fornecedor> fornecedores = new ArrayList<>();
        String query = "SELECT f.*, e.endereco, e.cidade, e.estado " +
                      "FROM " + DatabaseHelper.TABLE_FORNECEDOR + " f " +
                      "LEFT JOIN " + DatabaseHelper.TABLE_ENDERECO + " e " +
                      "ON f." + DatabaseHelper.COLUMN_FORNECEDOR_ENDERECO_ID + " = e." + DatabaseHelper.COLUMN_ENDERECO_ID + " " +
                      "ORDER BY f." + DatabaseHelper.COLUMN_FORNECEDOR_ID + " ASC";

        Cursor cursor = database.rawQuery(query, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Fornecedor fornecedor = cursorToFornecedorWithEndereco(cursor);
            fornecedores.add(fornecedor);
            cursor.moveToNext();
        }
        cursor.close();
        
        Log.d("FornecedorDAO", "Listados " + fornecedores.size() + " fornecedores com endereço");
        return fornecedores;
    }

    // UPDATE - Atualizar fornecedor
    public int update(Fornecedor fornecedor) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_FORNECEDOR_NOME, fornecedor.getNome());
        values.put(DatabaseHelper.COLUMN_FORNECEDOR_CONTATO, fornecedor.getContato());
        values.put(DatabaseHelper.COLUMN_FORNECEDOR_ENDERECO_ID, fornecedor.getEnderecoId());

        int rowsAffected = database.update(
                DatabaseHelper.TABLE_FORNECEDOR,
                values,
                DatabaseHelper.COLUMN_FORNECEDOR_ID + " = ?",
                new String[]{String.valueOf(fornecedor.getId())}
        );
        
        Log.d("FornecedorDAO", "Fornecedor atualizado. Linhas afetadas: " + rowsAffected);
        return rowsAffected;
    }

    // DELETE - Deletar fornecedor por ID
    public int delete(long id) {
        int rowsAffected = database.delete(
                DatabaseHelper.TABLE_FORNECEDOR,
                DatabaseHelper.COLUMN_FORNECEDOR_ID + " = ?",
                new String[]{String.valueOf(id)}
        );
        
        Log.d("FornecedorDAO", "Fornecedor deletado. Linhas afetadas: " + rowsAffected);
        return rowsAffected;
    }

    // DELETE - Deletar todos os fornecedores
    public int deleteAll() {
        int rowsAffected = database.delete(DatabaseHelper.TABLE_FORNECEDOR, null, null);
        Log.d("FornecedorDAO", "Todos os fornecedores deletados. Linhas afetadas: " + rowsAffected);
        return rowsAffected;
    }

    // Contar total de fornecedores
    public int getCount() {
        Cursor cursor = database.rawQuery("SELECT COUNT(*) FROM " + DatabaseHelper.TABLE_FORNECEDOR, null);
        int count = 0;
        if (cursor.moveToFirst()) {
            count = cursor.getInt(0);
        }
        cursor.close();
        
        Log.d("FornecedorDAO", "Total de fornecedores: " + count);
        return count;
    }

    // Buscar fornecedores por nome
    public List<Fornecedor> getByNome(String nome) {
        List<Fornecedor> fornecedores = new ArrayList<>();
        Cursor cursor = database.query(
                DatabaseHelper.TABLE_FORNECEDOR,
                null,
                DatabaseHelper.COLUMN_FORNECEDOR_NOME + " LIKE ?",
                new String[]{"%" + nome + "%"},
                null,
                null,
                DatabaseHelper.COLUMN_FORNECEDOR_ID + " ASC"
        );

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Fornecedor fornecedor = cursorToFornecedor(cursor);
            fornecedores.add(fornecedor);
            cursor.moveToNext();
        }
        cursor.close();
        
        Log.d("FornecedorDAO", "Fornecedores encontrados para nome " + nome + ": " + fornecedores.size());
        return fornecedores;
    }

    // Buscar fornecedores por endereço
    public List<Fornecedor> getByEnderecoId(long enderecoId) {
        List<Fornecedor> fornecedores = new ArrayList<>();
        Cursor cursor = database.query(
                DatabaseHelper.TABLE_FORNECEDOR,
                null,
                DatabaseHelper.COLUMN_FORNECEDOR_ENDERECO_ID + " = ?",
                new String[]{String.valueOf(enderecoId)},
                null,
                null,
                DatabaseHelper.COLUMN_FORNECEDOR_ID + " ASC"
        );

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Fornecedor fornecedor = cursorToFornecedor(cursor);
            fornecedores.add(fornecedor);
            cursor.moveToNext();
        }
        cursor.close();
        
        Log.d("FornecedorDAO", "Fornecedores encontrados para endereço " + enderecoId + ": " + fornecedores.size());
        return fornecedores;
    }

    // Converter cursor para objeto Fornecedor
    private Fornecedor cursorToFornecedor(Cursor cursor) {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setId(cursor.getLong(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_FORNECEDOR_ID)));
        fornecedor.setNome(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_FORNECEDOR_NOME)));
        fornecedor.setContato(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_FORNECEDOR_CONTATO)));
        fornecedor.setEnderecoId(cursor.getLong(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_FORNECEDOR_ENDERECO_ID)));
        return fornecedor;
    }

    // Converter cursor para objeto Fornecedor com dados do endereço
    private Fornecedor cursorToFornecedorWithEndereco(Cursor cursor) {
        Fornecedor fornecedor = cursorToFornecedor(cursor);
        // Aqui você pode adicionar lógica para carregar o objeto Endereco completo
        // se necessário para exibição
        return fornecedor;
    }
} 