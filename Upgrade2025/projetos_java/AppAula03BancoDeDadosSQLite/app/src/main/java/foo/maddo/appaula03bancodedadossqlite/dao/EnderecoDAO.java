package foo.maddo.appaula03bancodedadossqlite.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import foo.maddo.appaula03bancodedadossqlite.database.DatabaseHelper;
import foo.maddo.appaula03bancodedadossqlite.model.Endereco;

public class EnderecoDAO {
    private DatabaseHelper dbHelper;
    private SQLiteDatabase database;

    public EnderecoDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    // CREATE - Inserir novo endereço
    public long insert(Endereco endereco) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_ENDERECO_ENDERECO, endereco.getEndereco());
        values.put(DatabaseHelper.COLUMN_ENDERECO_CIDADE, endereco.getCidade());
        values.put(DatabaseHelper.COLUMN_ENDERECO_ESTADO, endereco.getEstado());

        long id = database.insert(DatabaseHelper.TABLE_ENDERECO, null, values);
        Log.d("EnderecoDAO", "Endereço inserido com ID: " + id);
        return id;
    }

    // READ - Buscar endereço por ID
    public Endereco getById(long id) {
        Cursor cursor = database.query(
                DatabaseHelper.TABLE_ENDERECO,
                null,
                DatabaseHelper.COLUMN_ENDERECO_ID + " = ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null
        );

        Endereco endereco = null;
        if (cursor.moveToFirst()) {
            endereco = cursorToEndereco(cursor);
        }
        cursor.close();
        
        Log.d("EnderecoDAO", "Endereço buscado por ID " + id + ": " + endereco);
        return endereco;
    }

    // READ - Listar todos os endereços
    public List<Endereco> getAll() {
        List<Endereco> enderecos = new ArrayList<>();
        Cursor cursor = database.query(
                DatabaseHelper.TABLE_ENDERECO,
                null,
                null,
                null,
                null,
                null,
                DatabaseHelper.COLUMN_ENDERECO_ID + " ASC"
        );

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Endereco endereco = cursorToEndereco(cursor);
            enderecos.add(endereco);
            cursor.moveToNext();
        }
        cursor.close();
        
        Log.d("EnderecoDAO", "Listados " + enderecos.size() + " endereços");
        return enderecos;
    }

    // UPDATE - Atualizar endereço
    public int update(Endereco endereco) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_ENDERECO_ENDERECO, endereco.getEndereco());
        values.put(DatabaseHelper.COLUMN_ENDERECO_CIDADE, endereco.getCidade());
        values.put(DatabaseHelper.COLUMN_ENDERECO_ESTADO, endereco.getEstado());

        int rowsAffected = database.update(
                DatabaseHelper.TABLE_ENDERECO,
                values,
                DatabaseHelper.COLUMN_ENDERECO_ID + " = ?",
                new String[]{String.valueOf(endereco.getId())}
        );
        
        Log.d("EnderecoDAO", "Endereço atualizado. Linhas afetadas: " + rowsAffected);
        return rowsAffected;
    }

    // DELETE - Deletar endereço por ID
    public int delete(long id) {
        int rowsAffected = database.delete(
                DatabaseHelper.TABLE_ENDERECO,
                DatabaseHelper.COLUMN_ENDERECO_ID + " = ?",
                new String[]{String.valueOf(id)}
        );
        
        Log.d("EnderecoDAO", "Endereço deletado. Linhas afetadas: " + rowsAffected);
        return rowsAffected;
    }

    // DELETE - Deletar todos os endereços
    public int deleteAll() {
        int rowsAffected = database.delete(DatabaseHelper.TABLE_ENDERECO, null, null);
        Log.d("EnderecoDAO", "Todos os endereços deletados. Linhas afetadas: " + rowsAffected);
        return rowsAffected;
    }

    // Contar total de endereços
    public int getCount() {
        Cursor cursor = database.rawQuery("SELECT COUNT(*) FROM " + DatabaseHelper.TABLE_ENDERECO, null);
        int count = 0;
        if (cursor.moveToFirst()) {
            count = cursor.getInt(0);
        }
        cursor.close();
        
        Log.d("EnderecoDAO", "Total de endereços: " + count);
        return count;
    }

    // Buscar endereços por cidade
    public List<Endereco> getByCidade(String cidade) {
        List<Endereco> enderecos = new ArrayList<>();
        Cursor cursor = database.query(
                DatabaseHelper.TABLE_ENDERECO,
                null,
                DatabaseHelper.COLUMN_ENDERECO_CIDADE + " = ?",
                new String[]{cidade},
                null,
                null,
                DatabaseHelper.COLUMN_ENDERECO_ID + " ASC"
        );

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Endereco endereco = cursorToEndereco(cursor);
            enderecos.add(endereco);
            cursor.moveToNext();
        }
        cursor.close();
        
        Log.d("EnderecoDAO", "Endereços encontrados para cidade " + cidade + ": " + enderecos.size());
        return enderecos;
    }

    // Converter cursor para objeto Endereco
    private Endereco cursorToEndereco(Cursor cursor) {
        Endereco endereco = new Endereco();
        endereco.setId(cursor.getLong(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_ENDERECO_ID)));
        endereco.setEndereco(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_ENDERECO_ENDERECO)));
        endereco.setCidade(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_ENDERECO_CIDADE)));
        endereco.setEstado(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_ENDERECO_ESTADO)));
        return endereco;
    }
} 