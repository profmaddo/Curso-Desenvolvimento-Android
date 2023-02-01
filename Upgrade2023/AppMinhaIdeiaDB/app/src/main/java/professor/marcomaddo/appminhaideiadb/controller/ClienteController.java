package professor.marcomaddo.appminhaideiadb.controller;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import professor.marcomaddo.appminhaideiadb.api.AppUtil;
import professor.marcomaddo.appminhaideiadb.datamodel.ClienteDataModel;
import professor.marcomaddo.appminhaideiadb.datasource.AppDataBase;
import professor.marcomaddo.appminhaideiadb.model.Cliente;
import professor.marcomaddo.appminhaideiadb.model.Produto;

public class ClienteController extends AppDataBase implements ICrud<Cliente> {

    ContentValues dadoDoObjeto;

    public ClienteController(Context context) {
        super(context);

        Log.d(AppUtil.TAG, "ClienteController: Conectado");
    }

    @Override
    public boolean incluir(Cliente obj) {

        dadoDoObjeto = new ContentValues();
        // Key, Valor

        // dadoDoObjeto.put(ClienteDataModel.ID,obj.getId());
        // ID é chave primária da tabela cliente
        // é gerada automaticamente pelo SQLite a cada
        // novo registro adicionado
        // SQL ->>> INSERT INTO TABLE (... ... .. ) VALUES (### ### ###)
        dadoDoObjeto.put(ClienteDataModel.NOME,obj.getNome());
        dadoDoObjeto.put(ClienteDataModel.EMAIL,obj.getEmail());

        // Enviar os dados (dadoDoObjeto) para a classe AppDatabase
        // utilizando um método capaz de adicionar o OBJ no banco de
        // dados, tabela qualquer uma (Cliente)

        // Retorno sempre será FALSE ou VERDADEIRO
        return insert(ClienteDataModel.TABELA, dadoDoObjeto);


    }

    @Override
    public boolean deletar(int id) {
        return deleteByID(ClienteDataModel.TABELA,id);

    }

    @Override
    public boolean alterar(Cliente obj) {

        dadoDoObjeto = new ContentValues();
        // Key, Valor

        // ID é chave primária da tabela cliente
        // é gerada automaticamente pelo SQLite a cada
        // novo registro adicionado
        // Alterar
        // SQL ->>> UPDATE
        dadoDoObjeto.put(ClienteDataModel.ID,obj.getId());
        dadoDoObjeto.put(ClienteDataModel.NOME,obj.getNome());
        dadoDoObjeto.put(ClienteDataModel.EMAIL,obj.getEmail());

        // Enviar os dados (dadoDoObjeto) para a classe AppDatabase
        // utilizando um método capaz de alterar o OBJ no banco de
        // dados, tabela qualquer uma (Cliente), respeitando o ID
        // ou PK (Primary Key)

        return update(ClienteDataModel.TABELA,dadoDoObjeto);

    }

    @Override
    public List<Cliente> listar() {

        return getAllClientes(ClienteDataModel.TABELA);

    }

}
