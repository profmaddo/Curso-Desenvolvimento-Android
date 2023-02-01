package professor.marcomaddo.appminhaideiadb.model;

import android.util.Log;

import professor.marcomaddo.appminhaideiadb.api.AppUtil;
import professor.marcomaddo.appminhaideiadb.controller.ICrud;

// Pojo
public class Produto  {
    
    private int id;
    private String nome;
    private String fornecedor;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
