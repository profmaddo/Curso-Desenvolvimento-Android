package foo.maddo.appaula03bancodedadossqlite.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import foo.maddo.appaula03bancodedadossqlite.database.DatabaseHelper;
import foo.maddo.appaula03bancodedadossqlite.model.Produto;

public class ProdutoDAO {
    private DatabaseHelper dbHelper;
    private SQLiteDatabase database;

    public ProdutoDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    // CREATE - Inserir novo produto
    public long insert(Produto produto) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_PRODUTO_DESCRICAO, produto.getDescricao());
        values.put(DatabaseHelper.COLUMN_PRODUTO_UNIDADE, produto.getUnidade());
        values.put(DatabaseHelper.COLUMN_PRODUTO_QUANTIDADE, produto.getQuantidade());
        values.put(DatabaseHelper.COLUMN_PRODUTO_VALOR, produto.getValor());
        values.put(DatabaseHelper.COLUMN_PRODUTO_ESTOQUE, produto.isEstoque() ? 1 : 0);
        values.put(DatabaseHelper.COLUMN_PRODUTO_FORNECEDOR_ID, produto.getFornecedorId());

        long id = database.insert(DatabaseHelper.TABLE_PRODUTO, null, values);
        Log.d("ProdutoDAO", "Produto inserido com ID: " + id);
        return id;
    }

    // READ - Buscar produto por ID
    public Produto getById(long id) {
        Cursor cursor = database.query(
                DatabaseHelper.TABLE_PRODUTO,
                null,
                DatabaseHelper.COLUMN_PRODUTO_ID + " = ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null
        );

        Produto produto = null;
        if (cursor.moveToFirst()) {
            produto = cursorToProduto(cursor);
        }
        cursor.close();
        
        Log.d("ProdutoDAO", "Produto buscado por ID " + id + ": " + produto);
        return produto;
    }

    // READ - Listar todos os produtos
    public List<Produto> getAll() {
        List<Produto> produtos = new ArrayList<>();
        Cursor cursor = database.query(
                DatabaseHelper.TABLE_PRODUTO,
                null,
                null,
                null,
                null,
                null,
                DatabaseHelper.COLUMN_PRODUTO_ID + " ASC"
        );

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Produto produto = cursorToProduto(cursor);
            produtos.add(produto);
            cursor.moveToNext();
        }
        cursor.close();
        
        Log.d("ProdutoDAO", "Listados " + produtos.size() + " produtos");
        return produtos;
    }

    // READ - Buscar produtos com JOIN para fornecedor
    public List<Produto> getAllWithFornecedor() {
        List<Produto> produtos = new ArrayList<>();
        String query = "SELECT p.*, f.nome as fornecedor_nome, f.contato as fornecedor_contato " +
                      "FROM " + DatabaseHelper.TABLE_PRODUTO + " p " +
                      "LEFT JOIN " + DatabaseHelper.TABLE_FORNECEDOR + " f " +
                      "ON p." + DatabaseHelper.COLUMN_PRODUTO_FORNECEDOR_ID + " = f." + DatabaseHelper.COLUMN_FORNECEDOR_ID + " " +
                      "ORDER BY p." + DatabaseHelper.COLUMN_PRODUTO_ID + " ASC";

        Cursor cursor = database.rawQuery(query, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Produto produto = cursorToProdutoWithFornecedor(cursor);
            produtos.add(produto);
            cursor.moveToNext();
        }
        cursor.close();
        
        Log.d("ProdutoDAO", "Listados " + produtos.size() + " produtos com fornecedor");
        return produtos;
    }

    // UPDATE - Atualizar produto
    public int update(Produto produto) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_PRODUTO_DESCRICAO, produto.getDescricao());
        values.put(DatabaseHelper.COLUMN_PRODUTO_UNIDADE, produto.getUnidade());
        values.put(DatabaseHelper.COLUMN_PRODUTO_QUANTIDADE, produto.getQuantidade());
        values.put(DatabaseHelper.COLUMN_PRODUTO_VALOR, produto.getValor());
        values.put(DatabaseHelper.COLUMN_PRODUTO_ESTOQUE, produto.isEstoque() ? 1 : 0);
        values.put(DatabaseHelper.COLUMN_PRODUTO_FORNECEDOR_ID, produto.getFornecedorId());

        int rowsAffected = database.update(
                DatabaseHelper.TABLE_PRODUTO,
                values,
                DatabaseHelper.COLUMN_PRODUTO_ID + " = ?",
                new String[]{String.valueOf(produto.getId())}
        );
        
        Log.d("ProdutoDAO", "Produto atualizado. Linhas afetadas: " + rowsAffected);
        return rowsAffected;
    }

    // DELETE - Deletar produto por ID
    public int delete(long id) {
        int rowsAffected = database.delete(
                DatabaseHelper.TABLE_PRODUTO,
                DatabaseHelper.COLUMN_PRODUTO_ID + " = ?",
                new String[]{String.valueOf(id)}
        );
        
        Log.d("ProdutoDAO", "Produto deletado. Linhas afetadas: " + rowsAffected);
        return rowsAffected;
    }

    // DELETE - Deletar todos os produtos
    public int deleteAll() {
        int rowsAffected = database.delete(DatabaseHelper.TABLE_PRODUTO, null, null);
        Log.d("ProdutoDAO", "Todos os produtos deletados. Linhas afetadas: " + rowsAffected);
        return rowsAffected;
    }

    // Contar total de produtos
    public int getCount() {
        Cursor cursor = database.rawQuery("SELECT COUNT(*) FROM " + DatabaseHelper.TABLE_PRODUTO, null);
        int count = 0;
        if (cursor.moveToFirst()) {
            count = cursor.getInt(0);
        }
        cursor.close();
        
        Log.d("ProdutoDAO", "Total de produtos: " + count);
        return count;
    }

    // Buscar produtos por descrição
    public List<Produto> getByDescricao(String descricao) {
        List<Produto> produtos = new ArrayList<>();
        Cursor cursor = database.query(
                DatabaseHelper.TABLE_PRODUTO,
                null,
                DatabaseHelper.COLUMN_PRODUTO_DESCRICAO + " LIKE ?",
                new String[]{"%" + descricao + "%"},
                null,
                null,
                DatabaseHelper.COLUMN_PRODUTO_ID + " ASC"
        );

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Produto produto = cursorToProduto(cursor);
            produtos.add(produto);
            cursor.moveToNext();
        }
        cursor.close();
        
        Log.d("ProdutoDAO", "Produtos encontrados para descrição " + descricao + ": " + produtos.size());
        return produtos;
    }

    // Buscar produtos por fornecedor
    public List<Produto> getByFornecedorId(long fornecedorId) {
        List<Produto> produtos = new ArrayList<>();
        Cursor cursor = database.query(
                DatabaseHelper.TABLE_PRODUTO,
                null,
                DatabaseHelper.COLUMN_PRODUTO_FORNECEDOR_ID + " = ?",
                new String[]{String.valueOf(fornecedorId)},
                null,
                null,
                DatabaseHelper.COLUMN_PRODUTO_ID + " ASC"
        );

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Produto produto = cursorToProduto(cursor);
            produtos.add(produto);
            cursor.moveToNext();
        }
        cursor.close();
        
        Log.d("ProdutoDAO", "Produtos encontrados para fornecedor " + fornecedorId + ": " + produtos.size());
        return produtos;
    }

    // Buscar produtos em estoque
    public List<Produto> getEmEstoque() {
        List<Produto> produtos = new ArrayList<>();
        Cursor cursor = database.query(
                DatabaseHelper.TABLE_PRODUTO,
                null,
                DatabaseHelper.COLUMN_PRODUTO_ESTOQUE + " = ?",
                new String[]{"1"},
                null,
                null,
                DatabaseHelper.COLUMN_PRODUTO_ID + " ASC"
        );

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Produto produto = cursorToProduto(cursor);
            produtos.add(produto);
            cursor.moveToNext();
        }
        cursor.close();
        
        Log.d("ProdutoDAO", "Produtos em estoque: " + produtos.size());
        return produtos;
    }

    // Buscar produtos por faixa de preço
    public List<Produto> getByFaixaPreco(double precoMin, double precoMax) {
        List<Produto> produtos = new ArrayList<>();
        Cursor cursor = database.query(
                DatabaseHelper.TABLE_PRODUTO,
                null,
                DatabaseHelper.COLUMN_PRODUTO_VALOR + " BETWEEN ? AND ?",
                new String[]{String.valueOf(precoMin), String.valueOf(precoMax)},
                null,
                null,
                DatabaseHelper.COLUMN_PRODUTO_VALOR + " ASC"
        );

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Produto produto = cursorToProduto(cursor);
            produtos.add(produto);
            cursor.moveToNext();
        }
        cursor.close();
        
        Log.d("ProdutoDAO", "Produtos encontrados na faixa de preço " + precoMin + " - " + precoMax + ": " + produtos.size());
        return produtos;
    }

    // Converter cursor para objeto Produto
    private Produto cursorToProduto(Cursor cursor) {
        Produto produto = new Produto();
        produto.setId(cursor.getLong(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_PRODUTO_ID)));
        produto.setDescricao(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_PRODUTO_DESCRICAO)));
        produto.setUnidade(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_PRODUTO_UNIDADE)));
        produto.setQuantidade(cursor.getDouble(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_PRODUTO_QUANTIDADE)));
        produto.setValor(cursor.getDouble(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_PRODUTO_VALOR)));
        produto.setEstoque(cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_PRODUTO_ESTOQUE)) == 1);
        produto.setFornecedorId(cursor.getLong(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_PRODUTO_FORNECEDOR_ID)));
        return produto;
    }

    // Converter cursor para objeto Produto com dados do fornecedor
    private Produto cursorToProdutoWithFornecedor(Cursor cursor) {
        Produto produto = cursorToProduto(cursor);
        // Aqui você pode adicionar lógica para carregar o objeto Fornecedor completo
        // se necessário para exibição
        return produto;
    }
} 