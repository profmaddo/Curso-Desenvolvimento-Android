package foo.maddo.appminhaideiadb.controller;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import foo.maddo.appminhaideiadb.datamodel.ProdutoDataModel;
import foo.maddo.appminhaideiadb.datasource.AppDataBase;
import foo.maddo.appminhaideiadb.model.Produto;


public class ProdutoController extends AppDataBase implements ICrud<Produto> {

    ContentValues dadoDoObjeto;

    public ProdutoController(Context context) {
        super(context);
    }

    @Override
    public boolean incluir(Produto obj) {

        dadoDoObjeto = new ContentValues();

        dadoDoObjeto.put(ProdutoDataModel.NOME,obj.getNome());
        dadoDoObjeto.put(ProdutoDataModel.FORNECEDOR,obj.getFornecedor());

        return insert(ProdutoDataModel.TABELA, dadoDoObjeto);
    }

    @Override
    public boolean alterar(Produto obj) {

        dadoDoObjeto = new ContentValues();

        dadoDoObjeto.put(ProdutoDataModel.ID,obj.getId());
        dadoDoObjeto.put(ProdutoDataModel.NOME,obj.getNome());
        dadoDoObjeto.put(ProdutoDataModel.FORNECEDOR,obj.getFornecedor());

        return false;
    }

    @Override
    public boolean deletar(int id) {



        return false;
    }

    @Override
    public List<Produto> listar() {

        List<Produto> lista = new ArrayList<>();

        return lista;
    }

}
